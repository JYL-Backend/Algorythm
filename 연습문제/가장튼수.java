package 연습문제;

import java.util.PriorityQueue;

public class 가장튼수 {
    public String solution(int[] numbers) {
        PriorityQueue<Num> pq = new PriorityQueue<>();

        for(int num : numbers) pq.offer(new Num(num));

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Num next = pq.poll();
            sb.append(next.number);
        }

        while(sb.length() != 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);

        return sb.toString();
    }

    class Num implements Comparable<Num>{
        String number;

        public Num(int n){
            this.number = String.valueOf(n);
        }

        @Override
        public int compareTo(Num n){
            return compare(this.number, n.number);
        }
        public int compare(String a, String b){
            if(a.equals("")) return 1;
            if(b.equals("")) return -1;
            for(int i=0; i<6; i++){
                if(a.length() == i) return compare(a, b.substring(i));
                if(b.length() == i) return compare(a.substring(i), b);


                int thisNumber = Character.getNumericValue(a.charAt(i));
                int nextNumber = Character.getNumericValue(b.charAt(i));
                if(thisNumber == nextNumber) continue;
                return thisNumber < nextNumber ? 1 : -1;
            }
            return 0;
        }

    }
}
