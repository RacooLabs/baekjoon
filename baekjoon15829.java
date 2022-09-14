import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon15829 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());

        String str = br.readLine();

        char[] arr = str.toCharArray();

        long sum = 0;

        long mod = 1234567891;

        long pow = 1;

        for(int i=0;i<arr.length;i++){

            sum+=(str.charAt(i) - 'a'+1) * pow;
            pow = (pow*31)%mod;

        }

        System.out.println(sum%mod);

    }

}
