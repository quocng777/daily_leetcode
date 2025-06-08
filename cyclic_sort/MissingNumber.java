package cyclic_sort;

import java.util.Arrays;

public class MissingNumber {
  public static int missingNumber(int[] nums) {
    // firstly sort this arrays
    var i = 0;
    while (i < nums.length) {
      if (nums[i] == nums.length) {
        i++;
        continue;
      }

      if (nums[i] == i) {
        i++;
        continue;
      }

      var temp = nums[nums[i]];
      nums[nums[i]] = nums[i];
      nums[i] = temp;
    }

    System.out.println(Arrays.toString(nums));

    for (i = 0; i < nums.length; i++) {
      if (i != nums[i]) {
        return i;
      }
    }

    return nums.length;
  }

  public static void main(String[] args) {
    System.out.println(
      missingNumber(new int[] {
        9, 6, 4, 2, 3, 5, 7, 0, 1
      })
    );
  }
}
