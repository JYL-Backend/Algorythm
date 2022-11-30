package 연습문제;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 귤고르기 {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Gyul> map = new HashMap<>();
        PriorityQueue<Gyul> pq = new PriorityQueue<>();
        for (int g : tangerine) {
            if (map.containsKey(g)) {
                map.get(g).plus();
            }
            else {
                map.put(g, new Gyul());
            }
        }
        for(Map.Entry<Integer,Gyul> entry : map.entrySet()){
            pq.offer(entry.getValue());
        }

        int result = 0;
        while (k > 0) {
            result++;
            Gyul g = pq.poll();
            k -= g.getAmount();
        }

        return result;
    }

    class Gyul implements Comparable<Gyul> {
        private int amount;

        @Override
        public int compareTo(Gyul g) {
            return this.amount < g.amount ? 1 : -1;
        }

        public Gyul() {
            this.amount = 1;
        }

        public void plus() {
            this.amount++;
        }

        public int getAmount() {
            return this.amount;
        }
    }
}
