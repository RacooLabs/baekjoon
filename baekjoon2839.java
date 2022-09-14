import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2839 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int fiveCount = (int)Math.ceil((double)num/5);



        while(fiveCount >= 0){

            if(num % 5 == 0){
                break;
            }

            //5로 나눈 값을 최대로
            int tmp = num - 5*(fiveCount-1);
            int n = tmp;

            int sum = 0;

            while(n >0){
                sum += n%10;
                n /= 10;
            }

            fiveCount--;

            if(sum % 3 == 0){
                break;
            }

        }

        if(fiveCount <0){
            System.out.println(-1);
        }else{
            System.out.println((fiveCount)+((num-5*(fiveCount))/3));
        }


    }

}
