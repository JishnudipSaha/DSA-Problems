package SortingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTrack(nums, used, new ArrayList<>(), result);
        return result;
    }
    void backTrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result){
        // add the base case at the top
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            // skipping if used
            if (used[i]) continue;
            // skipping for duplicates
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            // choose
            used[i] = true;
            current.add(nums[i]);
            //explore
            backTrack(nums, used, current, result);
            // undo
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
    public static void main(String[] args) {
        Permutation p = new Permutation();
        List<List<Integer>> result = p.permuteUnique(new int[]{1,2,3});
        for(List<Integer> n: result){
            for(int i: n){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
