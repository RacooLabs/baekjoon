import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class baekjoon11724 {

    static Vertex[] vList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        vList= new Vertex[tmp[0]+1];

        for(int i=1; i<=tmp[0]; i++){
            vList[i] = new Vertex(i);
        }

        int caseNum = tmp[1];

        for(int i=0; i<caseNum; i++){

            int[] tmp2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            vList[tmp2[0]].list.add(tmp2[1]);
            vList[tmp2[1]].list.add(tmp2[0]);

        }

        int count = 0;

        for(int i=1; i<=tmp[0];i++){

            if(vList[i].visited == false){

                DFS(i);
                count++;

            }

        }

        System.out.println(count);




    }

    static void DFS(int num){

        vList[num].visited = true;

        for(int i=0; i<vList[num].list.size();i++){

            if(vList[vList[num].list.get(i)].visited == false){
                DFS(vList[num].list.get(i));
            }

        }

    }

    static class Vertex{
        int num;
        boolean visited = false;
        LinkedList<Integer> list = new LinkedList<>();

        Vertex(int num){
            this.num = num;
        }

    }

}
