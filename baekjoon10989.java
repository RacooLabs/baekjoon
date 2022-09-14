import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon10989 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long num = Long.parseLong(br.readLine());

        int[] arr = new int[10001];

        for(long i=0;i<num;i++){

            int tmp = Integer.parseInt(br.readLine());
            arr[tmp]++;

        }

        StringBuffer sb = new StringBuffer();

        for(int i=1;i<=10000;i++){

            for(int k=1;k<=arr[i];k++){
                sb.append(i + "\n");
            }


        }

        System.out.println(sb);

    }


}
