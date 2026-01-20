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
        long N = n;   // prevent overflow
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1.0;
        while (N > 0) {
            if (N % 2 == 1) {
                ans *= x;
            }
            x *= x;
            N /= 2;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(myPow(2, -10));
    }
}
