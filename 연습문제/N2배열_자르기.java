package 연습문제;

public class N2배열_자르기 {
    public int[] solution(int n, long left, long right) {
        int length =(int)(right-left) + 1;
        int arr[] = new int[length];
        for(long i = left ; i <= right; i++){
            int index = (int)(i-left);
            int row = (int)(i/n)+1;
            int nam = (int)(i%n)+1;
            arr[index] =  row > nam ? row : nam;


        }
        return arr;
    }
}
