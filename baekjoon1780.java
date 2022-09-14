import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon1780 {


    static int[][] arr;
    static int[] count;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        arr = new int[num][num];
        count = new int[3];


        for(int i=0;i<num;i++){

            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        }


        DFS(0, 0, arr.length);

        System.out.println(count[0]);
        System.out.println(count[1]);
        System.out.println(count[2]);


    }

    static void DFS(int y, int x, int length){


        boolean isComplete = true;

        int k= arr[y][x];

        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){

                if(k!=arr[y+i][x+j]){

                    isComplete = false;
                    break;
                }

            }

            if(!isComplete) break;

        }



        if(isComplete){

            if(k==-1) count[0]++;
            else if(k==0) count[1]++;
            else if(k==1) count[2]++;

        }else {

            if(length/3 > 0){

                for(int i=0;i<3;i++){

                    for(int j=0;j<3;j++){

                        DFS(y+(length/3)*i,x+(length/3)*j,length/3 );

                    }

                }

            }

        }


    }

}
