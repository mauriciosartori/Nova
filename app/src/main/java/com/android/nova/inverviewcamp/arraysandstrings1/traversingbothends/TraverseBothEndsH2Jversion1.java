package com.android.nova.inverviewcamp.arraysandstrings1.traversingbothends;

import java.util.Arrays;

/**
 * Given an array of integers, find the continuous subarray,
 * which when sorted, results in the entire array being sorted.
 * For example: A = [0,2,3,1,8,6,9], result is the subarray [2,3,1,8,6]
 */
public class TraverseBothEndsH2Jversion1 {
    public static void main (String[] args) {
        int[] inputArray = {0, 2, 3, 1, 8, 6, 9};
        System.out.println("The input is " + Arrays.toString(inputArray));
        findSubarray(inputArray);
    }
    private static void findSubarray(int[] inputArray) {
        int startIndex = 1;
        int endIndex = inputArray.length - 2;

        int startIndexValue = -9;
        int endIndexValue = -9;
        while (startIndex < endIndex) {
            System.out.println("Comparing inputArray[startIndex] " +inputArray[startIndex] + " and the other " + inputArray[startIndex - 1]);
            if (inputArray[startIndex] < inputArray[startIndex - 1] && startIndexValue == -9) {
                startIndexValue = startIndex - 1;
                System.out.println("Omaru?!" );
            }

            if (inputArray[endIndex] > inputArray[endIndex + 1] && endIndexValue == -9) {
                endIndexValue = endIndex + 1;
                System.out.println("Andas!?!" );
            }
            startIndex++;
            endIndex--;
        }
        System.out.println("The start index is " + startIndexValue + " and the end index is " +endIndexValue);
        System.out.println("The output is " );
        System.out.print("Subarray: ");
        for (int i = startIndexValue; i <= endIndexValue; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println();
    }


}
