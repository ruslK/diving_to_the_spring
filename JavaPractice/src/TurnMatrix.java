import org.junit.Assert;
import org.junit.Test;

public class TurnMatrix {

    @Test
    public void test1() {
        int[][] arr = {{1, 2}, {3, 4}};
        int[][] expected = {{3, 1}, {4, 2}};
        int[][] actual = turnMatrix(arr);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        int[][] actual = turnMatrix(arr);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] expected = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        int[][] actual = turnMatrix(arr);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18}};
        int[][] actual = turnMatrix(arr);
        Assert.assertArrayEquals(arr, actual);
    }

    private static int[][] turnMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            if (matrix.length != ints.length) {
                return matrix;
            }
        }
        int length;
        if (matrix.length % 2 == 0) {
            length = matrix.length / 2;
        } else {
            length = (matrix.length - 1) / 2;
        }
        for (int swapArr = 0; swapArr < length; swapArr++) {
            for (int cell = 0; cell < matrix[swapArr].length; cell++) {
                int temp = matrix[swapArr][cell] + matrix[(matrix.length - 1) - swapArr][cell];
                matrix[swapArr][cell] = temp - matrix[swapArr][cell];
                matrix[(matrix.length - 1) - swapArr][cell] = temp - matrix[(matrix.length - 1) - swapArr][cell];
            }
        }
        int nextSwapArrInd = 1;
        int nextSwapCellInd = 0;
        for (int swappingArrInd = 0; swappingArrInd < matrix.length; swappingArrInd++) {
            for (int swapCellInd = swappingArrInd + 1; swapCellInd < matrix[swappingArrInd].length; swapCellInd++) {
                int swappingCellTempValue = matrix[swappingArrInd][swapCellInd] + matrix[nextSwapArrInd][nextSwapCellInd];
                matrix[swappingArrInd][swapCellInd] = swappingCellTempValue - matrix[swappingArrInd][swapCellInd];
                matrix[nextSwapArrInd][nextSwapCellInd] = swappingCellTempValue - matrix[nextSwapArrInd][nextSwapCellInd];
                nextSwapArrInd++;
            }
            nextSwapArrInd = swappingArrInd + 2;
            nextSwapCellInd++;
        }
        return matrix;
    }
}
