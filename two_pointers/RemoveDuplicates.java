package two_pointers;

import utils.Assurance;

public class RemoveDuplicates {
  public static int removeDuplicates(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      count++;
      while(i < nums.length - 1 && nums[i + 1] == nums[i]) {
        i++;
      }
    }

    return count;
  }
  public static void main(String[] args) {
    Assurance.isEquals(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}), 5);
  }
}
