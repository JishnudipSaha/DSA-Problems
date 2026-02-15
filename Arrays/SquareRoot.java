public class SquareRoot {
    public static int mySqrt(int x) {
        if (x < 2) return x;
        // using binary search to find sqrt
        long start = 1;
        long end = x;
        end = x/2;
        while (start <= end){
            long mid = (start + end)/2;
            if (mid*mid == (long) x){
                return (int) mid;
            }else if(mid*mid > (long) x){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return (int) end;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599)); // 46339 as result not 1073695483
    }
}
