public class HouseRobber {
    public static int rob(int[] nums) {
        int even = 0;
        int odd = 0;
        for (int i =0; i<nums.length; i++) {
            if (i%2 == 0) {
                even+=nums[i];
            } else {
                odd+=nums[i];
            }
        }
        return even>odd ? even:odd;
    }

    public static void main (String[] args) {
        int [] array = new int[] {2,7,9,3,1};
        System.out.println(HouseRobber.rob(array));
    }
}