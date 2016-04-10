package algorithms;

/**
 *11. Container With Most Water
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container.
 *
 * Created by fjun on 4/10/16.
 */
public class P11ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,1}));
    }

    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0;
        while (j > i) {
            int s = (j - i) * (height[j] > height[i] ? height[i] : height[j]);
            if (s > max) {
                max = s;
            }
            if (height[j] > height[i]) {
                i ++;
            } else {
                j --;
            }
        }
        return max;
    }

    public static int maxAreaTLE(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i ++ ) {
            for (int j = 0; j < height.length; j ++) {
                int s = (j - i) * (height[j] > height[i] ? height[i] : height[j]);
                if (s > max) {
                    max = s;
                }
            }
        }
        return max;
    }
}
