package sub_set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
  public static List<List<Integer>> permutation(int[] nums) {
    var res = new ArrayList<List<Integer>>();

    backtrack(new HashSet<>(Arrays.stream(nums).boxed().toList()), new ArrayList<>(), res);

    return res;
  }

  public static void backtrack(Set<Integer> remaining, List<Integer> current, List<List<Integer>> res) {
    for (var ele : remaining) {
      current.add(ele);
      var newSet = new HashSet<>(remaining);
      newSet.remove(ele);
      backtrack(newSet, current, res);
      
      if (newSet.isEmpty()) {
        res.add(new ArrayList<>(current));
      }
      current.remove(ele);
    }
  }

  public static void main(String[] args) {
    System.out.println(
      permutation(new int[] {
        1, 2, 3
      })
    );
  }
}
