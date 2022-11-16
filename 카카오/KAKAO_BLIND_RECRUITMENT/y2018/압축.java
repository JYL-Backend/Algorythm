package 카카오.KAKAO_BLIND_RECRUITMENT.y2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 압축 {
    public int[] solution(String msg) {
        HashMap<String, Integer> dictionary = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        int index = 1;
        for(int i=65; i<=90; i++){
            dictionary.put(String.valueOf((char)i), index++);
        }
        for(int left=0; left<msg.length(); left++){
            for(int right=msg.length(); right>left; right--){
                String findStr = msg.substring(left, right);
                if(dictionary.containsKey(findStr)){
                    answer.add(dictionary.get(findStr));
                    for(int i=right+1; i<=msg.length();i++){
                        String addStr = msg.substring(left, i);
                        if(!dictionary.containsKey(addStr)){
                            dictionary.put(addStr,index++);
                            break;
                        }
                    }
                    left = right-1;
                    break;
                }
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}
