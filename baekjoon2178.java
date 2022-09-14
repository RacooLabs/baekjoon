import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class baekjoon2178 {

    static int[][] arr;
    static  boolean[][] visited;
    static int finalY;
    static int finalX;
    static int min = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        finalY = num[0];
        finalX = num[1];

        min = finalX * finalY;

        arr = new int[finalY][];
        visited = new boolean[finalY][finalX];

        for(int i=0;i<finalY;i++){
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        ArrayList<Vertex> queue = new ArrayList<Vertex>();

        queue.add(new Vertex(0,0));


        while(!queue.isEmpty()){

            Vertex v = queue.get(0);
            queue.remove(0);

            if(v.y == finalY-1 && v.x==finalX-1){
                System.out.println(v.distance+1);
            }

            if(0<=v.y-1 && arr[v.y-1][v.x] == 1 && !visited[v.y-1][v.x]){

                Vertex t = new Vertex(v.y-1, v.x);
                t.distance = v.distance+1;
                queue.add(t);
                visited[v.y-1][v.x] = true;

            }

            if(0<=v.x-1 && arr[v.y][v.x-1] == 1 && !visited[v.y][v.x-1]){

                Vertex t = new Vertex(v.y, v.x-1);
                t.distance = v.distance+1;
                queue.add(t);
                visited[v.y][v.x-1] = true;

            }

            if(v.y+1<finalY && arr[v.y+1][v.x] == 1 && !visited[v.y+1][v.x]){

                Vertex t = new Vertex(v.y+1, v.x);
                t.distance = v.distance+1;
                queue.add(t);
                visited[v.y+1][v.x] = true;

            }

            if(v.x+1<finalX && arr[v.y][v.x+1] == 1 && !visited[v.y][v.x+1]){

                Vertex t = new Vertex(v.y, v.x+1);
                t.distance = v.distance+1;
                queue.add(t);
                visited[v.y][v.x+1] = true;

            }


        }







    }

    static class Vertex{
        int y;
        int x;
        int distance = 0;

        public Vertex(int y, int x){
            this.y = y;
            this.x = x;
        }
    }





}
