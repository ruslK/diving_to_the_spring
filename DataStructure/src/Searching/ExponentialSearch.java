package Searching;

import Soltering.MyQuickSort.MyQuickSort;

import java.util.Arrays;

public class ExponentialSearch {
    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 2, 54, 31, 11, 32, 0, 1, 15, 16, 17 ,18 , 44, 45, 55, 56, 59, 71, 75, 88, 95, 14, 100};
        MyQuickSort.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("length: " + array.length);
        System.out.println(ExponentialSearch.exponentialSearch(array, 71));
    }

    public static int exponentialSearch(int[] array, int data) {
        int bound = 1;

        while (bound < array.length && array[bound] < data) {
            System.out.println(bound);
            bound *= 2;
        }
        System.out.println("bound: " + bound);
        int left = bound / 2;
//        int right = Math.min(bound, array.length - 1);
        int right = left + ((array.length - 1) - left);
        System.out.println("left " + left + ", value: " + array[left]);
        System.out.println("right " + right + ", value: " + array[right]);
        return BinarySearch.binaryRecursiveSearch(array, data, left, right);
    }

}
