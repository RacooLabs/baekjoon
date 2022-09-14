import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class baekjoon1260 {

    static ArrayList<Vertex> graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int numOfVertex = num[0];
        int numOfEdge = num[1];
        int startNum = num[2];

        graph = new ArrayList<Vertex>();


        for(int i=0;i<=numOfVertex;i++){
            graph.add(new Vertex(i));
        }

        for(int j=0;j<numOfEdge;j++){
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int v1 = tmp[0];
            int v2 = tmp[1];

            graph.get(v1).link.add(v2);
            graph.get(v2).link.add(v1);

        }

        for(int j=1;j<=numOfVertex;j++){
            Collections.sort(graph.get(j).link);
        }

        DFS(startNum);
        System.out.println();

        ArrayList<Vertex> queue = new ArrayList<Vertex>();

        queue.add(graph.get(startNum));

        while(!queue.isEmpty()){

            Vertex tmpV = queue.get(0);
            queue.remove(0);


            if(tmpV.isVisitedBFS == false){
                System.out.print(tmpV.num+" ");
            }

            tmpV.isVisitedBFS = true;

            for(int i=0;i<tmpV.link.size();i++){
                if(graph.get(tmpV.link.get(i)).isVisitedBFS == false)
                    queue.add(graph.get(tmpV.link.get(i)));

            }

        }

    }

    static class Vertex{

        int num;
        boolean isVisitedDFS = false;
        boolean isVisitedBFS = false;
        ArrayList<Integer> link = new ArrayList<>();

        Vertex(int num){
            this.num = num;
        }

    }

    static void DFS(int k){

        System.out.print(k+" ");
        graph.get(k).isVisitedDFS = true;

        for(int i=0;i<graph.get(k).link.size();i++){

            if(!graph.get(graph.get(k).link.get(i)).isVisitedDFS){
                DFS(graph.get(k).link.get(i));
            }

        }
    }
}
