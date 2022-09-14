import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class baekjoon1764 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int listen = num[0];
        int watch = num[1];

        HashMap<String, Integer> h = new HashMap<>();

        for(int i=0;i<listen;i++){
            h.put(br.readLine(), 1);
        }

        int count=0;

        StringBuilder sb = new StringBuilder();
        ArrayList<String> arr = new ArrayList<>();

        for(int i=0;i<watch;i++){

            String str = br.readLine();

            if(h.get(str) != null){
                arr.add(str);
                count++;
            };

        }

        System.out.println(count);

        Collections.sort(arr);

        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }

    }

}
