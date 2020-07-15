package com.martirosyan.lesson12;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class MainApp {

    public static void main(String[] args) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        ReflectionRepository<Pet> petReflectionRepository = new ReflectionRepository<Pet>("jdbc:postgresql://localhost:5432/postgres?currentSchema=app_schema");

        for (Pet pet : petReflectionRepository.findAll()) {
            System.out.println(pet);
        }
    }
}
