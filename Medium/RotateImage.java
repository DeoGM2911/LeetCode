class RotateImage {
    /**
     * @author: Dung Tran (DeoGM2911)
     * @date: 25/03/2025
     */
    /**
     * Transpose a matrix in place
     * @param: matrix - a nxn matrix
     */
    public void transpose(int[][] matrix) {
        // Swap element (i, j) for (j, i)
        int temp;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j ++) {  // We only care about the lower (or upper) triangle half
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    /**
     * Flip a matrix vertically down the middle.
     */
    public void hFlip(int[][] matrix) {
        // We simply swap matrix[i][j] with matrix[i][n-j-1] for all i and j.
        int temp;
        for (int i = 0; i < matrix.length; i++) {
            int l = 0, r = matrix.length-1;
            while (l < r) {
                temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++; r--;
            }
        }
    }
    /**
     * Rotate an image by 90 degree clockwise.
     */
    public void rotate(int[][] matrix) {
        // Idea: Rotate 90 degree clock wise move (i, j) to become (-j, i). This is
        // equivalent to take the transpose and then flip vertically.
        transpose(matrix);
        hFlip(matrix);
    }
}