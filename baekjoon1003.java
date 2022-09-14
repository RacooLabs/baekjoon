import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baekjoon1003 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseNum = Integer.parseInt(br.readLine());

        for(int k=0;k<caseNum;k++){

            int N = Integer.parseInt(br.readLine());

            ArrayList<int[]> arr = new ArrayList<>();

            int arr1[] = {1,0};
            int arr2[] = {0,1};

            arr.add(arr1);
            arr.add(arr2);

            for(int i=2; i<=N;i++){
                int[] tmpArr = {arr.get(i-2)[0] + arr.get(i-1)[0], arr.get(i-2)[1] + arr.get(i-1)[1]};
                arr.add(tmpArr);
            }

            System.out.println(arr.get(N)[0] + " " +arr.get(N)[1]);

        }


    }

}
