package Searching;

import Soltering.MyQuickSort.MyQuickSort;

import java.util.Arrays;

public class TernarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 2, 54, 31, 11, 32, 0, 15, -1};
        MyQuickSort.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(TernarySearch.ternarySearch(array, 31));
    }

    public static int ternarySearch(int[] array, int data) {
        return ternarySearch(array, data, 0, array.length - 1);
    }

    public static int ternarySearch(int[] array, int data, int left, int right) {
        if (right < left) return -1;

        int portion = (right - left) / 3;

        int middle1 = left + portion;
        int middle2 = right - portion;

        if (array[middle1] == data) return middle1;
        if (array[middle2] == data) return middle2;

        if (data < array[middle1]) return ternarySearch(array, data, left, middle1 - 1);
        if (data > array[middle2]) return ternarySearch(array, data, middle2 + 1, right);

        return ternarySearch(array, data, middle1 + 1, middle2 - 1);
    }

}
