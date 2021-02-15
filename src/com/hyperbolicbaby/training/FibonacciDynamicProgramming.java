package com.hyperbolicbaby.training;

public class FibonacciDynamicProgramming {

    /**
     * Utilitarian Methods.
     * */
    public static void printElapsedTime(long elapsedTime) {
        System.out.println(String.format("Time Elapsed: %s seconds.", ((double) elapsedTime / 1_000_000_000)));
    }

    public static long getNanoTime() {
        return System.nanoTime();
    }

    public static void main(String[] args) {
        int n = 40;

        long start = getNanoTime();
        System.out.println(naiveFibonacci(n));
        long finish = getNanoTime();
        long elapsedTime = finish - start;
        printElapsedTime(elapsedTime);

        start = getNanoTime();
        System.out.println(memoizedFibonacci(n, new Integer[n]));
        finish = getNanoTime();
        elapsedTime = finish - start;
        printElapsedTime(elapsedTime);

        start = getNanoTime();
        System.out.println(bottomUpFibonacci(n));
        finish = getNanoTime();
        elapsedTime = finish - start;
        printElapsedTime(elapsedTime);
    }

    /**
     * Recursive, naive way to get the nth Fibonacci Number.
     * Time Complexity: T(n) = O(2^n)
     * */
    public static int naiveFibonacci(int n) {
        int result;
        if (n == 1 || n == 2)
            result = 1;
        else
            result = naiveFibonacci(n - 1) + naiveFibonacci(n - 2);
        return result;
    }

    /**
     * Gets the nth Fibonacci number using Memoization.
     * Time Complexity: T(n) = O(2n + 1) == O(n)
     * */
    public static int memoizedFibonacci(int n, Integer[] computationsRepository) {
        int result;

        if (computationsRepository[n - 1] != null)
            return computationsRepository[n - 1];
        if (n == 1 || n == 2)
            result = 1;
        else
            result = memoizedFibonacci(n - 1, computationsRepository) + memoizedFibonacci(n - 2, computationsRepository);

        computationsRepository[n - 1] = result;

        return result;
    }

    /**
     * Gets the nth Fibonacci Number using the bottom-up approach.
     * Time Complexity: T(n) = O(n)
     * */
    public static int bottomUpFibonacci(int n) {
        if (n == 1 || n == 2)
            return 1;

        int[] bottomUp = new int[n];
        bottomUp[0] = 1;
        bottomUp[1] = 1;

        for (int index = 2; index < n; index++) {
            bottomUp[index] = bottomUp[index - 1] + bottomUp[index - 2];
        }

        return bottomUp[n - 1];
    }
}
