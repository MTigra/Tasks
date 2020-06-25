package com.martirosyan.lesson4;

import com.martirosyan.lesson4.exceptions.MyArrayDataException;
import com.martirosyan.lesson4.exceptions.MyArraySizeException;

import java.util.Random;

public class MainApp {


    public static void main(String[] args) {
        Random rnd = new Random();

        //туточки делаем массив и вызывам эти методы
    }

    public static int sumMatrix(String[][] matrix) {
        if (matrix == null) {
            throw new NullPointerException();
        }
        if (!ifMatrixSizeCorrect(matrix)) {
            throw new MyArraySizeException();
        }

        int sum = 0;
        int i, j = 0;
        try {
            for (i = 0; i < matrix.length; i++) {
                for (j = 0; j < matrix[i].length; j++) {
                    sum += Integer.parseInt(matrix[i][j]);
                }
            }
        } catch (NumberFormatException ex) {
            throw new MyArrayDataException();
        }

        return sum;
    }

    public static boolean ifMatrixSizeCorrect(String[][] matrix) {
        if (matrix.length != 4) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != 4) {
                return false;
            }
        }

        return true;
    }
}
