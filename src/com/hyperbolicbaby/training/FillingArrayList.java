package com.hyperbolicbaby.training;

import java.util.*;
import java.util.stream.Collectors;

/*********************************************************************************
 * (Largest rows and columns) Write a program that randomly fills in 0s and 1s    *
 * into an n-by-n matrix, prints the matrix, and finds the rows and columns with  *
 * the most 1s. (Hint: Use two ArrayLists to store the row and column indices     *
 * with the most 1s.) Here is a sample run of the program:                        *
 *********************************************************************************/

public class FillingArrayList {
    public static void main(String[] args) {
        System.out.println("Enter the array size n:");
        int nSize = new Scanner(System.in).nextInt();

        int[][] array = getArraysFilled(nSize);
        System.out.println("The random array is:");
        printArray( array );

        System.out.println("\nThe largest row index:");
        System.out.println(getLargestRowIndex(array));

        System.out.println("\nThe largest column index:");
        System.out.println(getLargestColumnIndex(array));
    }

    public static List<Integer> getLargestRowIndex(int[][] array) {

        int coincidences = 0;
        int index = -1;

        Map<Integer, Integer> indexAndValues = new HashMap<>();

        for (int[] row: array) {

            for (int number: row) {
                if (number == 1)
                    coincidences++;
            }

            index++;

            indexAndValues.put(index, coincidences);

            coincidences = 0;

        }

        // System.out.println(indexAndValues);

        return getIndexWithMaxValues(indexAndValues);
    }

    private static List<Integer> getIndexWithMaxValues(Map<Integer, Integer> indexAndValues) {
        int max = Collections.max(indexAndValues.values());

        return indexAndValues.entrySet().stream()
                .filter(entry -> entry.getValue() == max)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    public static List<Integer> getLargestColumnIndex(int[][] array) {
        int coincidences = 0;

        Map<Integer, Integer> indexAndValues = new HashMap<>();

        for (int index = 0; index < array.length; index++) {
            coincidences = 0;

            for (int jindex = 0; jindex < array.length; jindex++) {
                if (array[jindex][index] == 1) {
                    coincidences++;
                }
            }
            indexAndValues.put(index, coincidences);
        }

        // System.out.println(indexAndValues);

        return getIndexWithMaxValues(indexAndValues);
    }

    /**
     * Fills with 1 or 0 generated randomly
     * */
    public static int[][] getArraysFilled(int nSize) {
        int[][] array = new int[nSize][nSize];

        for (int[] row: array) {
            Arrays.setAll(row, number -> getRandomZeroOrOne());
        }

        return array;
    }

    /**
     * Prints a 2D array
     * */
    public static void printArray(int[][] array) {
        for (int[] row: array) {
            for (int number: row) {
                System.out.print(number);
            }
            System.out.println();
        }
    }

    public static int getRandomZeroOrOne() {
        // return (int) (2 * Math.random());
        return new Random().nextInt(2); // 2 is exclusive
    }
}
