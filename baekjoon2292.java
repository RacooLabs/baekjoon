import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2292 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Integer.parseInt(br.readLine());

        long count = 0;

        num--;
        count++;

        while(num > 0){
            num -= count*6;
            count++;
        }

        System.out.println(count);

    }

}
