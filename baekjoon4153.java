import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class baekjoon4153 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean isEnd = false;

        while(!isEnd){

            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int maxIndex=0;
            int max = arr[0];
            for(int i=1;i<arr.length;i++){
                if(arr[i] > max){
                    maxIndex = i;
                    max = arr[i];
                }
            }

            ArrayList<Integer> arrEtc = new ArrayList<>();
            for(int i=0;i<3;i++){
                if(maxIndex != i){
                    arrEtc.add(arr[i]);
                }
            }

            int sum = arr[0] + arr[1] + arr[2];
            if(sum == 0){
                isEnd = true;
            }else{
                if(Math.pow(arrEtc.get(0),2) + Math.pow(arrEtc.get(1),2) == Math.pow(arr[maxIndex],2)) System.out.println("right");
                else System.out.println("wrong");
            }



        }

    }
}
