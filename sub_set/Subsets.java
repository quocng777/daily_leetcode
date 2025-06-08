package sub_set;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
  public static List<List<Integer>> subsets(int[] nums) {
    var res = new ArrayList<List<Integer>>();


  }

  public static void backtrack (int idx, int[] nums, List<Integer> currentSet, List<List<Integer>> res) {
    res.add(new ArrayList<>(currentSet));

    for (int i = idx; i < nums.length; i++) {
      currentSet.add(nums[i]);
      backtrack(idx + 1, nums, currentSet, res);
      currentSet.remove(idx);
    }
  }
}
