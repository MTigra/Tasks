package com.martirosyan.lesson1;


import java.util.Arrays;
import java.util.Random;

public class HW1 {
    private static Random rnd = new Random();

    // Задание 1.
    public static boolean isSumBetween10and20i(int a, int b) {
        int sum = a + b;
        return sum > 10 && sum <= 20;
    }

    //Задание 2 и  Задание 3.
    public static void print(String s) {
        System.out.println(s);
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static void printIfNegative(int number) {
        String result = number + " число ";
        result += isNegative(number) ? "отрицательное." : "положитлеьное.";
    }

    //Задание 4.
    public static void greetName(String name) {
        print(String.format("Hello, %s!", name));
    }

    //Задание 5.
    public static void inverseBinaryArr() {

        int[] arr = rnd.ints(0, 2)
                .limit(10).toArray();

        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }

    }

    //Задание 6.
    public static void fillArrAsArithmetcProgression(int startNum, int delta) {
        int[] arr = new int[8];
        arr[0] = startNum;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + delta;
        }

    }


    //Задание 7.
    // upperbound - верхняя граница чисел, которые будут умножены на 2.
    public static void doubleArrayElements(int upperbound) {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < upperbound) {
                arr[i] *= 2;
            }
        }
    }

    //Задание 8.
    public static void fillDiag() {
        int[][] matrix = new int[10][10];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
        }
    }

    //Задание 9.
    public static void findMaxMin() {
        int[] arr = rnd.ints(15).toArray();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }
    }

    //Задание 10.
    public static boolean isLeapYear(int year) {
        return year % 400 == 0
                ||
                (year % 4 == 0 && year % 100 != 0);
    }

    //Задание 11.
    // checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    // checkBalance([1, 1, 1, || 2, 1]) → true,
    public static boolean checkBalance(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            leftSum += arr[i];
            if (leftSum == sum - leftSum) {
                return true;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        inverseBinaryArr();
    }

}
