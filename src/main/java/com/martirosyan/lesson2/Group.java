package com.martirosyan.lesson2;

import java.util.Arrays;

public class Group {
    private final Employee[] employees = new Employee[10];


    public void addEmployee(Employee emp) {
        int i = 0;
        while (i < employees.length && (employees[i] != null)) {
            i++;
        }
        if (i == 10) {
            throw new NoEnoughPlaceException();
        }
        employees[i] = emp;

    }

    public void deleteEmployeeByIdx(int i) {
        if(i<0 || i>=employees.length){
            throw new IndexOutOfBoundsException();
        }
        employees[i] = null;
    }

    public void deleteAll() {
        Arrays.fill(employees, null);
    }

    @Override
    public String toString() {
        return "Group{" +
                "employees=" + Arrays.toString(employees) +
                '}';
    }

    public void showAllInfo() {
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println(emp);
            }
        }
    }
}
