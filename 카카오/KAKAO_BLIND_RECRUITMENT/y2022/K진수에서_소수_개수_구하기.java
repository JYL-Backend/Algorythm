package 카카오.KAKAO_BLIND_RECRUITMENT.y2022;

public class K진수에서_소수_개수_구하기 {
    public int solution(int n, int k) {
        String jinStr = convertJin(n, k);
        String[] splits = jinStr.split("0");
        int answer = 0;
        for(String split : splits){
            answer += isPrime(split) ? 1 : 0;
        }
        return answer;
    }
    private String convertJin(int n, int k){
        StringBuilder sb = new StringBuilder();
        while(n != 1 && n != 0){
            int nam = n%k;
            sb.insert(0,nam);
            n /= k;
        }
        if(n == 1) sb.insert(0,1);
        return sb.toString();
    }

    private boolean isPrime(String str){
        if(str.length()== 0)return false;
        long n = Long.parseLong(str);
        if( n==0 || n==1) return false;
        for(int i=2; i<= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }}
