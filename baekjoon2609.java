import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon2609 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max = arr[0] > arr[1] ? arr[0] : arr[1];
        int num1 = arr[0];
        int num2 = arr[1];

        int a = 0; // 최대 공약수
        int b = 0; // 최소 공배수
        for(int i=1;i<=max;i++){
            if(num1 % i == 0 && num2 % i == 0){
                a = i;
            }
        }

        for(int j=1;j<=num1*num2;j++){
            if(j>=num1 && j>= num2 && j % num1 == 0 && j % num2 == 0){
                b = j;
                break;
            }
        }

        System.out.println(a);
        System.out.println(b);



    }

}
