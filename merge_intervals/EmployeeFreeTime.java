package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeFreeTime {
  // TIME_RAGE: 1 - 12
  public static int[][] getFreeTimes(int[][] workingTimes) {
    var res = new ArrayList<int[]>();
    for (int i = 0; i <= workingTimes.length; i++) {
      int start;
      int end;
      if (i == 0) {
        if (workingTimes[0][0] == 1) continue;
        start = 1;
        end = workingTimes[0][0];
      } else if (i == workingTimes.length) {
        if (workingTimes[i - 1][1] == 12) continue;
        start = workingTimes[i - 1][1];
        end = 12;
      } else {
        start = workingTimes[i - 1][1];
        end = workingTimes[i][0];
      }
      
      res.add(new int[] {start, end});
    }

    return res.toArray(int[][]::new);
  }

  public static int[][] employeeFreeTime(int[][][] workingTimes) {
    var freeTimes = new ArrayList<int[][]>();
    int[][] res;
    for (var workingTimeOfEmployee : workingTimes) {
      freeTimes.add(getFreeTimes(workingTimeOfEmployee));
    }

    var freeTimesArrs = freeTimes.toArray(int[][][]::new);
    res = getIntervals(
      Arrays.copyOfRange(freeTimesArrs, 0, freeTimesArrs.length / 2),
      Arrays.copyOfRange(freeTimesArrs, freeTimesArrs.length / 2, freeTimesArrs.length)
    );

    return res;
  }

  public static int[][] getIntervals(int[][][] collection1, int[][][] collection2) {
    int[][] intervals1 = null, intervals2 = null;
    if (collection1.length > 1) {
      intervals1 = getIntervals(Arrays.copyOfRange(collection1, 0, collection1.length / 2), Arrays.copyOfRange(collection1, collection1.length / 2, collection1.length));
    } else if (collection1.length == 1) {
      intervals1 = collection1[0];
    }

    if (collection2.length > 1) {
      intervals2 = getIntervals(Arrays.copyOfRange(collection2, 0, collection2.length / 2), Arrays.copyOfRange(collection2, collection2.length / 2, collection2.length));
    } else if (collection2.length == 1) {
      intervals2 = collection2[0];
    }

    if (collection1.length == 0 || collection2.length == 0) {
      return collection1.length == 0 ? intervals2 : intervals1;
    }

    var res = new ArrayList<int[]>();

    int i = 0;
    int j = 0;
    while (i < intervals1.length && j < intervals2.length) {
      int start = Math.max(intervals1[i][0], intervals2[j][0]);
      int end = Math.min(intervals1[i][1], intervals2[j][1]);

      if (start <= end) {
        res.add(new int[] { start, end });
      }

      if (intervals1[i][1] > intervals2[j][1]) {
        j++;
      } else {
        i++;
      }
    }

    return res.toArray(int[][]::new);
  }

  public static void main(String[] args) {
    // [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
    for (var arr : employeeFreeTime(
      new int[][][] {
        new int[][] {
          new int[] {1, 3},
          new int[] {6, 7}
        },
        new int[][] {
          new int[] {2, 4},
        },
        new int[][] {
          new int[] {2, 5},
          new int[] {9, 12}
        },
      }
    )) {
      System.out.println(Arrays.toString(arr));
    }
  }
}
