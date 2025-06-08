package merge_intervals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
  public static int[][] merge(int[][] intervals) {
    // sort intervals
    Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
    var result = new ArrayList<int[]>();
    result.add(intervals[0]);

    for (int i = 1; i < intervals.length; i++) {
      var current = intervals[i];
      var intervalNeededCheck = result.get(result.size() - 1);
      boolean isOverlapped = false;

      if (current[0] <= intervalNeededCheck[1]) {
        isOverlapped = true;
      }

      if (isOverlapped) {
        intervalNeededCheck[1] = current[1];
      } else {
        result.add(current);
      }
    }

    return result.stream().toArray(int[][]::new);
  }

  public static void main(String[] args) {
    // Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    // Output: [[1,6],[8,10],[15,18]]

    for (var arr : merge(
        new int[][] {
          new int[] {1, 3},
          new int[] {2, 6},
          new int[] {8, 10},
          new int[] {15, 18},
        }
      )) {
        System.out.println(Arrays.toString(arr));
      }
  }
}
