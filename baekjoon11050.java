import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon11050 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = num[0];
        int r = num[1];

        int sum = 1;

        for(int i=0;i<r;i++){
            sum*=n;
            n--;
        }

        for(int j=r; j>0;j--){

            sum/=j;

        }

        System.out.println(sum);


    }
}
