import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon1654 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int numOfLans = num[0];
        int maxNum = num[1];

        long[] lans = new long[numOfLans];

        for(int i=0;i<lans.length;i++){

            lans[i] = Long.parseLong(br.readLine());

        }

        long min = 1;
        long max = lans[0];

        //최대값 설정.
        for(int i=1;i<lans.length;i++){
            if(lans[i]>max) max = lans[i];
        }

        max++;

        while(min<max){

            long mid = (min + max) / 2;
            long sum = 0;


            for(int i=0;i<lans.length;i++){
                sum += (lans[i]/mid);
            }


            if(sum >= maxNum){

                min = mid + 1;

            }else{

                max = mid;

            }

        }

        System.out.println(max-1);

    }

}
