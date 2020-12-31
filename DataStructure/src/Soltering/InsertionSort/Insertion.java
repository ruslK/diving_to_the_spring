package Soltering.InsertionSort;

import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 2, 10, 12, 1, 5, 6};
        System.out.println(Arrays.toString(Insertion.insertion(array)));
    }

    public static int[] insertion(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
        return array;
    }

}
