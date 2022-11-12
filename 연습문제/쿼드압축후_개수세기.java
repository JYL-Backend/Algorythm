package 연습문제;

public class 쿼드압축후_개수세기 {
    public int[] solution(int[][] arr) {
        return calculate(arr,0,0,arr.length, arr[0].length);
    }
    public int[] calculate(int[][] arr, int y1, int x1, int y2, int x2){
        int count0 = 0;
        int count1 = 0;
        for(int y = y1; y < y2 ; y++){
            for(int x = x1; x < x2; x++){
                int val = arr[y][x];
                if(val == 0) count0++;
                else count1++;
            }
        }
        if(count0 == 0) return new int[]{0,1};
        if(count1 == 0) return new int[]{1,0};

        int midX = (x1 + x2)/2;
        int midY = (y1 + y2)/2;

        int[] cal1 = calculate(arr, y1,x1, midY, midX);
        int[] cal2 = calculate(arr, y1,midX, midY, x2);
        int[] cal3 = calculate(arr, midY,x1, y2, midX);
        int[] cal4 = calculate(arr, midY,midX, y2, x2);

        return new int[] {cal1[0]+cal2[0]+cal3[0]+cal4[0],cal1[1]+cal2[1]+cal3[1]+cal4[1]};
    }
}
