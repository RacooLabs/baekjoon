import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class baekjoon2606 {

    static ArrayList<Vertex> arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int pcNum = Integer.parseInt(br.readLine());
        int linkNum = Integer.parseInt(br.readLine());

        arr = new ArrayList<Vertex>();

        for(int i=0; i<=pcNum;i++){

            arr.add(new Vertex(i));

        }

        for(int i=0;i<linkNum; i++){

            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            arr.get(tmp[0]).links.add(tmp[1]);
            arr.get(tmp[1]).links.add(tmp[0]);

        }

        DFS(arr.get(1));

        System.out.println(count-1);



    }

    static class Vertex{

        int num;
        boolean isVisited = false;
        ArrayList<Integer> links = new ArrayList<>();

        Vertex(int num){
            this.num = num;
        }

    }

    static void DFS(Vertex v){

        v.isVisited = true;
        count++;

        for(int i=0;i<v.links.size();i++){

            int tmp = v.links.get(i);

            if(arr.get(tmp).isVisited == false){
                DFS(arr.get(tmp));
            }

        }

    }

}
