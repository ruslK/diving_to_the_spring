package Searching;

import Soltering.MyQuickSort.MyQuickSort;

import java.util.Arrays;

public class JumpSearch {
    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 2, 54, 31, 11, 32, 0, 15, -1, -5, -4, -10, 10, 16, 42, -45, 13};
        MyQuickSort.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(JumpSearch.jumpSearch(array, 2));
    }

    public static int jumpSearch(int[] array, int data) {
        int blockSize = (int) Math.sqrt(array.length);
        int start = 0;
        int next = blockSize;
        System.out.println("Block size: " + blockSize);
        System.out.println("Start: " + start);
        System.out.println("Next: " + next);
        System.out.println();
        while (start < array.length && array[next - 1] < data) {
            start = next;
            next += blockSize;
            if(next > array.length) next = array.length;
            System.out.println("Start: " + start);
            System.out.println("Next: " + next);
        }
        for (int i = start; i < next; i++) {
            System.out.println(i);
            if(array[i] == data) return i;
        }
        return -1;
    }
}
