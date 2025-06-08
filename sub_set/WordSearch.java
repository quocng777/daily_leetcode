package sub_set;

import utils.Assurance;

public class WordSearch {
  public static boolean exist(char[][] board, String word) {
    boolean[][] visited = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (backtrack(i, j, board, "", visited, word)) {
          return true;
        } 
    }
  }

    return false;
  }

  public static boolean  backtrack(int rowIdx, int colIdx, char[][] board, String current, boolean[][] visited, String target) {
    if (rowIdx < 0 || rowIdx >= board.length) {
      return false;
    }

    if (colIdx < 0 || colIdx >= board[0].length) {
      return false;
    }

    if (visited[rowIdx][colIdx]) {
      return false;
    }

    current += board[rowIdx][colIdx];
    visited[rowIdx][colIdx] = true;

    if (current.equals(target)) {
      return true;
    } else if (!target.contains(current)) {
      visited[rowIdx][colIdx] = false;
      return false;
    }

    if (
      backtrack(rowIdx - 1, colIdx, board, current, visited, target) ||
      backtrack(rowIdx + 1, colIdx, board, current, visited, target) || 
      backtrack(rowIdx, colIdx - 1, board, current, visited, target) ||
      backtrack(rowIdx, colIdx + 1, board, current, visited, target)
    ) {
      return true;
    }

    visited[rowIdx][colIdx] = false;
    return false;
  }
  public static void main(String[] args) {
    // [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    var input1 = new char[][] {
      new char[] { 'A', 'B', 'C', 'E'},
      new char[] { 'S', 'F', 'C', 'S'},
      new char[] { 'A', 'D', 'E', 'E'},
    };

    var target1 = "ABCCED";
    try {
        exist(input1, target1);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

    Assurance.isEquals(
      exist(input1, target1),
      true
    );
  }
}
