package com.thoughtworks.tw101.introductory_programming_exercises;

//  Prime Factors Exercise
//  Write a method generate(int n) that given an integer N will return a list of integers such that the numbers
//  are the factors of N and are arranged in increasing numerical order.
//
//  For example, generate(1) should return an empty list and generate(30) should return the numbers: 2,3,5.

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    public static void main(String[] args) {
        List<Integer> primeFactors = generate(30);
        System.out.println(primeFactors);
    }

    private static List<Integer> generate(int n) {
        List<Integer> primeFactors = new ArrayList<Integer>();
        for (int i = 2; i <= n ; i++) {
            while (n%i == 0) {
                primeFactors.add(i);
                n = n/i;
            }
        }
        return primeFactors;
    }
}
