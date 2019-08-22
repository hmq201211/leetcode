class Solution {
    public int countCornerRectangles(int[][] grid) {
        int toReturn = 0;
        for (int i = 0; i + 1 < grid.length; i++) {
            for (int j = i + 1; j < grid.length; j++) {
                int columnCounter = 0;
                for (int k = 0; k < grid[0].length; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) {
                        columnCounter += 1;
                    }
                }
                toReturn += columnCounter * (columnCounter - 1) / 2;
            }
        }
        return toReturn;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0, 1, 0}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 0, 1}};
        System.out.println(new Solution().countCornerRectangles(grid));
    }
}