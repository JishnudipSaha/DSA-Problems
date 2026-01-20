package MathsPower;

public class MathsPower {
    /*
        need proper maths formulation:
        for n if even :
        ((x)^2)^n/2
        if n  is odd:
        x.(((x)^2)^(n-1 / 2))
         */
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        int N = n;
        double ans = 1.0;
        n = Math.abs(n);
        // checking even or odd then procedding as per to it.
        if (n%2 == 0) {
            //if even: ((x)^2)^n/2
            int num = n/2;
            double a = (x*x); // 4
            while (num != 0) { // 
                ans = ans * a;
                num -= 1;
            }
        }else{
            //if odd: x.(((x)^2)^(n-1 / 2))
            int num = (n-1)/2;
            double a = (x*x);
            while (num != 0) {
                ans = ans * a;
                num -= 1;
            }
            ans = x * ans;
        }
        return (N>=0)? ans : (1/ans);
    }
    public static void main(String[] args) {
        System.out.println(myPow(2, -10));
    }
}
