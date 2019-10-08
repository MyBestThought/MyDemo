//剑指offer65题
public class RobotRange {
    public int movingCount(int threshold, int rows, int cols){
        boolean[][] visited = new boolean[rows][cols];
        return countStep(threshold, rows, cols, 0, 0, visited);
    }
    public int countStep(int threshold, int rows, int cols, int row, int col, boolean[][] visited){
        if(row <0 || row >= rows || col < 0 || col >= cols
          || visited[row][col] || bitsum(row) + bitsum(col) > threshold){
            return 0;
        }
        visited[row][col] = true;
        return countStep(threshold, rows, cols, row-1, col, visited)
            + countStep(threshold, rows, cols, row, col-1, visited)
            + countStep(threshold, rows, cols, row+1, col, visited)
            + countStep(threshold, rows, cols, row, col+1, visited)
            + 1;
    }
    public int bitsum(int num){
        int count = 0;
        while(num != 0){
            count += num % 10;
            num /= 10;
        }
        return count;
    }
}