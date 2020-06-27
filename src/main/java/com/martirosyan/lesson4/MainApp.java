package com.martirosyan.lesson4;

import com.martirosyan.lesson4.exceptions.MyArrayDataException;
import com.martirosyan.lesson4.exceptions.MyArraySizeException;

import java.util.Random;

public class MainApp {


    public static void main(String[] args) {
        Random rnd = new Random();

        String[][] matrix = new String[4][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = String.valueOf(rnd.nextInt(100));
                matrix[2][3] = "fd";
            }
        }

        try {
            System.out.println(sumMatrix(matrix));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int sumMatrix(String[][] matrix) {
        if (matrix == null) {
            throw new NullPointerException();
        }
        if (!ifMatrixSizeCorrect(matrix)) {
            throw new MyArraySizeException("Wrong matrix dimensions. Should be 4x4");
        }

        int sum = 0;
        int i = 0, j = 0;
        try {
            for (i = 0; i < matrix.length; i++) {
                for (j = 0; j < matrix[i].length; j++) {
                    sum += Integer.parseInt(matrix[i][j]);
                }
            }
        } catch (NumberFormatException ex) {
            throw new MyArrayDataException(String.format("Wrong data in [%d][%d]=%s\nShould be number.", i, j, matrix[i][j]));
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
