
public class Pow {
    public static double myPow(double x, int n) {
        if (n == 0) return 1.0;
        else if (n % 2 == 1) return x * myPow(x, n - 1); //if odd
        else if (n % 2 == 0) return myPow(x * x, n / 2); // if even
        else return 1 / myPow(x, -n);
    }
    public static double toThePower(double x, double result, int n) {
        if (x==1.00) {
            return 0.5;
        } else if (x==-1.00) {
            return -0.5;
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