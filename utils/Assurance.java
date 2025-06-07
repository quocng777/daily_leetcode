package utils;

import java.util.Arrays;

public class Assurance {
  public static <T> void isEqualsArray(T[] arr1, T[] arr2) {
    if (arr1.length != arr2.length) {
      throw new RuntimeException("Two array are not equal: Length");
    }
    
    for(int i = 0; i < arr1.length; i++) {
      if (arr1[i] != arr2[i]) {
        throw new RuntimeException("Two array are not equal: " + i);
      }
    }

    System.out.print("Passed");
  }

  public static <T> void isEqualsArray(T[] arr1, T[] arr2, boolean ignoreOrder) {
    if (ignoreOrder) {
      Arrays.sort(arr1);
      Arrays.sort(arr2);
    }

    isEqualsArray(arr1, arr2);
  }

  public static <T> void isEquals(T arr1, T arr2) {
    if (!arr1.equals(arr2)) 
      throw new RuntimeException("Two object are not equal");

    System.err.println("Passed");
  }
}
