package Soltering.MergeSort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 2, 10, 12, 1, 5};
        MergeSort.sort(array);
//        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        if (array.length < 2) return;

        int mid = array.length / 2;
        int[] leftArray = new int[mid];
        for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
        }

        int[] rightArray = new int[array.length - mid];
        for (int i = mid; i < array.length; i++) {
            rightArray[i - mid] = array[i];
        }


        System.out.println(Arrays.toString(leftArray));
        sort(leftArray);
        System.out.println(Arrays.toString(rightArray));
        sort(rightArray);
        MergeSort(leftArray, rightArray, array);
    }

    private static void MergeSort(int[] left, int[] right, int[] result) {

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }
        System.out.println(Arrays.toString(result));
        System.out.println();
    }
}
