package 카카오.KAKAO_BLIND_RECRUITMENT.y2022;

import java.util.*;

public class 주차오금_계산 {
    static public String IN = "IN";
    static public String OUT = "OUT";
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Ca> map = new HashMap<>();
        PriorityQueue<Ca> pq = new PriorityQueue<>();

        for(String record : records){
            String[] split = record.split(" ");
            String time = split[0];
            String carNumber = split[1];
            String type = split[2];

            if(map.containsKey(carNumber)){
                map.get(carNumber).bbik(time, type);
                continue;
            }
            Ca ca = new Ca(carNumber);
            ca.bbik(time,type);
            map.put(carNumber, ca);
            pq.add(ca);
        }

        for(Map.Entry<String, Ca> entry : map.entrySet()) {
            entry.getValue().bbik("23:59", OUT);
        }

        List<Integer> answer = new ArrayList<>();
        while(!pq.isEmpty()) answer.add(pq.poll().calculateCost(fees));
        return answer.stream().mapToInt(i->i).toArray();
    }
    public class Ca implements Comparable<Ca>{
        String number;
        Integer inTime;
        int totalTime = 0;
        public Ca(String number){
            this.number = number;
        }
        @Override
        public int compareTo(Ca c){
            return this.number.compareTo(c.number);
        }

        public void bbik(String time, String type) {
            if(type.equals(IN)){
                inTime = convertTimeToInt(time);
                return;
            }
            if(inTime == null) return;
            totalTime += convertTimeToInt(time) - inTime;
            inTime = null;
        }

        public int convertTimeToInt(String time){
            String[] split = time.split(":");
            return Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);
        }

        public int calculateCost(int[] fees){
            int basicTime = fees[0];
            int basicCost = fees[1];
            int unitTime = fees[2];
            int unitCost = fees[3];

            if(totalTime <= basicTime) return basicCost;
            totalTime -= basicTime;
            return basicCost + (int)((Math.ceil((double)totalTime/(double)unitTime))*unitCost);
        }
    }

}
