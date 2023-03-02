package ru.xkr1se;

/**
 * @author xkr1se
 */
public class Solution {

    public static int[][] createSpiral(int n) {
        int[][] matrix = new int[n][n];
        for (int step = 0, a = 0, size; step < n/2; step++) {
            size = (n - step * 2 - 1);
            for (int i = 0, chunk, chunkIndex, chunkOffset; i < 4 * size; i++) {
                chunk = i / size;
                chunkIndex = i % size;
                chunkOffset = n - step - 1;
                switch (chunk) {
                    case 0:
                        matrix[step][chunkIndex + step] = a+1;
                        break;
                    case 1:
                        matrix[chunkIndex + step][chunkOffset] = a+1;
                        break;
                    case 2:
                        matrix[chunkOffset][chunkOffset - chunkIndex] = a+1;
                        break;
                    case 3:
                        matrix[chunkOffset - chunkIndex][step] = a+1;
                        break;
                    default:
                        throw new IndexOutOfBoundsException();
                }
                a++;
            }
            if (n % 2 == 1) {
                matrix[n/2][n/2] = n * n;
            }
        }
        return matrix;
    }

}
