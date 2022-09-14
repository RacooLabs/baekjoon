import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon7569 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int M = num[0]; // 가로칸
        int N = num[1]; // 세로칸
        int H = num[2]; // 높이

        int box[][][] = new int[H][N][M];
        boolean visited[][][] = new boolean[H][N][M];
        int days[][][] = new int[H][N][M];


        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                box[i][j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        }

        int totalTomato = H*N*M;

        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){

                    if(box[i][j][k] == -1) totalTomato--;
                }
            }
        }


        Queue<Vector> queue = new LinkedList<>();


        int count = 0;

        for(int i=0;i<H;i++){

            for(int j=0;j<N;j++){

                for(int k=0;k<M;k++){

                    if(box[i][j][k] == 1 && visited[i][j][k] == false){

                        visited[i][j][k] = true;
                        count++;

                        if(0<=i-1 && box[i-1][j][k] == 0){


                            visited[i-1][j][k] = true;
                            box[i-1][j][k] = 1;
                            queue.add(new Vector(i-1, j, k, 1));

                        }

                        if(i+1 < H && box[i+1][j][k] == 0){

                            visited[i+1][j][k] = true;
                            box[i+1][j][k] = 1;
                            queue.add(new Vector(i+1, j, k, 1));

                        }

                        if(0<=j-1 && box[i][j-1][k] == 0){

                            visited[i][j-1][k] = true;
                            box[i][j-1][k] = 1;
                            queue.add(new Vector(i, j-1, k, 1));

                        }

                        if(j+1 < N && box[i][j+1][k] == 0){

                            visited[i][j+1][k] = true;
                            box[i][j+1][k] = 1;
                            queue.add(new Vector(i, j+1, k, 1));

                        }

                        if(0<=k-1 && box[i][j][k-1] == 0){

                            visited[i][j][k-1] = true;
                            box[i][j][k-1] = 1;
                            queue.add(new Vector(i, j, k-1, 1));

                        }

                        if(k+1<M && box[i][j][k+1] == 0){

                            visited[i][j][k+1] = true;
                            box[i][j][k+1] = 1;
                            queue.add(new Vector(i, j, k+1, 1));

                        }

                    }

                }

            }


        }
        int day = 0;

        while(!queue.isEmpty()){

            Vector v = queue.remove();
            int i = v.z;
            int j = v.y;
            int k = v.x;
            day = v.days;

            count++;

            if(count == totalTomato) break;

            if(0<=i-1 && box[i-1][j][k] == 0){

                visited[i-1][j][k] = true;
                box[i-1][j][k] = 1;
                queue.add(new Vector(i-1, j, k, day+1));

            }

            if(i+1 < H && box[i+1][j][k] == 0){

                visited[i+1][j][k] = true;
                box[i+1][j][k] = 1;
                queue.add(new Vector(i+1, j, k, day+1));

            }

            if(0<=j-1 && box[i][j-1][k] == 0){

                visited[i][j-1][k] = true;
                box[i][j-1][k] = 1;
                queue.add(new Vector(i, j-1, k, day+1));

            }

            if(j+1 < N && box[i][j+1][k] == 0){

                visited[i][j+1][k] = true;
                box[i][j+1][k] = 1;
                queue.add(new Vector(i, j+1, k, day+1));

            }

            if(0<=k-1 && box[i][j][k-1] == 0){

                visited[i][j][k-1] = true;
                box[i][j][k-1] = 1;
                queue.add(new Vector(i, j, k-1, day+1));

            }

            if(k+1<M && box[i][j][k+1] == 0){

                visited[i][j][k+1] = true;
                box[i][j][k+1] = 1;
                queue.add(new Vector(i, j, k+1, day+1));

            }



        }

        if(totalTomato != count) System.out.println(-1);
        else System.out.println(day);



        /*for(int i=0;i<H;i++){

            for(int j=0;j<N;j++){

                for(int k=0;k<M;k++){

                    System.out.print(box[i][j][k] + " ");

                }

                System.out.println();

            }

            System.out.println();
        }*/

    }

    static class Vector{

        int y, x, z;
        int days = 0;

        public Vector(int z, int y, int x, int days) {
            this.z = z;
            this.y = y;
            this.x = x;
            this.days = days;


        }

    }

}
