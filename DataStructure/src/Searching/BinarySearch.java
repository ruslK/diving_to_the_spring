package Searching;

import Soltering.MyQuickSort.MyQuickSort;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 2, 54, 31, 11, 32, 0, 15};
        MyQuickSort.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(BinarySearch.binaryRecursiveSearch(array, 31));
        System.out.println(BinarySearch.binaryIterativeSearch(array, 31));
    }

    /**
     * Binary Recursive Search
     */
    public static int binaryRecursiveSearch(int[] array, int data) {
        return binaryRecursiveSearch(array, data, 0, array.length - 1);
    }

    public static int binaryRecursiveSearch(int[] array, int data, int left, int right) {
        if (right < left) return -1;

        int middle = (left + right) / 2;

        if (array[middle] == data) return middle;
        if (data < array[middle]) return binaryRecursiveSearch(array, data, left, middle - 1);
        return binaryRecursiveSearch(array, data, middle + 1, right);
    }

    /**
     * Binary Iterative Search
     */
    public static int binaryIterativeSearch(int[] array, int data) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == data) return middle;
            if (data < array[middle]) {
                right = middle -1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
