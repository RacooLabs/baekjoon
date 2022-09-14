import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon1463 {

    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());


        int[] d = new int[num+1];

        for(int i=2;i<=num;i++){

            d[i] = d[i-1] + 1;

            if (i % 2 == 0) {

                d[i] = d[i] > d[i/2] + 1? d[i/2] + 1 : d[i];
            }

            if (i % 3 == 0) {

                d[i] = d[i] > d[i/3] + 1? d[i/3] + 1 : d[i];
            }



        }

        System.out.println(d[num]);


    }


}
