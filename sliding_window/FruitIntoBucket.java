package sliding_window;

import java.util.HashMap;
import utils.Assurance;

public class FruitIntoBucket {
  public static int totalFruit(int[] fruits) {
    final int MAX_BUCKETS = 2;
    int maxFruit = 0;
    int left = 0;
    var bucketsMap = new HashMap<Integer, Integer>();

    for (int right = 0; right < fruits.length; right++) {
      int currentFruit = fruits[right];
      if (
        (!bucketsMap.containsKey(currentFruit) && bucketsMap.size() < MAX_BUCKETS) ||
        bucketsMap.containsKey(currentFruit)
      ) {
        bucketsMap.put(currentFruit, bucketsMap.getOrDefault(currentFruit, 0) + 1);
      } else {
        while(bucketsMap.size() >= MAX_BUCKETS) {
          int numOfFruits = bucketsMap.getOrDefault(fruits[left], 0);
          if (numOfFruits > 1) {
            bucketsMap.put(fruits[left], numOfFruits - 1);
          } else {
            bucketsMap.remove(fruits[left]);
          }

          left++;
        }
      }

      maxFruit = Math.max(maxFruit, right - left + 1);
    }

    return maxFruit;
  }
  public static void main(String[] args) {
      Assurance.isEquals(totalFruit(new int[]{1, 2, 1}), 3);

      Assurance.isEquals(totalFruit(new int[]{0, 1, 2, 2}), 3);

      Assurance.isEquals(totalFruit(new int[]{1, 2, 3, 2, 2}), 4);
  }
}
