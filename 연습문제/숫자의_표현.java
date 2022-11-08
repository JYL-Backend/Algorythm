package 연습문제;

public class 숫자의_표현 {
    public int solution(int n) {
        return gogo(1,n, false);
    }

    private int gogo(int now, int n, boolean ing){
        if(n == 0) return 1;
        if(n < 0) return 0;
        if(now > n) return 0;
        if(ing) return gogo(now+1, n-now, true);
        return gogo(now+1, n-now, true) + gogo(now+1, n, false);
    }
}
