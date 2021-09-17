import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon18111 {

    public static void main(String args[]) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nmb = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = nmb[0];
        int m = nmb[1];
        int b = nmb[2];

        int[][] array = new int[n][m];

        for(int i = 0; i<n; i++){

            array[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        }

        int sum = 0;

        for(int i=0;i<n;i++){

            for(int j = 0;j<m;j++){

                sum += array[i][j];

            }

        }

        sum += b;

        int maxAvg = sum/(n*m);

        int timeMin = 99999999;
        int height = 0;

        while(maxAvg >= 0){

            int time = 0;

            for(int i=0;i<n;i++){

                for(int j = 0;j<m;j++){

                    if(maxAvg < array[i][j]) time +=  (array[i][j] - maxAvg) * 2;
                    else if (maxAvg > array[i][j]) time +=  maxAvg - array[i][j];
                    else { }

                }

            }

            if(timeMin > time){

                timeMin = time;
                height = maxAvg;

            }else if (timeMin == time){

                timeMin = time;

                if(height < maxAvg){
                    height = maxAvg;
                }

            }

            maxAvg--;

        }

        System.out.println(timeMin + " " + height);

    }
}
