package com.android.nova.inverviewcamp.arraysandstrings1;

import java.util.Arrays;

/**
 * Given a sorted array in non-decreasing order,
 * return an array of squares of each number,
 * also in non-decreasing order. For example:
 * [-4,-2,-1,0,3,5] -> [0,1,4,9,16,25]
 * How can you do it in O(n) time?
 */
public class TraverseBothEndsH1Jversion {
    public static void main (String[] args) {
        int[] inputArray = {-4,-2,-1,0,3,5};
        System.out.println("The input is " + Arrays.toString(inputArray));
        squareArray(inputArray);
    }

    private static void squareArray(int[] inputArray) {
        int startIndex = 0;
        int endIndex = inputArray.length - 1;
        int[] outputArray = new int[inputArray.length];
        int outputArrayIndex = inputArray.length - 1;;
        while (startIndex < endIndex) {
            System.out.println("Comparing " + Math.abs(inputArray[startIndex]) + " and also " + Math.abs(inputArray[endIndex]));
            if (Math.abs(inputArray[startIndex]) > Math.abs(inputArray[endIndex])) {
                outputArray[outputArrayIndex--] = inputArray[startIndex] * inputArray[startIndex];
                startIndex++;

            } else {
                outputArray[outputArrayIndex--] = inputArray[endIndex] * inputArray[endIndex];
                endIndex--;
            }
        }
        System.out.println("The final output  is " + Arrays.toString(outputArray));
    }
}
