import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon1085 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int minX = Math.abs(num[0] - num[2]) > Math.abs(num[0] - 0) ? Math.abs(num[0] - 0) : Math.abs(num[0] - num[2]);
        int minY = Math.abs(num[1] - num[3]) > Math.abs(num[1] - 0) ? Math.abs(num[1] - 0) : Math.abs(num[1] - num[3]);

        int result = minX > minY ? minY : minX;

        System.out.println(result);






    }

}
