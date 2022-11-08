package 연습문제;

/**
 * @Date : 2022/11/08
 * @작성자 : jylim
 * @변경이력 :
 * @프로그램 설명 : 이진변환 반복하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */
public class 이진변환_반복하기 {
    public int[] solution(String s) {
        int[] result = new int[2];
        // 0 제거
        while(s.length() > 1){
            int zeroCnt = 0;
            int oneCnt = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '0') zeroCnt++;
                else oneCnt++;
            }
            result[1] += zeroCnt;
            s = Integer.toBinaryString(oneCnt);
            result[0]++;
        }
        return result;
    }
}
