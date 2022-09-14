import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon1012 {

    static int row;
    static int col;
    static Group[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseNum = Integer.parseInt(br.readLine());

        for(int s=0; s<testCaseNum; s++){

            int[] tmpArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            row = tmpArr[0];
            col = tmpArr[1];
            int plantNum = tmpArr[2];


            arr = new Group[row][col];

            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){

                    arr[i][j] = new Group(false);

                }

            }

            for(int i=0;i<plantNum;i++){

                int[] tmpPoint = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int x = tmpPoint[0];
                int y = tmpPoint[1];
                arr[x][y].isPlanted = true;

            }

            int groupCount = 0;


            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){

                    if(arr[i][j].isPlanted == true && arr[i][j].isVisited == false){
                        dfs(i,j);
                        groupCount++;
                    }

                }
            }


            System.out.println(groupCount);



        }



    }

    static void dfs(int r, int k){

        int[] y = {-1, 0, 0, 1};
        int[] x = {0, 1, -1, 0};

        arr[r][k].isVisited = true;

        for(int i=0;i<4;i++){

            int ddy = y[i];
            int ddx = x[i];

            if((0<=(r + ddy)&&(r + ddy)<row) && (0<=(k + ddx)&&(k + ddx)<col) && arr[r + ddy][k + ddx].isVisited == false && arr[r + ddy][k + ddx].isPlanted)
            {
                dfs(r + ddy, k + ddx);
            }

        }

    }

    static class Group{

        boolean isVisited = false;
        boolean isPlanted = false;

        Group(boolean isPlanted){
            this.isPlanted = isPlanted;
        }
    }

}
