import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon2805 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long numArr1[] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long numOfWood = numArr1[0];
        long neededWood = numArr1[1];

        long tree[] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        Arrays.sort(tree);

        long maxLength = tree[tree.length-1];

        long l = 0;
        long r = maxLength;

        long mid = 0;

        while(l<r){

            long sum = 0;

            mid = (l + r)/2;

            for(int j=0;j<numOfWood;j++){
                sum += tree[j] > mid ? tree[j]-mid : 0;
            }

            if (sum > neededWood){
                l = mid+1;
            }else  {
                r = mid;
            }

        }

        System.out.println(r);

    }
}
