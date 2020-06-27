package com.martirosyan.lesson5.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayUtils {

    public static <T> void swap(T[] arr, int i, int j) {
        if (i < 0 || i > arr.length || j < 0 || j > arr.length) {
            throw new IndexOutOfBoundsException();
        }

        if (i == j) {
            return;
        }

        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <T> ArrayList<T> toArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }


}
