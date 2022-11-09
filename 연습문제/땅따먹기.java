package 연습문제;

public class 땅따먹기 {
    int memo[][];
    public int solution(int[][] l) {
        memo = new int[l.length][5];
        return s(l,0, 4);
    }

    int s(int[][] l, int row, int prevCol){
        if(row == l.length) return 0;
        if(memo[row][prevCol] != 0) return memo[row][prevCol];
        for (int i=0; i<4; i++){
            if(i == prevCol) continue;
            int value = l[row][i] + s(l, row+1, i);
            memo[row][prevCol] = memo[row][prevCol] > value ? memo[row][prevCol] : value;
        }
        return memo[row][prevCol];
    }
}
