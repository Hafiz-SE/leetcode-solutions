public class JumpGame {
    public static boolean canJump(int[] nums) {
        int numberOfSteps = nums[0];
        if ((nums.length==1 && nums[0]>=0) || nums[0]>=nums.length-1) {
            return true;
        } else if (nums[0]<1) {
            return false;
        } 

        for (int i = 1; i < nums.length; i++) {
            if (i == (nums.length-1)) {
                return true;
            }
            numberOfSteps--;
            if (numberOfSteps < nums[i]) {
                numberOfSteps = nums[i];
            }
            System.out.println("-----------------");
            System.out.println("index: " + i);
            System.out.println("Steps Left: " + numberOfSteps);
            System.out.println("Current Step Update: " + nums[i]);
            System.out.println("-----------------");

            if (numberOfSteps <=0) {
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] array = new int[] {2,0,0};
        System.out.println(JumpGame.canJump(array));
    }
}
