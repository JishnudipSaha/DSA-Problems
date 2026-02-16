public class MoveZeros {
    public static int[] moveZeroes(int[] nums) {
        int idx = 0;
        int recentZero = -1;
        while (idx < nums.length){
            if (nums[idx] == 0 && recentZero == -1){
                recentZero = idx;
            }
            if (nums[idx] != 0 & recentZero != -1){
                nums[recentZero] = nums[idx];
                nums[idx] = 0;
                // resetting the index
                recentZero += 1;
                idx = recentZero;
            }
            idx++;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = moveZeroes(new int[]{0, 1, 0, 3, 23, 0, 44, 0, 12});
        for (int n: arr){
            System.out.print(n + " ");
        }
    }
}