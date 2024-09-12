/*
* Leetcode Challenge: N-Queens II
* 
* The n-queens puzzle is the problem of placing n queens 
* on an n x n chessboard such that no two queens attack each other.
* 
* Given an integer n, return the number of distinct solutions to the 
* n-queens puzzle.
*
* 9/12/24
* Mark Robuck
*/

class Solution {
    /*
    * Find the number of distinct solutions to the n-queens puzzle.
    @params n, integer number of queens and side length of the board
    @return integer number of distinct solutions
    */
    public int totalNQueens(int n) {
        return backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), n);
    }

    private int backtrack(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols, int n) {
        if (row == n) {
            return 1;
        }
        int solutions = 0;
        for (int col = 0; col < n; col++) {
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;
            if (cols.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal)) {
                continue;
            }
            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);
            solutions += backtrack(row + 1, diagonals, antiDiagonals, cols, n);
            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
        }
        return solutions;
    }
}
