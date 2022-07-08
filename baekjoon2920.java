import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon2920 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int result1 = 0;
        int result2 = 0;

        for(int i=0;i<arr.length;i++){

            if(i+1 != arr[i]){
                result1 = 0;
                break;
            }else{
                result1 = 1;
            }

        }


        for(int i=7;i>=0;i--){
            if(i+1 != arr[7-i]){
                result2 = 0;
                break;
            }else{

                result2 = 1;
            }

        }

        int result3 = 0;
        if (result1 == 0 && result2 == 0) result3 = 1;


        if(result1 == 1){
            System.out.println("ascending");
        }else if(result2 == 1){
            System.out.println("descending");
        }else if(result3 == 1){
            System.out.println("mixed");
        }

    }

}
