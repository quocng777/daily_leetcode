package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
  public static List<List<Integer>> threeSum(int[] nums) {
    var result = new ArrayList<List<Integer>>();
    Arrays.sort(nums);
    if (nums.length < 3) {
      throw new RuntimeException("Array length must be greater than 2");
    }

    for (int i = 0; i < nums.length - 2; i ++) {
      int j = i + 1;
      int k = nums.length - 1;

      while(j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum > 0) {
          k--;
        } else if (sum < 0) {
          j++;
        } else {
          result.add(
            Arrays.asList(nums[i], nums[j], nums[k])
          );
          k--;
          j++;

        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(threeSum(new int[]{0, 0, 0}).toArray()));
  }
}
