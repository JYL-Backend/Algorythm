package 연습문제;

public class 최고의_집합 {
    public int[] solution(int n, int s) {

        if(s < n) return new int[] {-1};

        int[] result = new int[n];
        int mid = s/n;
        int nam = s % n;

        for(int i=0; i<n ; i++){
            if(nam+i >= n) result[i]=mid+1;
            else result[i] = mid;
        }
        return result;
    }
}
