

public class WordSearch {

    public static void main(String[] args) {
        char[][] grid1 = new char[][] {
            {'c', 'c', 't', 'n', 'a', 'x'},
            {'c', 'c', 'a', 't', 'n', 't'},
            {'a', 'c', 'n', 'n', 't', 't'},
            {'t',  'n', 'i',  'i',  'p', 'p'},
            {'a', 'o', 'o', 'o', 'a', 'a'},
            {'s', 'a', 'a', 'a', 'o', 'o'},
            {'k', 'a', 'i', 'o', 'k', 'i'},
        };
        String word1 = "ooo";
        List<int[]> res = getWordPath(grid1, word1);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i)[0]);
            System.out.println(res.get(i)[1]);
        }
    }
    private static final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static List<int[]> getWordPath(char[][] grid, String word) {
        List<int[]> res = new ArrayList<>();
        if (grid == null || grid.length == 0 || grid[0].length == 0 || word == null || word.length() == 0) {
            return res;
        }

        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                visited[row][col] = true;
                if (dfs(grid, word, row, col, 0, visited, res)) {
                    return res;
                }
                visited[row][col] = false;
            }
        }
        return res;
    }

    private static boolean dfs(char[][] board, String word, int row, int col, int index,
                               boolean[][] visited, List<int[]> res) {
        int rows = board.length, cols = board[0].length;
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        res.add(new int[]{row, col});
        if (index == word.length() - 1) {
            return true;
        }

        for (int[] dir : DIRS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                continue;
            }
            if (visited[newRow][newCol]) {
                continue;
            }
            visited[newRow][newCol] = true;
            if (dfs(board, word, newRow, newCol, index + 1, visited, res)) {
                return true;
            }
            visited[newRow][newCol] = false;
        }
        res.remove(res.size() - 1);
        return false;
    }
