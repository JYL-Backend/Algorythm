package 연습문제;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 피로도 {
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        return calculate(k, dungeons, 0, visited, true);
    }
    public int calculate(int k, int[][] dungeons, int index, boolean[] visited, boolean never){
        // length 도달
        if(index== dungeons.length){
            // 방문 x 이력
            if(never) return 0;
            // 방문 o 이력
            return calculate(k, dungeons, 0, visited, true);
        }
        int noEnter = calculate(k, dungeons, index+1, visited, never);
        int yesEnter = -1;
        if(dungeons[index][0] <= k && !visited[index]){
            visited[index] = true;
            yesEnter = 1+calculate(k-dungeons[index][1], dungeons, index+1, visited, false);
            visited[index] = false;
        }
        return Math.max(noEnter, yesEnter);
    }
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
