package MathsPower;

public class MathsPower {
    public static double myPow(double x, int n) {
        if (n == 0)  return 1.0;
        
        int a = n;
        double ans = 1.0;
        n = Math.abs(n);
        while (n != 0) {
            ans = ans * x;
            n--; // (2,4) 4->2 3->4 2->8 1->16
        }
        return (a>=0)? ans : (1/ans);
    }
    public static void main(String[] args) {
        System.out.println(myPow(2, 4));
    }
}
