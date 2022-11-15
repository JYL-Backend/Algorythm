package 카카오.KAKAO_BLIND_RECRUITMENT.y2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 뉴스_클러스터링 {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        HashMap<String, Integer> map11 = new HashMap();
        HashMap<String, Integer> map12 = new HashMap();
        HashMap<String, Integer> map21 = new HashMap();
        HashMap<String, Integer> map22 = new HashMap();

        for(int i=0; i< str1.length()-1; i++){
            String str = str1.substring(i,i+2);
            if(str.charAt(0) < 97 || 122 < str.charAt(0)) continue;
            if(str.charAt(1) < 97 || 122 < str.charAt(1)) continue;
            if(map11.containsKey(str)){
                map11.put(str, map11.get(str)+1);
                map12.put(str, map12.get(str)+1);
                continue;
            }
            map11.put(str, 1);
            map12.put(str, 1);
        }

        for(int i=0; i< str2.length()-1; i++){
            String str = str2.substring(i,i+2);
            if(str.charAt(0) < 97 || 122 < str.charAt(0)) continue;
            if(str.charAt(1) < 97 || 122 < str.charAt(1)) continue;
            if(map21.containsKey(str)){
                map21.put(str, map21.get(str)+1);
                map22.put(str, map22.get(str)+1);
                continue;
            }
            map21.put(str, 1);
            map22.put(str, 1);
        }
        // 교집합
        int gyo = 0;
        for(Map.Entry<String,Integer> entry : map11.entrySet()){
            String key = entry.getKey();
            while(map11.get(key) > 0 && map21.containsKey(key) && map21.get(key) > 0){
                gyo++;
                map11.put(key, map11.get(key)-1);
                map21.put(key, map21.get(key)-1);
            }
        }
        // 합
        int hap = 0;
        List<String> removeList = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : map12.entrySet()){
            String str = entry.getKey();
            int count = entry.getValue();
            int count2 = 0;
            if(map22.containsKey(str)){
                count2 = map22.get(str);
            }
            hap += count > count2 ? count : count2;
            removeList.add(str);
        }
        for(String removeStr : removeList){
            map12.remove(removeStr);
            map22.remove(removeStr);
        }
        for(Map.Entry<String,Integer> entry : map22.entrySet()){
            String str = entry.getKey();
            int count = entry.getValue();
            int count2 = 0;
            if(map12.containsKey(str)){
                count2 = map12.get(str);
            }
            hap += count > count2 ? count : count2;
        }
        if(gyo == 0 && hap==0) return 65536;
        int answer = (int)(((double)gyo/hap)*65536);
        return answer;
    }
}
