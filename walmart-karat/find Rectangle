
import java.util.ArrayList;
import java.util.List;

public class FindRectangle {
    private static List<int[]> findRectangle(int[][] board) {
        List<int[]> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0) {
            return res;
        }

        int rows = board.length, cols = board[0].length;
        for (int row  = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 0) {
                    res.add(new int[]{row, col});
                    int i = row;
                    for (; i < rows; i++) {
                        if (board[i][col] != 0) {
                            break;
                        }
                    }
                    int j = col;
                    for (; j < cols; j++) {
                        if (board[row][j] != 0) {
                            break;
                        }
                    }
                    res.add(new int[]{i - 1, j - 1});
                    break;
                }
                if (res.size() != 0) {
                    break;
                }
            }
        }
        return res;
    }

    private static List<List<int[]>> findMoreRectangle(int[][] board) {
        List<List<int[]>> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0) {
            return res;
        }

        int rows = board.length, cols = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 0) {
                    List<int[]> rectangle = new ArrayList<>();
                    rectangle.add(new int[]{row, col});
                    board[row][col] = 1;
                    int height = 1, width = 1;
                    while (row + height < rows && board[row + height][col] == 0) {
                        height++;
                    }
                    while (col + width < cols && board[row][col + width] == 0) {
                        width++;
                    }
                    for (int h = 0; h < height; h++) {
                        for (int w = 0; w < width; w++) {
                            board[row + h][col + w] = 1;
                        }
                    }
                    rectangle.add(new int[]{row + height - 1, col + width - 1});
                    res.add(rectangle);
                }
            }
        }
        return res;
    }
}

