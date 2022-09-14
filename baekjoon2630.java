import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon2630 {

    static int[][] arr;
    static int countWhite = 0;
    static int countBlue = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        arr = new int[num][];

        for(int i=0;i<num;i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        DFS(0,0,num);

        System.out.println(countWhite);
        System.out.println(countBlue);

    }

    static void DFS(int y, int x, int length){

        boolean isComplete = true;
        int tmp = arr[y][x];

        for(int i=y;i<y+length;i++){
            for( int j=x;j<x+length;j++){

                if(arr[i][j] != tmp){
                    isComplete = false;
                    break;
                }

            }
        }

        if(isComplete){
            if(tmp == 0){
                countWhite ++;
            }else{
                countBlue ++;
            }
        }else{
            length /= 2;

            if (length > 0) {
                for(int i=0;i<2;i++){
                    for(int j=0;j<2;j++){
                        DFS(y+i*length, x+j*length, length );
                    }
                }
            }

        }

    }

}
