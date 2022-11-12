package 연습문제;

public class q124 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            if (n % 3 == 0) {
                sb.insert(0, 4);
                n = n / 3 - 1;
            } else {
                sb.insert(0, String.valueOf(n % 3));
                n = n / 3;
            }
        }
        return sb.toString();
    }
}
