package Soltering.MyQuickSort;

import Soltering.utils;

import java.util.Arrays;

public class MyQuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 2, 10, 12, 1, 5, 1};
        MyQuickSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int start, int end) {
        if (start >= end)
            return;
        var boundary = partition(array, start, end);
        sort(array, start, boundary - 1);
        sort(array, boundary + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        var pivot = array[end];
        var boundary = start - 1;
        for (var i = start; i <= end; i++)
            if (array[i] <= pivot)
                utils.swap(array, i, ++boundary);
        return boundary;
    }
}
