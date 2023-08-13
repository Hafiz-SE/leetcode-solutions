import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 100 + 1);

            array[i] = randomNum;
        }
        System.out.println(Arrays.toString(array));
        Boolean doesContainDuplicate = ContainsDuplicate.containsDuplicate(array);
        System.out.println(doesContainDuplicate);
    }

    public static boolean containsDuplicate(int[] nums) {
        sort(nums);
        int checker = Integer.MIN_VALUE;
        for (int i = 0; i<nums.length; i++){
            if (nums[i] == checker) {
                return true;
            } else {
                checker = nums[i];
            }
        }
        return false;
    }

    public static void sort(int[] nums) {
        ContainsDuplicate.divideAndConquer(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void divideAndConquer(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int mid = nums.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[nums.length - mid];

        for (int i = 0; i < mid; i++) {
            leftArray[i] = nums[i];
        }

        for (int i = mid; i < nums.length; i++) {
            rightArray[i-mid] = nums[i];
        }

        divideAndConquer(leftArray);
        divideAndConquer(rightArray);
        conquer(nums, leftArray, rightArray);
    }

    public static void conquer(int[] nums, int[] leftArray, int[] rightArray) {
        int mainPointer = 0;
        int rightArrayPointer = 0;
        int leftArrayPointer = 0; 
        
        while(leftArrayPointer < leftArray.length || rightArrayPointer < rightArray.length) {
            if (leftArrayPointer == leftArray.length) {
                nums[mainPointer++] = rightArray[rightArrayPointer++];
            } else if (rightArrayPointer == rightArray.length) {
                nums[mainPointer++] = leftArray[leftArrayPointer++];
            } else if (rightArray[rightArrayPointer] > leftArray[leftArrayPointer]) {
                nums[mainPointer++] = leftArray[leftArrayPointer++];
            } else {
                nums[mainPointer++] = rightArray[rightArrayPointer++];
            }
        }
    }
}