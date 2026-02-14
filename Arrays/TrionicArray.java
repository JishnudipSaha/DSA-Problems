public class TrionicArray {
    public static boolean isTrionic(int[] nums) {
        int i = 0;
        while (i+1 < nums.length && nums[i] < nums[i+1]) i++;
        if (i == 0 || i == nums.length-1) return false;

        while (i+1 < nums.length && nums[i] > nums[i+1]) i++;
        if (i == nums.length-1) return false;

        while (i+1 < nums.length && nums[i] < nums[i+1]) i++;
        if (i == nums.length-1) return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isTrionic(new int[]{1,3,5,4,2,6}));
    }
}
