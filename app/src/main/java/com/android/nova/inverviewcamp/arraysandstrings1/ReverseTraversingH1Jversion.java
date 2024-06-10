package com.android.nova.inverviewcamp.arraysandstrings1;

import java.util.Arrays;

/**
 ** Given a sentence, reverse the words of the sentence.
 * For example,"i live in a house" becomes "house a in live i"
 **/
public class ReverseTraversingH1Jversion {
    public static void main (String[] args) {
        System.out.println(" The input is i live in a house");
        String input = "i live in a house";
        // String[] wordsArray = input.split(" "); Unfortunately for this case we cannot use the power of split()
        reverseArray(input);
    }

    private static void reverseArray(String input) {
        StringBuilder sb = new StringBuilder();
        int currentWordEnd = input.length();

        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) == ' ') {
               if (sb.length() > 0) {
                   sb.append(' ');
               }
               sb.append(input.substring(i + 1, currentWordEnd));
               currentWordEnd = i;
            }
        }

        // We are missing adding the first word
        System.out.println("at the end of the day the output is --> " + sb.toString());
    }

}
