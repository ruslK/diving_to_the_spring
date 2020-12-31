package Soltering.BubleSort;

import Soltering.utils;

import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    utils.swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) return array;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 2, 4, 1, 3};
        System.out.println(Arrays.toString(BubbleSort.bubbleSort(array)));
    }
}
