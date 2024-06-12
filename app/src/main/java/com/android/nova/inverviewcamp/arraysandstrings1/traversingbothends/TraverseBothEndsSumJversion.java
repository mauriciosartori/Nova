package com.android.nova.inverviewcamp.arraysandstrings1.traversingbothends;

import java.util.Arrays;

/**
 * 2 Sum Problem:
 * Given a sorted array of integers, find two numbers in the array that sum
 * to a given integer target.
 * For example, if a = [1,2,3,5,6,7] and target = 11, the answer will be 5 and 6.
 */
public class TraverseBothEndsSumJversion {
    public static void main (String[] args) {
        int[] inputArray = {1,2,3,5,6,7};
        System.out.println(" The input string is " + Arrays.toString(inputArray));
        int target = 11;
        findPairSum(inputArray, target);
    }

    private static void findPairSum(int[] inputArray, int target) {
        int start = 0;
        int end = inputArray.length - 1;

        while(start < end) {
            if ((inputArray[start] + inputArray[end]) < target) {
                start++;
            } else if ((inputArray[start] + inputArray[end])> target) {
                end--;
            } else {
                System.out.println(" The two pairs are " + inputArray[start] + " and " + inputArray[end] + " and they sum the target " + target);
                return;
            }
        }
    }

}

