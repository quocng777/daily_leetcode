package merge_intervals;

import java.util.ArrayList;

public class IntervalListIntersection {

  public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    var res = new ArrayList<int[]>();

    int i = 0;
    int j = 0;

    while (i < firstList.length && j < secondList.length) {
      var start = Math.max(firstList[i][0], secondList[j][0]);
      var end = Math.min(firstList[i][1], secondList[j][0]);

      if (start <= end) {
        res.add(new int[] {start, end});
      }

      if (firstList[i][1] > firstList[j][1]) {
        i++;
      } else {
        j++;
      }
    }

    return res.toArray(int[][]::new );
  }

  public static void main(String[] args) {
    
  }
}
