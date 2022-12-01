package 카카오.KAKAO_BLIND_RECRUITMENT.y2018;

import java.util.PriorityQueue;

public class 방금그곡 {
    public String solution(String m, String[] musicinfos) {
        PriorityQueue<Mus> pq = new PriorityQueue<>();
        for (String musicInfo : musicinfos){
            Mus mus = new Mus(musicInfo);
            if(mus.isContains(m)) pq.offer(mus);
        }
        return pq.isEmpty() ? "(None)" : pq.peek().name;
    }
    class Mus implements Comparable<Mus>{
        int time;
        String name;
        String melody;
        public Mus(String info){
            String[] split = info.split(",");
            String[] startTime = split[0].split(":");
            String[] endTime = split[1].split(":");

            time = (Integer.parseInt(endTime[0]) - Integer.parseInt(startTime[0])) * 60
                    + (Integer.parseInt(endTime[1]) - Integer.parseInt(startTime[1]));

            name = split[2];
            String tmpMelody = split[3];
            tmpMelody = tmpMelody
                    .replaceAll("C#", "1")
                    .replaceAll("D#", "2")
                    .replaceAll("F#", "3")
                    .replaceAll("G#", "4")
                    .replaceAll("A#", "5");
            int tmpMelodyLength = tmpMelody.length();
            int tmpTime = time;
            StringBuilder sb = new StringBuilder();
            while(tmpTime != 0){
                if(tmpMelodyLength <= tmpTime){
                    sb.append(tmpMelody);
                    tmpTime -= tmpMelodyLength;
                    continue;
                }
                sb.append(tmpMelody.substring(0,tmpTime));
                break;
            }

            this.melody = sb.toString();
        }

        @Override
        public int compareTo(Mus m){
            if(m.time > this.time) return 1;
            if(m.time < this.time)  return -1;
            return 1;
        }

        public boolean isContains(String m) {
            m = m.replaceAll("C#", "1")
                    .replaceAll("D#", "2")
                    .replaceAll("F#", "3")
                    .replaceAll("G#", "4")
                    .replaceAll("A#", "5");
            return this.melody.contains(m);
        }
    }
}
