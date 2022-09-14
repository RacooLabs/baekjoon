import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2579 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[] stairs = new int[num+1];
        int[] dp = new int[num+1];

        for(int i=1;i<=num;i++){

            stairs[i] = Integer.parseInt(br.readLine());

        }

        if(num == 1){
            System.out.println(stairs[1]);
        }else if(num == 2){
            System.out.println(stairs[1] + stairs[2]);
        }else{

            dp[1] = stairs[1];
            dp[2] = stairs[1] + stairs[2];
            dp[3] = stairs[1] + stairs[3];

            for(int i=3;i<=num;i++){

                dp[i] = Math.max(stairs[i] + stairs[i - 1] + dp[i - 3], stairs[i] + dp[i - 2]);

            }

            System.out.println(dp[num]);

        }

    }

}
