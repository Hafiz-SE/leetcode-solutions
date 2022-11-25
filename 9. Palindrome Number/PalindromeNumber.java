public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        int y = x;
        int reversedNumber = 0;
        for (int i=(int) (Math.log10(x)); i>=0; i--) {            
            reversedNumber = reversedNumber + (y%10) * (int) Math.pow(10, i);
            y = y/10;
        }
        System.out.println(reversedNumber);
        return x!=reversedNumber ? false : true;
    }

    public static void main(String[] args) {
        System.out.println(PalindromeNumber.isPalindrome(10));
    } 
}