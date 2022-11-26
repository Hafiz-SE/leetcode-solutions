public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int targetArrayIndex = -1;
        if (!(matrix[0][0] <= target && target <= matrix[matrix.length-1][matrix[matrix.length-1].length-1])) {
            return false;
        }
        while(i<matrix.length){
            if (i+1 == matrix.length) {
                int lastIndex = matrix[i].length-1;
                if (matrix[i][0] <= target && target <= matrix[i][lastIndex]) {
                    targetArrayIndex = matrix.length-1;
                    break;
                }
            } else if (matrix[i][0] <= target && target<matrix[i+1][0]) {
                targetArrayIndex = i;
                break;
            }
            i++;
        }
        if (targetArrayIndex < 0) {
            return false;
        }
        int[] targetArray = matrix[targetArrayIndex];
        int startIndex = 0;
        int endIndex = targetArray.length-1;
        int midIndex = (startIndex+endIndex)/2;
        while(startIndex<=endIndex) {
            if (targetArray[midIndex]==target) {
                return true;
            } else if (targetArray[midIndex] < target) {
                startIndex = midIndex+1;
            } else if (targetArray[midIndex] > target){
                endIndex = midIndex-1;
            }
            midIndex = (startIndex+endIndex)/2;
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] input = new int[][] {
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,60}
        };
        System.out.println(SearchA2DMatrix.searchMatrix(input,23));
    }
}
