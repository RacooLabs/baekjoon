import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class baekjoon1697 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n1 = num[0]; // 내 위치
        int n2 = num[1]; //동생 위치
        boolean[] visited = new boolean[100001];


        ArrayList<Vertex> arr = new ArrayList<Vertex>();

        int time = 0;

        arr.add(new Vertex(n1, time));

        while (!arr.isEmpty()){

            Vertex vertex = arr.get(0);
            arr.remove(0);
            time = vertex.time;

            if(n2-vertex.now == 0) break;

            visited[vertex.now] = true;

            if(vertex.now*2 < visited.length && !visited[vertex.now*2])
            {
                arr.add(new Vertex(vertex.now*2, time+1));
            }


            if(vertex.now-1 >= 0 &&!visited[vertex.now-1]){
                arr.add(new Vertex(vertex.now-1, time+1));
            }


            if(vertex.now+1 < visited.length &&!visited[vertex.now+1]){
                arr.add(new Vertex(vertex.now+1, time+1));
            }



        }

        System.out.println(time);

    }

    static class Vertex{

        int now = 0;
        int time = 0;

        Vertex(int now, int time){
            this.now = now;
            this.time = time;
        }


    }

}
