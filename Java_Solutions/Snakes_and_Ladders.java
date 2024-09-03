/*
* Leetcode Challenge: Snakes and Ladders
*
* You are given an n x n integer matrix board where the cells are 
* labeled from 1 to n2 in a Boustrophedon style starting from the 
* bottom left of the board (i.e. board[n - 1][0]) and alternating 
* direction each row.
*
* You start on square 1 of the board. In each move, starting from square 
* curr, do the following:
*
* Choose a destination square next with a label in the range 
* [curr + 1, min(curr + 6, n2)].
* This choice simulates the result of a standard 6-sided die roll: i.e., 
* there are always at most 6 destinations, regardless of the size of the board.
* If next has a snake or ladder, you must move to the destination of that 
* snake or ladder. Otherwise, you move to next.
* The game ends when you reach the square n2.
*
* A board square on row r and column c has a snake or ladder 
* if board[r][c] != -1. The destination of that snake or ladder 
* is board[r][c]. Squares 1 and n2 are not the starting points 
* of any snake or ladder.
*
* Note that you only take a snake or ladder at most once per move. 
* If the destination to a snake or ladder is the start of another 
* snake or ladder, you do not follow the subsequent snake or ladder.
*
* For example, suppose the board is [[-1,4],[-1,3]], and on the first 
* move, your destination square is 2. You follow the ladder to square 3, 
* but do not follow the subsequent ladder to 4.
* Return the least number of moves required to reach the square n2. If it 
* is not possible to reach the square, return -1.
*
* 9/3/24
* Mark Robuck
*/
import java.util.*;

class Solution{
    /*
    * Determine the minimum number of moves to reach the end of a 
    * snakes and ladders board.
    * @params board, board configuration as a list of integers
    * @return minimum number of moves to reach the end of board as an integer
    */
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        //track visited nodes
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(new int[]{1, 0});
        visited.add(1);
        
        //simulate possible moves, adjusting for snakes and ladders
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curr = current[0];
            int moves = current[1];
            
            for (int i = 1; i <= 6; i++) {
                int nextSquare = curr + i;
                if (nextSquare > n * n) continue;
                
                int[] pos = getPosition(nextSquare, n);
                int r = pos[0];
                int c = pos[1];
                
                if (board[r][c] != -1) {
                    nextSquare = board[r][c];
                }
                
                if (nextSquare == n * n) {
                    return moves + 1;
                }
                
                if (!visited.contains(nextSquare)) {
                    visited.add(nextSquare);
                    queue.offer(new int[]{nextSquare, moves + 1});
                }
            }
        }
        
        return -1;
    }

    /*
    * Convert the square number s to (r, c) in the board
    * @params s, square number as an integer
    * @params n, size of the board
    * @return rows and columns as an int array
    */
    private int[] getPosition(int s, int n) {
        int quot = (s - 1) / n;
        int rem = (s - 1) % n;
        int row = n - 1 - quot;
        int col = (quot % 2 == 0) ? rem : (n - 1 - rem);
        return new int[]{row, col};
    }
}
