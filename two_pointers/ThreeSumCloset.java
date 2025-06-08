package two_pointers;

import java.util.Arrays;

import utils.Assurance;

public class ThreeSumCloset {
  public static int threeSumClosest(int[] nums, int target) {
    if (nums.length < 3) {
      throw new RuntimeException("Not valid parameters");
    }
    int closetValue = Integer.MAX_VALUE;

    Arrays.sort(nums);
    
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];

        int gap = sum - target;

        if (Math.abs(gap) < Math.abs(closetValue - target)) {
          closetValue = sum;
        }

        if (sum > 0) {
          right--;
        } else if (gap < 0) {
          left++;
        } else {
          return sum;
        }
      }
    }

    return closetValue;
  }

  public static void main(String[] args) {
    Assurance.isEquals(
      threeSumClosest(new int[] {-1,2,1,-4}, 1),
      2);

    Assurance.isEquals(
      threeSumClosest(new int[] {0, 0, 0}, 1),
      0);
  }
}
