package com.android.nova.inverviewcamp.arraysandstrings1;

import java.util.Arrays;

/**
 * Given an array of integers, find the continuous subarray,
 * which when sorted, results in the entire array being sorted.
 * For example: A = [0,2,3,1,8,6,9], result is the subarray [2,3,1,8,6]
 */
public class TraverseBothEndsH2Jversion {
    public static void main (String[] args) {
        int[] inputArray = {0, 2, 3, 1, 8, 6, 9};
        System.out.println("The input is " + Arrays.toString(inputArray));
        findSubarray(inputArray);
    }
    private static void findSubarray(int[] inputArray) {
        int startResultIndex = -1;
        boolean startResultFlag = true;
        int endResultIndex = -1;
        boolean endResultFlag = true;
        for (int i = 0 ; i < inputArray.length - 1; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[j] < inputArray[i]  && startResultFlag) {
                    startResultIndex = i;
                    startResultFlag = false;
                    break;
                }
            }
        }

        for (int i = inputArray.length - 1 ; i > 0; i--) {
            for (int j = i - 1; j > 0; j--) {
                if (inputArray[j] > inputArray[i]  && endResultFlag) {
                    endResultIndex = i;
                    endResultFlag = false;
                    break;
                }
            }
        }
        System.out.println("The result is for start index " + startResultIndex + " and the value is  " + inputArray[startResultIndex]);
        System.out.println("The result is for start index " + endResultIndex + " and the value is " + inputArray[endResultIndex]);
    }


}
