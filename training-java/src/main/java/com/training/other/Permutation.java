package com.training.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Permutation {

    /**
     * Generate the permutations of the provided characters without including duplicates (unless provided explicitly as arguments).
     * Each resulting item of the permutation will be with the same length as the number of arguments.
     * To see an explanation of the recursion checkout this
     * <a href="https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/">resource</a>.
     *
     * @param chars the chars to use for the permutation.
     * @return list of resulting permutations.
     */
    static List<String> uniquePermutation(char... chars) {

        return uniquePermutation(new ArrayList<>(), chars, 0);
    }

    private static List<String> uniquePermutation(List<String> permutations, char[] chars, int pivotIndex) {

        if (chars.length == pivotIndex) {

            permutations.add(String.valueOf(chars));

            return permutations;
        }

        for (int i = pivotIndex; i < chars.length; i++) {
            char[] swap = swap(chars, i, pivotIndex);

            uniquePermutation(permutations, swap, pivotIndex + 1);
        }

        return permutations;
    }

    /**
     * Note that the implementation of swap copies the array on each invocation.
     * This can be avoided by mutating the array and calling swap before and after each
     * recursive call of {@link Permutation#uniquePermutation(char...)}.
     */
    private static char[] swap(char[] string, int first, int second) {

        char[] chars = Arrays.copyOf(string, string.length);

        char a = chars[first];
        char b = chars[second];

        chars[first] = b;
        chars[second] = a;

        return chars;
    }

}
