import java.util.List;
import java.util.Map;

public class ContainterWithMostWater {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length-1;
        while (i<j) {
            int area = (height[i] <= height[j] ? height[i] : height[j]) * (j-i);
            if (area > maxArea) maxArea = area;
            if (height[i] > height[j]) {
                j++;
            } else {
                i--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] array = {1,8,6,2,5,4,8,3,7};
        System.out.println(ContainterWithMostWater.maxArea(array));
    }
}
