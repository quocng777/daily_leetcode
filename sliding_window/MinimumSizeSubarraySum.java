package sliding_window;

import utils.Assurance;

public class MinimumSizeSubarraySum {
  public static int minSubArrayLen(int target, int[] nums) {
    var currentSum = nums[0];
    var sum = nums[0];
    var start = 0;
    var end = 0;
    var currentStart = 0;


    for (int i = 1; i < nums.length; i++) {
      currentSum += nums[i];
      if (currentSum < target) {
        continue;
      } else if (currentSum == target) {
        sum = target;
        end = i;
        continue;
      }

      if (currentSum > target) {
        while(currentSum - nums[currentStart] >= target && currentStart < nums.length - 1) {
          currentSum -= nums[currentStart];
          currentStart++;
        }
      }

      if (sum < target || currentSum <= sum) {
        sum = currentSum;
        start = currentStart;
        end = i;
      }
    }

    if (sum < target) {
      return 0;
    } 
    return end - start + 1;
  }

  public static int actualSolution(int target, int[] nums) {
    int sum = 0;
    int left = 0;
    int minLength = Integer.MAX_VALUE;
    
    for (int right = 0; right < nums.length; right++ ) {
      sum += nums[right];

      if (sum < target) {
        continue;
      }

      while(sum - nums[left] >= target) {
        sum -= nums[left];
        left++;
      }

      minLength = Math.min(minLength, right - left + 1);
    }

    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }

  public static void main(String[] args) {
    int[] input1 = {2,3,1,2,4,3};
    int output1 = 2;

    var res1 = actualSolution(7, input1);
    System.out.println(res1);
    Assurance.isEquals(output1, res1);

    int[] input2 = {1, 4, 4};
    int output2 = 1;
    var res2 = actualSolution(4, input2);
    System.out.println(res2);
    Assurance.isEquals(output2, res2);

    int[] input3 = {1,1,1,1,1,1,1,1};
    int output3 = 0;
    var res3 = actualSolution(11, input3);
    System.out.println(res3);
    Assurance.isEquals(output3, res3);
  }
}
