package com.martirosyan.lesson11;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Tester {

    // Пожалуйса подскажите как сделать так же на стримах но аккуратненько.
    // Во-первых стримы нельзя переиспользовать и надо все время получать новый стрим из массива.
    // Во-вторых хотелось бы делать проверку на единичноть и запуск методов помеченных beforeSuite в одном месте а не в этих ифах
    // В-третьих столко трай-кетчей(((((((((((((((
    public static void start(Class testClass) {
        Method[] methods = testClass.getDeclaredMethods();
        try {
            Object instance = testClass.getDeclaredConstructor().newInstance();

            if (Arrays.stream(methods).filter(m -> m.isAnnotationPresent(BeforeSuite.class)).count() > 1) {
                throw new RuntimeException();
            } else {
                Arrays.stream(methods).filter(m -> m.isAnnotationPresent(BeforeSuite.class)).findFirst()
                        .ifPresent(x -> {
                            try {
                                x.invoke(instance);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        });
            }

            Arrays.stream(methods).filter(m -> m.isAnnotationPresent(Test.class))
                    .sorted(Comparator.comparingInt(x -> x.getAnnotation(Test.class).value()))
                    .forEach(x -> {
                        try {
                            x.invoke(testClass.getDeclaredConstructor().newInstance());
                        } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                    });

            if (Arrays.stream(methods).filter(m -> m.isAnnotationPresent(AfterSuite.class)).count() > 1) {
                throw new RuntimeException();
            } else {
                Arrays.stream(methods).filter(m -> m.isAnnotationPresent(AfterSuite.class)).findFirst()
                        .ifPresent(x -> {
                            try {
                                x.invoke(instance);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        });
            }

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
