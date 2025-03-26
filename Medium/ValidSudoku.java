import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // A list of 3 sets which contain used numbers. Each set represent a sub-square in the board 
        ArrayList<Set<Character>> seenSquare = new ArrayList<>();
        Set<Character> seenRow = new HashSet<>();
        // A map keep track of all used numbers in a column.
        HashMap<Integer, Set<Character>> colMap = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            seenSquare.add(new HashSet<>());
        }

        // Look at each row
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                // Ignore blank spots
                if (board[i][j] == '.') continue;
                //  If a row contain duplicates
                if (seenRow.contains(board[i][j])) {
                    return false;
                }
                // Else add the number
                seenRow.add(board[i][j]);
                
                if (!colMap.containsKey(j)) {
                    colMap.put(j, new HashSet<>());
                }
                // If the column contain duplicates
                if (colMap.get(j).contains(board[i][j])) {
                    return false;
                }
                // Else add the number
                colMap.get(j).add(board[i][j]);
                
                // If the j / 3 square contain duplicates
                if (seenSquare.get(j / 3).contains(board[i][j])) {  // floor division
                    return false;
                }
                // Else add the number
                seenSquare.get(j / 3).add(board[i][j]);

            }
            // Reset for a new row
            seenRow.clear();
            // Only reset seenSquare after 3 rows (that is after row 2 and row 5 (0-indexed))
            if (i == 2 || i == 5) {
                for (Set<Character> s: seenSquare) {
                    s.clear();
                }
            }
        }
        // Nothing wrong
        return true;
    }
}