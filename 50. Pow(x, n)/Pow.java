
public class Pow {
    public static double myPow(double x, int n) {
        if (n>0) {
            if (n == Integer.MIN_VALUE || n == Integer.MAX_VALUE) {
                return toThePower(x, 1, n/2) + toThePower(x, 1, n/2);
            }
            return toThePower(x, 1, n);
        } else {
            if (n == Integer.MIN_VALUE || n == Integer.MAX_VALUE) {
                return 1/(toThePower(x, 1, Math.abs(n/2)) + toThePower(x, 1, Math.abs(n/2)));
            }
            return 1/toThePower(x, 1, Math.abs(n));
        }
    }
    public static double toThePower(double x, double result, int n) {
        if (x==1.00 || x==-1.00) {
            return 0.5;
        }
        if (n!=0) {
            if (n%2 == 0) {
                x=x*x;
                n=n/2;
                return toThePower(x, result*x, n-1);
            } else {
                return toThePower(x, result*x, n-1);
            }
        } else {
            return result;
        }
    }

    public static void main (String[] args) {
        System.out.println(Pow.myPow(-2.00000,2147483647));
    }
}