import java.util.concurrent.ThreadLocalRandom;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        // int[] array = new int[10];
        // for (int i = 0; i < array.length; i++) {
        //     int randomNum = ThreadLocalRandom.current().nextInt(1, 100 + 1);
        //     array[i] = randomNum;
        // }
        int array [] = {0,0,1,1,1,2,2,3,3,4};
        printArray(array, "Initial Array");
        System.out.println(removeDuplicates(array));
        printArray(array, "Dupicate Removed Array");
    }

    public static int removeDuplicates(int[] nums) {
        int currentNumber = Integer.MIN_VALUE;
        int currentIndex = -1;
        int diffValues = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currentIndex == -1 || nums[i] != currentNumber) {
                currentNumber = nums[i];
                currentIndex++;
                diffValues++;
                nums[currentIndex] = nums[i];
            } 
        }
        return diffValues;
    }

    public static void printArray(int[] array, String tag) {
        System.out.print("Printing " + tag + " Array --->");
        for (int i = 0; i < array.length; i++) {
            System.out.print("\t" + array[i]);
        }
        System.out.print("\n");
    }
}
