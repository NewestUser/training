package com.training.other;


class SelectionSort {

    static int[] doubleEndedSort(int[] arr) {
        int startIndex = 0;

        while (startIndex < arr.length - startIndex) {

            int minIndex = startIndex;
            int maxIndex = arr.length - startIndex - 1;

            for (int j = startIndex; j < arr.length - startIndex; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }

                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            swap(arr, startIndex, minIndex);
            if (startIndex == maxIndex) {
                maxIndex = minIndex;
            }

            int endIndex = arr.length - 1 - startIndex;

            swap(arr, endIndex, maxIndex);
            startIndex++;
        }

        return arr;
    }

    private static void swap(int[] array, int oldIndex, int newIndex) {
        int temp = array[oldIndex];
        array[oldIndex] = array[newIndex];
        array[newIndex] = temp;
    }

}
