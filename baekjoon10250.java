import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon10250 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int num = Integer.parseInt(br.readLine());

        for(int k=0;k<num;k++){

            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int H = arr[0];
            int W = arr[1];
            int N = arr[2];

            int numOfRoom=0;

            for(int i=1; i<=W;i++){

                if(H * i >= N) {
                    numOfRoom = i;
                    break;
                }

            }

            int floor = N - (numOfRoom-1)*H;

            System.out.printf("%d%02d\n",floor,numOfRoom);

        }

    }

}
