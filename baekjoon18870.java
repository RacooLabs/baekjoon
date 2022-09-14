import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon18870 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        HashMap<Integer, Integer> arrHash = new HashMap<>();

        for(int i=0;i<arr.length;i++){

            if(arrHash.get(arr[i]) == null){
                arrHash.put(arr[i],1);
            }

        }

        Object[] mapkey = arrHash.keySet().toArray();
        Arrays.sort(mapkey);

        arrHash.clear();

        for(int i=0; i<mapkey.length;i++){
            arrHash.put((int)mapkey[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<num;i++){
            sb.append(arrHash.get(arr[i])  + " ");
        }

        System.out.println(sb);

    }

}
