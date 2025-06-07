package sliding_window;

import java.util.Arrays;

import utils.Assurance;

public class MaximumSubarray  {
  public static Integer[] findSubArray(Integer[] nums) {

    int maxSum = Integer.MIN_VALUE;
    int currentSum = 0;

    int startIdx = 0;
    int endIdx = 0;

    int currentStartIdx = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0 &&  maxSum < -nums[i]) {
        currentStartIdx = i;
        currentSum = nums[i];
        continue;
      }

      currentSum += nums[i];

      if (currentSum > maxSum) {
        if (nums[currentStartIdx] < 0) {
          currentStartIdx = i;
        }
        endIdx = i;
        startIdx = currentStartIdx;
        maxSum = currentSum;
      }
    }

    return Arrays.copyOfRange(nums, startIdx, endIdx + 1);
  }

  public static void printResult(Integer[] res) {
    var sum = 0;
    System.out.print("\nArray: [ ");
    for (int val : res) {
      System.out.print(val+ ", ");
      sum += val;
    }
    System.out.print("]\n");
    System.out.println("Sum " + sum);
  }

  public static Integer[] actualSolution(Integer[] nums) {
    if (nums.length == 1) {
      return nums;
    }

    var maxSum = nums[0];
    var currentSum = nums[0];

    var start = 0;
    var end = 0;
    var currentStart = 0;

    for (int i = 1; i < nums.length; i++) {
      var current = nums[i];
      if (current > currentSum + current) {
        currentSum = current;
        currentStart = i;
      } else {
        currentSum += current;
      }

      if (currentSum > maxSum) {
        start = currentStart;
        end = i;
        maxSum = currentSum;
      } 
    }

    return Arrays.copyOfRange(nums, start, end + 1);
  }

  public static void main(String[] args) {
    // test case 1
    Integer[] case1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
    Integer[] expected1 = { 4, -1, 2, 1};
    var result1 = actualSolution(case1);

    printResult(result1);
    Assurance.isEqualsArray(expected1, result1);
    System.out.println("Testcase 1: Passed");

    Integer[] case2 = { 5, 4, -1, 7, 8};
    Integer[] expected2 = { 5, 4, -1, 7, 8};
    var result2 = actualSolution(case2);

    printResult(result2);
    Assurance.isEqualsArray(expected2, result2);
    System.out.println("Testcase 2: Passed");
  }
}