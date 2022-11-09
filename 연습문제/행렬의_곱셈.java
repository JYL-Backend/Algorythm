package 연습문제;

public class 행렬의_곱셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i=0; i<answer.length; i++){
            for(int j=0; j<answer[0].length; j++){
                int sum = 0;
                for(int x=0; x<arr2.length; x++){
                    sum += arr1[i][x] * arr2[x][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
