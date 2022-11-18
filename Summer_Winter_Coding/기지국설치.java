package Summer_Winter_Coding;

import java.util.Arrays;

public class 기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int[] newStations = Arrays.copyOf(stations, stations.length + 1);
        newStations[newStations.length-1] = n + w + 1;
        int lastIndex = 0;
        int count = 0;
        for(int station : newStations){
            int spaceLength = station-w-lastIndex-1;
            lastIndex = station + w;
            if(spaceLength <= 0) continue;
            int ww = w*2+1;
            count += spaceLength % ww == 0 ? spaceLength / ww : spaceLength / ww + 1;
        }
        return count;
    }
}
