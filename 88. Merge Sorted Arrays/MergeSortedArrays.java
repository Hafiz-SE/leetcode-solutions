import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] array1 = new int[6];
        array1[0] = 1;
        array1[1] = 2;
        array1[2] = 3;
        array1[3] = 0;
        array1[4] = 0;
        array1[5] = 0;

        int[] array2 = new int[3];
        array2[0] = 2;
        array2[1] = 5;
        array2[2] = 6;
        

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));

        MergeSortedArrays.merge(array1, 3, array2, 3);
        System.out.println(Arrays.toString(array1));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = nums1.clone();

        int mainPointer = 0;
        int nums1Pointer = 0;
        int nums2Pointer = 0;

        while (nums1Pointer < m || nums2Pointer < n) {
            if (nums1Pointer >= m) {
                nums1[mainPointer++] = nums2[nums2Pointer++];
            } else if (nums2Pointer >= n) {
                nums1[mainPointer++] = nums[nums1Pointer++];
            } else if (nums[nums1Pointer] > nums2[nums2Pointer]) {
                nums1[mainPointer++] = nums2[nums2Pointer++];
            } else {
                nums1[mainPointer++] = nums[nums1Pointer++];
            }
        }

    }
}
