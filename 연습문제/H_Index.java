package 연습문제;

import java.util.Arrays;

public class H_Index {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int gap = citations.length * -1;

        for(int i=citations.length; i>0; i--){
            if(citations[i+gap] >= i) return i;
            gap += 2;
        }
        return 0;
    }
}
