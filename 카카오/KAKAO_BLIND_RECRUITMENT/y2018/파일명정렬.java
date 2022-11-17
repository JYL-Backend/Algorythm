package 카카오.KAKAO_BLIND_RECRUITMENT.y2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class 파일명정렬 {

    public String[] solution(String[] files) {
        PriorityQueue<File> pq = new PriorityQueue<>();
        int count = 0;
        for(String file : files) pq.add(new File(file, count++));

        List<String> answer = new ArrayList<>();
        while(!pq.isEmpty()) answer.add(pq.poll().name);
        return answer.stream().toArray(String[]::new);
    }
    class File implements Comparable<File>{
        String name;
        String head;
        int number;
        int seq;
        public File(String fileName, int count){
            this.name = fileName;
            this.seq = count;
            int numberStartIndex = -1;
            int numberEndIndex = -1;
            for(int i=0; i<fileName.length(); i++){
                char c = fileName.charAt(i);
                if(48 <= c && c <= 57){
                    numberStartIndex = i;
                    for(int j=i; j<fileName.length(); j++){
                        char c2 = fileName.charAt(j);
                        if(c2 < 48 || 57 < c2){
                            numberEndIndex = j;
                            break;
                        }
                    }
                    if(numberEndIndex == -1) numberEndIndex = fileName.length();
                    break;
                }
            }
            head = fileName.substring(0,numberStartIndex).toLowerCase();
            number = Integer.parseInt(fileName.substring(numberStartIndex, numberEndIndex));
        }

        @Override
        public int compareTo(File f){
            int headCompare = this.head.compareTo(f.head);
            if(headCompare != 0) return headCompare;
            if(this.number < f.number) return -1;
            if(this.number > f.number) return 1;
            return this.seq < f.seq ? -1 : 1;
        }
    }
}
