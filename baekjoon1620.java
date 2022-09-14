import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon1620 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        HashMap<String, Integer> m = new HashMap<>();



        int dicNum = num[0];
        int solveNum = num[1];

        String[] str = new String[dicNum+1];

        for(int i=1;i<=dicNum;i++){
            str[i] = br.readLine();
            m.put(str[i] , i);
        }

        for(int i=1;i<=solveNum;i++){

            String tmp = br.readLine();

            if(tmp.charAt(0) >= '0' && tmp.charAt(0)<= '9'){

                System.out.println(str[Integer.parseInt(tmp)]);

            }else{

                System.out.println(m.get(tmp));

            }

        }

    }




}
