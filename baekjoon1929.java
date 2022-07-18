import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class baekjoon1929 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int M = num[0];
        int N = num[1];

        boolean data[] = new boolean[N+1];

        for(int i=0;i<=N;i++){
            data[i] = true;
        }

        for(int i=2; i<=N;i++){

            int j=2;

            while(j*i <= N){

                data[j*i] = false;
                j++;
            }

        }

        for(int i=M;i<=N;i++){

            if(i<=1) i = 2;

            if(data[i]){
                System.out.println(i);
            }
        }




    }

}
