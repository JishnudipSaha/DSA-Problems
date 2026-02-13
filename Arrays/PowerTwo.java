public class PowerTwo {
    public static boolean isPowerOfTwo(int n) {
        if (n < 0) return false;
        return ((n & (n-1)) == 0)?true:false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
    }
}
