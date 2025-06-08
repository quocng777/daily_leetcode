package cyclic_sort;

import java.util.ArrayList;
import java.util.List;

public class FindAllMissingNumbers {
  public static List<Integer> findDisappearedNumbers(int[] nums) {
    var i = 0;
    var res = new ArrayList<Integer>();

    while (i < nums.length) {
      if (nums[i] > nums.length || nums[i] == i + 1) {
        i++;
        continue;
      }

      var temp = nums[nums[i] - 1];
      nums[nums[i] - 1] = nums[i];
      nums[i] = temp;
    }

    for (i = 0; i < nums.length; i++) {
      if (i != nums[i] - 1) {
        res.add(i);
      }
    }

    return res;
  }

  public static void main(String[] args) {
    System.out.println(
      findDisappearedNumbers(
        new int[] {
          4,3,2,7,8,1
        }
      )
    );
  }
}
