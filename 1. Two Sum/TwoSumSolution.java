import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSumSolution {

    public static int[] twoSum(int[] nums, int target) {
      Map<Integer,Integer> map = new HashMap<>();
      int[] result = new int[2];
      for(int i = 0; i < nums.length; i++) {
        map.put(target - nums[i], i);
      }
      for(int i = 0; i < nums.length; i++) {
        int foundIndex = map.getOrDefault(nums[i], -1);
        if (foundIndex != -1 && foundIndex != i) {
            result[0] = i;
            result[1] = foundIndex;
        }
      }
      return result;
    }

    public static void main(String[] args) {
        int[] values =  new int[]{3,2,4};
        System.out.println(Arrays.toString(TwoSumSolution.twoSum(values, 6)));
    }
}