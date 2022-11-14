package 카카오.카카오_개발자_겨울_인턴십_2019;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 튜플 {
    public int[] solution(String s) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        s = s.replace("{{", "");
        s = s.replace("}}", "");
        String[] splits = s.split("},\\{");
        for(String split : splits) pq.add(new Tuple(split));

        List<Integer> answer = new ArrayList<>();

        while(!pq.isEmpty()){
            Tuple tuple = pq.poll();
            tuple.add(answer, map);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    class Tuple implements Comparable<Tuple>{
        List<Integer> list;
        public Tuple(String s){
            list = new ArrayList<>();
            String[] split = s.split(",");
            for(String peace : split) list.add(Integer.parseInt(peace));
        }
        @Override
        public int compareTo(Tuple t){
            return t.list.size() > this.list.size() ? -1 : 1;
        }
        public void add(List<Integer> answer, HashMap<Integer,Boolean> map){
            for(Integer i : list) {
                if(map.containsKey(i)) continue;
                map.put(i,true);
                answer.add(i);
            }
        }
    }
}
