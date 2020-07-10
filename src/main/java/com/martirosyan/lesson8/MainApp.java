package com.martirosyan.lesson8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainApp {

    static Random rnd = new Random();


    public static void main(String[] args) {
        filterMoreThan5();
        findUniqueWords();
        sumOfEven();
        sumOfLineLengths();
        first3Words();
    }

    public static void filterMoreThan5() {
        System.out.println("Задание 1:\n");
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Duis nibh quam, blandit ac tortor vitae, imperdiet dignissim tellus. " +
                "Pellentesque laoreet, augue vel auctor volutpat, leo lacus semper libero, " +
                "sed tempus purus erat sit amet tortor. Ut ornare felis in purus porta, a malesuada" +
                " nisl porttitor. Maecenas facilisis arcu a enim rhoncus varius. Nullam sit amet sodales enim," +
                " a venenatis odio. Proin sodales ligula dolor, ac varius leo ornare egestas. Quisque venenatis " +
                "laoreet neque. Proin quis ipsum quis mauris eleifend auctor vitae sit amet tortor." +
                " Praesent quis est quis magna vulputate sodales. Phasellus at nisl in ipsum condimentum" +
                " vehicula. Morbi laoreet.";
        text = text.replaceAll("[,.]", "");
        String res = Arrays.stream(text.split(" ")).map(String::toLowerCase).filter(w -> w.length() > 5)
                .collect(Collectors.joining(", ", "", "."));
        System.out.println(res + "\n");
    }

    public static void findUniqueWords() {
        System.out.println("Задание 2:\n");

        String[][] wordMatrix = new String[5][5];

        List<String> generatedStrings = Stream.generate(String::new).limit(25).map(
                (x) -> rnd.ints('a', 'z')
                        .limit(rnd.nextInt(6) + 4)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString()).collect(Collectors.toList());

        for (int i = 0; i < wordMatrix.length; i++) {
            for (int j = 0; j < wordMatrix[i].length; j++) {
                wordMatrix[i][j] = generatedStrings.get(i + j);
            }
        }
        Arrays.stream(wordMatrix).flatMap(Arrays::stream).distinct().forEach(System.out::println);
        System.out.println("\n");
    }

    public static void sumOfEven() {
        System.out.println("Задание 3:\n");

        Random rnd = new Random();
        int sum = rnd.ints(1000, 10, 500)
                .filter(x -> x % 2 == 0)
                .filter(x -> x >= 100 && x <= 200)
                .sum();
        System.out.println(sum + "\n");

    }

    public static void sumOfLineLengths() {

        System.out.println("Задание 4:\n");

        List<String> generatedStrings = Stream.generate(String::new).limit(25).map(
                (x) -> rnd.ints('a', 'z')
                        .limit(rnd.nextInt(32) + 4)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString()).collect(Collectors.toList());
        String[] arr = generatedStrings.toArray(String[]::new);

        int sum = Arrays.stream(arr).map(String::length).reduce(0, Integer::sum);
        System.out.println(sum + "\n");
    }

    public static void first3Words() {
        System.out.println("Задание 5:\n");

        List<String> generatedStrings = Stream.generate(String::new)
                .limit(25).map(
                        (x) -> rnd.ints('a', 'z')
                                .limit(rnd.nextInt(10) + 4)
                                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                                .toString())
                .collect(Collectors.toList());

        String[] arr = generatedStrings.toArray(String[]::new);

        String res = Arrays.stream(arr).sorted().limit(3).collect(Collectors.joining(" "));
        System.out.println(res);

    }

}
