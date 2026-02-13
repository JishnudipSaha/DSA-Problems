import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        // adding data to set
        for (int i = 0; i< nums.length; i++){
            set.add(nums[i]);
        }
        int longest = 0;
        int curr = 0;
        int streak = 0;
        for (int n: set){
            if (set.contains(n-1)) continue;
            curr = n;
            streak = 1;
            while (set.contains(curr+1)){
                curr++;
                streak++;
            }
            longest = Math.max(longest, streak);
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(longestConsecutive(new int[]{1,0,1,2}));
    }
}