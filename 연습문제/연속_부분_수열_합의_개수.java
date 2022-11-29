package 연습문제;

import java.util.HashSet;
import java.util.Set;

public class 연속_부분_수열_합의_개수 {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i< elements.length; i++){
            int sum = 0;
            for(int j=0; j<elements.length; j++){
                sum += elements[(i+j)%elements.length];
                set.add(sum);
            }
        }
        return set.size();
    }
}
