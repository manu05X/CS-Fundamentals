package com.manish.Thread.Practice.Example3;

import java.util.*;

public class PrimeFactorSum {

    // Function to check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Function to return the list of prime factors of a given number
    public static List<Integer> getPrimeFactors(int n) {
        List<Integer> primeFactors = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0 && isPrime(i)) {
                primeFactors.add(i);
                n /= i;
            }
        }
        return primeFactors;
    }

    // Function to repeatedly break down a number and sum its prime factors
    public static int primeFactorSum(int n) {
        int sum = n;

        // Repeat until the sum cannot be broken down into prime factors
        while (!isPrime(sum)) {
            List<Integer> primeFactors = getPrimeFactors(sum);
            sum = 0;
            for (int prime : primeFactors) {
                sum += prime;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int result = primeFactorSum(number);
        System.out.println("The final sum of prime factors: " + result);
    }
}

