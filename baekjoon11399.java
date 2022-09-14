import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class baekjoon11399 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        LinkedList<Integer> list = new LinkedList<>();

        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }

        Collections.sort(list);

        int sum = 0;
        for(int i=0;i<list.size();i++){
            for(int j=0; j<i+1;j++){
                sum+=list.get(j);
            }
        }

        System.out.println(sum);

    }

}
