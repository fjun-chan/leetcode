package algorithms;

import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Follow up:
 *
 * Could you do this in-place?
 *
 * Created by fjun on 25/05/16.
 */
public class P48RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{00,01,02,03,04,05},
                new int[]{10,11,12,13,14,15},
                new int[]{20,21,22,23,24,25},
                new int[]{30,31,32,33,34,35},
                new int[]{40,41,42,43,44,45},
                new int[]{50,51,52,53,54,55},
        };
        print(matrix);
        rotate(matrix);
        print(matrix);
    }

    private static void print(int[][] matrix) {
        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
        System.out.println("----------------------");
    }

    public static void rotate(int[][] matrix) {
        final int mid = matrix.length / 2;
        for (int round = 0; round <= mid; round ++) {
            final int len = matrix.length - 1;
            final int max = len - round;
            for (int y = round; y < max; y ++) {
                rotateRound(matrix, round, y, len);
            }
        }
    }

    private static int[] rotatePoint(int x, int y, int len) {
        return new int[]{y, len - x};
    }

    private static void rotateRound(int[][] m, int x, int y, int len) {
        int tmp = m[x][y];
        int[] p = new int[]{x, y};
        while (true) {
            p = rotatePoint(p[0], p[1], len);
            int pv = m[p[0]][p[1]];
            m[p[0]][p[1]] = tmp;
            tmp = pv;
            if (p[0] == x && p[1] == y) {
                break;
            }
        }
    }
}
