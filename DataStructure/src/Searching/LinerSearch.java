package Searching;

public class LinerSearch {

    public static int LinerSearch(int[] array, int data) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 2, 10, 12, 1, 5, 1};
        System.out.println(LinerSearch.LinerSearch(array, 10));
    }
}
