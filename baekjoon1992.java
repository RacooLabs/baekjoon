import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon1992 {

    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        arr= new int[num][];

        for(int i=0;i<num;i++){
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        DFS(0, 0, arr.length);

    }

    static void DFS(int y, int x, int length){


        boolean isComplete = true;
        int tmp = arr[y][x];
        for(int i=y;i<y+length; i++){
            for(int j=x;j<x+length;j++){
                if(tmp != arr[i][j]){
                    isComplete = false;
                }

            }
        }




        if(isComplete){
            System.out.print(tmp);
        }else {

            if(length>1) System.out.print("(");

            int tmpLength = length/2;

            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){

                    DFS(y+tmpLength*i, x+tmpLength*j, tmpLength);

                }
            }

            if(length>1) System.out.print(")");

        }


    }

}
