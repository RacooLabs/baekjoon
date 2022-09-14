import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon2869 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int up = num[0];
        int down = num[1];
        int target = num[2];

        int day = (int)Math.ceil((double)(target-up)/(up-down));
        System.out.println(day+1);

    }


}
