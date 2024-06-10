package com.android.nova.inverviewcamp.arraysandstrings1;

import java.util.Arrays;

/** Interview CampLevel:
 * EasyGiven an array of numbers, replace each even number with two of the same number.
 * e.g, [1,2,5,6,8, , , ,] -> [1,2,2,5,6,6,8,8].Assume that the array has the exact amount of space
 * to accommodate the result.
 **/
public class ReverseTraversingJversion {
    public static void main (String[] args) {
        System.out.println("Reverse Traversing");
        int[] inputArray = {1,2,5,6,8, -1, -1, -1};
        sortingDoubles(inputArray);
    }

    private static void sortingDoubles(int[] inputArray) {
        System.out.println("The input is " + Arrays.toString(inputArray));
        if (inputArray == null || inputArray.length == 0) {
            System.out.println("The array is already done");
            return;
        }

        int lastIndex = getLastIndex(inputArray);
        int endIndex = inputArray.length;
        System.out.println("%% The last index is" + lastIndex);
        System.out.println("%% The end index is" + endIndex);
        while (lastIndex >= 0) {

            if (inputArray[lastIndex] % 2 == 0) { // For this case is even
                inputArray[--endIndex] = inputArray[lastIndex];
            }
            inputArray[--endIndex] = inputArray[lastIndex];
            lastIndex--;
        }
        System.out.println("The result is" + Arrays.toString(inputArray));
    }

    private static int getLastIndex(int[] inputArray) {
        int lastIndex = inputArray.length - 1;

        while (lastIndex >= 0 && inputArray[lastIndex] == -1){
            lastIndex--;
        }
        return lastIndex;
    }
}
