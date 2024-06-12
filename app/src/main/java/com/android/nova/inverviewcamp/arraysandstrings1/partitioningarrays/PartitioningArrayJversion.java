package com.android.nova.inverviewcamp.arraysandstrings1.partitioningarrays;

import java.util.Arrays;

/**
 * Question 1 (discussed in video): You are given an array of integers.
 * Rearrange the array so that all zeroes are at the beginning of the array.
 * For example, [4,2,0,1,0,3,0] -> [0,0,0,4,1,2,3]
 */
public class PartitioningArrayJversion {
    public static void main (String[] args) {
        int[] inputArray = {4,2,0,1,0,3,0};
        System.out.println("The input is" + Arrays.toString(inputArray));
        sortZerosInArray(inputArray);
    }
    private static void sortZerosInArray(int[] inputArray) {
        int boundryIndex = 0;
        for (int i = 0; i < inputArray.length ; i++) {
            //System.out.println("The inputArray in position i is " + inputArray[i] + " and the position i is " + i);


            if (inputArray[i] == 0) {
                swap(inputArray, i, boundryIndex);
                boundryIndex++;
            }
            //System.out.println("Array at this time" + Arrays.toString(inputArray));
            //System.out.println("-----------");
        }
        System.out.println("The result is" + Arrays.toString(inputArray));
    }

    private static void swap(int[] inputArray, int a, int b) {
        int temp = inputArray[a];
        inputArray[a] = inputArray[b];
        inputArray[b] = temp;
    }
}
