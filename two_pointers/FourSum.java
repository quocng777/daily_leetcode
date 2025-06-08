package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
  public static List<List<Integer>> fourSum(int[] nums, int target) {
    if(nums.length < 4) {
      throw new RuntimeException("Not valid value");
    }

    Arrays.sort(nums);

    var res = new ArrayList<List<Integer>>();
    for (int i = 0; i < nums.length - 3; i++) {
      for (int j = i + 1; j < nums.length - 2; j++) {
        if (i > 0 && nums[i] == nums[i - 1]) {
          continue;
        } 
        if (nums[j] == nums[j - 1]) {
          continue;
        }

        int left = j + 1;
        int right = nums.length - 1;

        while (left < right) {
          int sum = nums[i] + nums[j] + nums[left] + nums[right];

          if (sum > target) {
            right--;
          } else if (sum < target) {
            left++;
          } else {
            res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
            right--;
            left++;
          }
        }
      }
    }
    
    return res;
  }

  public static void main(String[] args) {
    System.out.println(fourSum(
        new int[] {1,0,-1,0,-2,2}
      ,0).toString());
  }
}
