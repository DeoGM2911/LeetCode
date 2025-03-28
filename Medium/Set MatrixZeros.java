class Solution {
    public void setZeroesConstantSpace(int[][] matrix) {
        // Modify first row/col?. Since we used the first row/col to keep track of which row/column need changes 
        boolean firstCol = false;
        boolean firstRow = false;
        boolean root = false;
        if (matrix[0][0] == 0) root = true;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) firstCol = true;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) firstRow = true;
        }

        // Find which row/col need replacing
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                matrix[0][0] = 0;
            }
            for (int j = 1; j < matrix[0].length; j++) {
                
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Edit rows and cols (from row = 1 and col = 1)
        for (int col = 1; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                for (int r = 0; r < matrix.length; r++) {
                    matrix[r][col] = 0;
                }
            }
        }
        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                for (int c = 0; c < matrix[0].length; c++) {
                    matrix[row][c] = 0;
                }
            }
        }

        // Restore/Edit the first col and row
        if (root) {
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][0] = 0;
            }
            for (int c = 1; c < matrix[0].length; c++) {
                matrix[0][c] = 0;
            }
        }
        
        // Update first row and first column
        if (firstCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            } 
        }
        if (firstRow) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            } 
        }
    }

    public void setZeroes(int[][] matrix) {
        // Find which row/col need replacing
        boolean[] rowFlag = new boolean[matrix.length];
        boolean[] colFlag = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowFlag[i] = true;
                    colFlag[j] = true;
                }
            }
        }

        // Edit rows and cols
        for (int col = 0; col < matrix[0].length; col++) {
                for (int row = 0; row < matrix.length; row++) {
                    if (colFlag[col] || rowFlag[row]) {
                        matrix[row][col] = 0;
                    }
                }
        }
    }
}