import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class baekjoon1978 {

    public static void main(String args[])throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[1001];

        for(int i=0;i<arr.length;i++){
            arr[i] = i;
        }

        arr[0] = 0;
        arr[1] = 0;

        for(int i=2;i<=arr.length/2;i++){

            int j = 2;

            while(i * j <= 1000){

                arr[i*j] = 0;
                j++;

            }

        }


        int num = Integer.parseInt(br.readLine());
        int count = 0;
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i=0;i<num;i++){

            if(arr[nums[i]] != 0){
                count++;
            }

        }

        System.out.println(count);



    }

}
