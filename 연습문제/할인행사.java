package 연습문제;

public class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int notYetCount = want.length;
        int answer = 0;
        HashMap<String, Want> map = new HashMap<>();
        for(int i=0; i< want.length; i++){
            map.put(want[i], new Want(number[i]));
        }
        for(int i=0; i<10; i++){
            if(map.containsKey(discount[i])){
                Want nowWant =  map.get(discount[i]);
                nowWant.minus();
                if(nowWant.isSuccess == 1) notYetCount--;
            }
        }
        if(notYetCount==0) answer++;

        for(int i=0; i<discount.length; i++){
            if(map.containsKey(discount[i])){
                Want nowWant = map.get(discount[i]);
                nowWant.plus();
                if(nowWant.isSuccess == -1) notYetCount++;
            }

            int rightIndex = i+10;
            if(rightIndex < discount.length){
                if(map.containsKey(discount[rightIndex])) {
                    Want nowWant = map.get(discount[rightIndex]);
                    nowWant.minus();
                    if(nowWant.isSuccess == 1) notYetCount--;
                }
            }
            ;
            if(notYetCount==0) answer++;
        }
        return answer;
    }

    class Want {
        int want;
        int current;
        // 0 무, 1 만족 -1 불만족
        int  isSuccess = 0;
        public Want(int w){
            this.want = w;
            this.current = w;
        }

        public void minus(){
            this.current--;
            if(this.current == 0) this.isSuccess = 1;
            else this.isSuccess = 0;
        }
        public void plus(){
            this.current++;
            if(this.current == 1) this.isSuccess = -1;
            else this.isSuccess = 0;
            this.current = this.current > want ? want : this.current;
        }
    }
}
