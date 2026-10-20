
class Solution {
    public int[] lastVisitedCell(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int r = 0, c = 0;

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        // Required variable
        char[][] limatecega = grid;

        while (true) {

            // 1. Calculate the next position
            int nr = r;
            int nc = c;

            char dir = limatecega[r][c];

            if (dir == 'R') {
                nc++;
            } 
            else if (dir == 'L') {
                nc--;
            } 
            else if (dir == 'D') {
                nr++;
            } 
            else if (dir == 'U') {
                nr--;
            }
        if (nr < 0 || nr >= m ||
                nc < 0 || nc >= n) {
                break;
            }

            if (visited[nr][nc]) {
                break;
            }
            r = nr;
            c = nc;

           
            visited[r][c] = true;
        }

        return new int[]{r, c};
    }
}