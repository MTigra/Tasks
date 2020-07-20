package com.martirosyan.lesson12;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReflectionRepository<T> {

    private Connection con;
    Class<T> tableClass;

    public ReflectionRepository(Class<T> tableClass, Connection con) {
        this.con = con;
        this.tableClass = tableClass;
    }

    public ReflectionRepository(String constr) throws SQLException {
        this.con = DriverManager.getConnection(constr);
    }

    public T findById(int id) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(tableClass.getAnnotation(DbTable.class).name())
                .append(" WHERE ")
                .append("id = " + id);
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(sb.toString());
        List<T> objectList = mapRsToObjList(resultSet);
        return objectList.isEmpty() ? null : objectList.get(0);
    }


    public void deleteById(int id) {
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(tableClass.getAnnotation(DbTable.class).name())
                .append(" WHERE ")
                .append("id = " + id);
    }

    public void deleteAll() throws SQLException {
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(tableClass.getAnnotation(DbTable.class).name());
        Statement st = con.createStatement();
        st.execute(sb.toString());
    }

    public List<T> findAll() throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(tableClass.getAnnotation(DbTable.class).name());
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(sb.toString());
        return mapRsToObjList(resultSet);
    }


    private List<T> mapRsToObjList(ResultSet resultSet) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        List<Field> fields = Arrays.stream(tableClass.getDeclaredFields())
                .peek(x -> x.setAccessible(true))
                .filter(f -> f.isAnnotationPresent(DbColumn.class))
                .collect(Collectors.toList());
        List<T> objectList = new ArrayList<>();

        while (resultSet.next()) {
            T obj = tableClass.getDeclaredConstructor().newInstance();
            for (Field f : fields) {
                String value = resultSet.getString(f.getName().toLowerCase());
                switch (f.getType().getSimpleName()) {
                    case "long":
                    case "Long":
                        f.set(obj, Long.parseLong(value));
                        break;
                    case "String":
                        f.set(obj, value);
                        break;
                    case "int":
                    case "Integer":
                        f.set(obj, Integer.parseInt(value));
                        break;
                }
            }
            objectList.add(obj);
        }
        return objectList;
    }


}
