import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon7576 {

    static int[][] arr;


    public static int MAX = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = num[1];
        int M = num[0];

        arr = new int[N][M];


        StringTokenizer st;

        int count = 0;
        int targetCount = N * M;


        Queue<Vertex> queue = new LinkedList<>();

        for(int i=0;i<N;i++){

            st = new StringTokenizer(br.readLine());;

            for(int j=0;j<M;j++){

                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == -1) targetCount--;
                else if(arr[i][j] == 1){

                    queue.add(new Vertex(i, j,1));
                    count++;

                }
            }
        }

        if(targetCount == count){
            System.out.println(0);
            return;
        }


        while(!queue.isEmpty()){

            Vertex v = queue.peek();
            queue.poll();

            int y = v.y;
            int x = v.x;
            int days = v.days;

            if(0<=y-1 && arr[y-1][x] == 0){
                arr[y-1][x] = 1;
                queue.add(new Vertex(y-1,x,days+1));
                count++;
            }

            if(0<=x-1 && arr[y][x-1] == 0){
                arr[y][x-1] = 1;
                queue.add(new Vertex(y,x-1,days+1));
                count++;
            }

            if(y+1<N && arr[y+1][x] == 0){
                arr[y+1][x] = 1;
                queue.add(new Vertex(y+1,x,days+1));
                count++;

            }

            if(x+1<M && arr[y][x+1] == 0){
                arr[y][x+1] = 1;
                queue.add(new Vertex(y,x+1,days+1));
                count++;

            }

            if(count == targetCount){
                System.out.println(v.days);
                break;
            }



        }

        if(count != targetCount){
            System.out.println(-1);
        }
    }

    static class Vertex{

        int y=0;
        int x=0;
        int days=0;

        Vertex(int i, int j, int days){
            this.y = i;
            this.x = j;
            this.days = days;

        }

    }



}
