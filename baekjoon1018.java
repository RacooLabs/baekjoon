import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon1018 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = arr[0]; //H i k
        int M = arr[1]; //W j s

        String[][] chessPanel = new String[N][M];

        // input
        for(int k=0;k<N;k++){

            chessPanel[k] = br.readLine().split("");

        }


        int min = 2500;

        for(int i=0;i<N-7;i++){

            for(int j=0;j<M-7;j++){

                int sum =0;
                int sum1 =0;
                int sum2 =0;

                for(int k=i;k<i+8;k++){

                    for(int s=j;s<j+8;s++){

                        //case1
                        if((k-i)%2==0){

                            if((s-j)%2==0){
                                if(!chessPanel[k][s].equals("W")) sum1++;

                            }else if((s-j)%2!=0){
                                if(!chessPanel[k][s].equals("B")) sum1++;
                            }


                        }else if((k-i)%2==1){

                            if((s-j)%2==0){
                                if(!chessPanel[k][s].equals("B")) sum1++;


                            }else if((s-j)%2!=0){
                                if(!chessPanel[k][s].equals("W")) sum1++;
                            }

                        }

                        //case2
                        if((k-i)%2==0){

                            if((s-j)%2==0){
                                if(!chessPanel[k][s].equals("B")) sum2++;

                            }else if((s-j)%2!=0){
                                if(!chessPanel[k][s].equals("W")) sum2++;
                            }


                        }else if((k-i)%2==1){

                            if((s-j)%2==0){

                                if(!chessPanel[k][s].equals("W")) sum2++;

                            }else if((s-j)%2!=0){
                                if(!chessPanel[k][s].equals("B")) sum2++;
                            }

                        }

                    }

                }

                sum = sum1>sum2 ? sum2 : sum1;

                if(sum < min) min = sum;

            }

        }

        System.out.println(min);

    }

}
