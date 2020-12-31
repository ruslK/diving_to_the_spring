package Soltering.SelectionSort;

import Soltering.utils;

import java.util.Arrays;

public class SelectionSort {


    public static int[] selection(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            utils.swap(array, minIndex, i);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{18, 12, 14, 11, 13, 9, 22};
        System.out.println(Arrays.toString(SelectionSort.selection(array)));
    }
}
