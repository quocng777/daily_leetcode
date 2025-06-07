package sliding_window;

import java.util.HashMap;

import utils.Assurance;

public class LongestSubString {
  public static int longestSubStr(String str, int target) {
    int maxLength = -1;
    var map = new HashMap<Character, Integer>();
    int start = 0;

    for (int i = 0; i < str.length(); i++) {
      char curChar = str.charAt(i);
      if ((!map.containsKey(curChar) && map.size() < target) || map.containsKey(curChar)) {
        map.put(curChar, map.getOrDefault(curChar, 0) + 1);
      } else {
        while(map.size() >= target) {
          int numOfStartChar = map.getOrDefault(str.charAt(start), 0);
          if (numOfStartChar > 1) {
            map.put(str.charAt(start), numOfStartChar - 1);
          } else {
            map.remove(str.charAt(start));
          }
          start++;
        }
        map.put(curChar, map.getOrDefault(curChar, 0) + 1);
      }

      if (map.size() == target) {
        maxLength = Math.max(maxLength, i - start + 1);
      }
    }

    return maxLength;
  }

  public static void main(String[] args) {
    Assurance.isEquals(longestSubStr("aabacbebebe", 3), 7);
    System.out.println(longestSubStr("aaaa", 2));        // Output: -1
    System.out.println(longestSubStr("aabaaab", 2));
  }
}
