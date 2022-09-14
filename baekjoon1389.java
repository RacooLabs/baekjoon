import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class baekjoon1389 {

    static ArrayList<Vertex> graph;
    static int min = 5000;
    static int countSum = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int usersNum = num[0];
        int linkNum = num[1];

        graph = new ArrayList<Vertex>();

        for(int i=0;i<=usersNum; i++){
            graph.add(new Vertex(i));
        }

        for(int i=0;i<linkNum;i++){
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(tmp[0]).link.add(tmp[1]);
            graph.get(tmp[1]).link.add(tmp[0]);

        }

        ArrayList<Vertex> queue = new ArrayList<Vertex>();

        int min = 10000;
        int minNum =0;

        for(int i=1;i<=usersNum;i++){

            for(int j=1;j<=usersNum;j++){
                graph.get(j).isVisited = false;
                graph.get(j).distance = 100;
            }

            queue.clear();
            queue.add(graph.get(i));
            graph.get(i).distance = 0;


            while(!queue.isEmpty()){

                Vertex tmp = queue.get(0);
                queue.remove(0);

                tmp.isVisited = true;

                for(int k=0;k<tmp.link.size();k++){

                    if(!graph.get(tmp.link.get(k)).isVisited){
                        queue.add(graph.get(tmp.link.get(k)));

                        if(graph.get(tmp.link.get(k)).distance > tmp.distance + 1){
                            graph.get(tmp.link.get(k)).distance = tmp.distance + 1;
                        }

                    }

                }


            }

            int sum = 0;

            for(int k=1;k<=usersNum;k++){
                sum += graph.get(k).distance;
            }

            if(min > sum){
                min = sum;
                minNum = i;
            }



        }

        System.out.println(minNum);

    }


    static class Vertex{

        int num;
        boolean isVisited = false;
        int distance = 100;
        ArrayList<Integer> link = new ArrayList<Integer>();

        Vertex(int num){
            this.num = num;
        }

    }

}
