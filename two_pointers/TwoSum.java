package two_pointers;

import java.util.Arrays;
import java.util.HashMap;

import utils.Assurance;

public class TwoSum {
  public static int[] twoSum(int[] nums, int target) {
    var map = new HashMap<Integer, Integer>();

    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }

    Arrays.sort(nums);
    int left = 0;
    int right = nums.length - 1;

    while(left < right) {
      int sum = nums[left] + nums[right];
      if (sum < target) {
        left++;
      } else if (sum > target) {
        right--;
      } else {
        break;
      }
    }

    return new int[]{
      map.get(nums[left]),
      map.get(nums[right]),
    };
  }
  public static void main(String[] args) {
      var res1 = twoSum(new int[]{ 2, 7, 11, 15}, 9);
      System.out.println(Arrays.toString(res1));
      Assurance.isEqualsArray(
        Arrays.stream(res1)
          .boxed()
          .toArray(),
          new Integer[]{0, 1},
          true);

  }
}
