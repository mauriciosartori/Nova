package com.android.nova.inverviewcamp.arraysandstrings1.traversingbothends;

import java.util.Arrays;

/**
 *  Given an array, reverse the order of its elements.
 *  For example, [3,5,2,5,2,3,9] → [9,3,2,5,2,5,3]
 */
public class TraverseBothEndsJversion {
    public static void main (String[] args) {
        int[] inputArray = {3,5,2,5,2,3,9};
        System.out.println(" The input string is " + Arrays.toString(inputArray));
        reverseArray(inputArray);
    }

    private static void reverseArray(int[] inputArray) {
        int start = 0;
        int end = inputArray.length - 1;
        while (start < end) {
            swap(inputArray, start, end);
            start++;
            end--;
        }
        System.out.println(" The result is" + Arrays.toString(inputArray));
    }

    private static void swap(int[] inputArray, int start, int end) {
        int temp = inputArray[start];
        inputArray[start] =  inputArray[end];
        inputArray[end] = temp;
    }
}

