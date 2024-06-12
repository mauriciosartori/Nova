package com.android.nova.inverviewcamp.arraysandstrings1;

import java.util.Arrays;

/**
 * Given an array of integers, find the continuous subarray,
 * which when sorted, results in the entire array being sorted.
 * For example: A = [0,2,3,1,8,6,9], result is the subarray [2,3,1,8,6]
 */
public class TraverseBothEndsH2Jversion2 {
    public static void main (String[] args) {
        //int[] inputArray = {0, 2, 3, 1, 8, 6, 9};
        //int[] inputArray = {1,2,3,6,4,7,4,8,9,10};
        int[] inputArray = {1,2,4,5,3,7,5,6,8};
        System.out.println("The input is " + Arrays.toString(inputArray));
        findSubarray(inputArray);
    }
    private static void findSubarray(int[] inputArray) {
        int startIndex = 1;
        int endIndex = inputArray.length - 2;

        // find the dip
        int dipIndex = -9;
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] < inputArray[i - 1]) {
                dipIndex = i - 1;
                break;
            }
        }

        // find the bum
        int bumIndex = -9;
        for (int i = inputArray.length - 2; i >= 0; i--) {
            if (inputArray[i] > inputArray[i + 1]) {
                bumIndex = i + 1;
                break;
            }
        }
        System.out.println("The dip index is" + dipIndex);
        System.out.println("The bump index is" + bumIndex);

        // inputArray[dipIndex + 1]
        for (int i = 0; i < dipIndex + 1; i++) {
            if (inputArray[i] > inputArray[dipIndex + 1]) {
                dipIndex = i;
                break;
            }
        }

        // inputArray[bumIndex - 1]
        for (int i = inputArray.length - 1; i > dipIndex; i--) {
            if (inputArray[bumIndex] > inputArray[i]) {
                bumIndex = i;
                break;
            }
        }

        System.out.print("Subarray: ");
        for (int i = dipIndex; i <= bumIndex; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println();
    }


}
