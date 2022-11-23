package 월간_코드_챌린지;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 삼각달팽이{
        public static int DOWN = 0;
        public static int RIGHT = 1;
        public static int UP = 2;
        public int[] solution(int n) {
            int maxCount = 0;
            for(int i=1; i<=n; i++) maxCount++;
            int[][] board = new int[n][n];
            cal(board,0,0,DOWN, 1,maxCount);
            int[] answer = Arrays.stream(Arrays.stream(board).toArray(Integer[][]::new))
                    .flatMap(row -> Arrays.stream(row))
                    .filter(o -> o != 0)
                    .mapToInt(i->i).toArray();
            return answer;
        }
        private boolean cal(int[][] board, int y, int x, int dir, int count, int maxCount){
            if(y == board.length || y == -1 || x == board.length || x == -1) return false;
            if(board[y][x] != 0) return false;
            if(count == maxCount) return false;
            if(dir == DOWN){
                return cal(board, y+1, x, dir, count+1,maxCount) || cal(board, y, x+1, RIGHT, count+1,maxCount);
            }
            if(dir == RIGHT){
                return cal(board, y, x+1, dir, count+1,maxCount) || cal(board, y-1, x-1, UP, count+1,maxCount);
            }
            if(dir == UP){
                return cal(board, y-1, x-1, dir, count+1,maxCount) || cal(board, y+1, x, DOWN, count+1,maxCount);
            }
            return true;
        }
}
