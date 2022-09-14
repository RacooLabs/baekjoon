import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class baekjoon2667{

    static boolean visited[][];
    static int count;
    static int arr[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        arr = new int[num][];
        visited = new boolean[num][num];

        for(int i=0;i<num;i++){
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        LinkedList<Integer> countArr = new LinkedList<>();

        count = 0;
        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                if(visited[i][j] == false && arr[i][j] == 1){
                    count++;
                    DFS(i, j);
                    countArr.add(count);
                    count = 0;
                }
            }
        }

        Collections.sort(countArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2) return -1;
                else if(o1 > o2) return 1;
                else return 0;
            }
        });

        System.out.println(countArr.size());

        for(int k=0;k<countArr.size();k++){
            System.out.println(countArr.get(k));
        }

    }

    public static void DFS(int i, int j){

        int y[] = {-1,0,0,1};
        int x[] = {0,1,-1,0};

        visited[i][j] = true;

        for(int k=0; k<4;k++){

            int yPoint = y[k];
            int xPoint = x[k];

            if(!(0 <= i + yPoint && i + yPoint < visited.length
            && 0 <=  j + xPoint && j + xPoint < visited.length)) continue;

            if(visited[i + yPoint][j + xPoint] == false && arr[i+ yPoint][j+ xPoint] == 1){
                count++;
                DFS(i + yPoint, j + xPoint);

            }

        }

    }

}

