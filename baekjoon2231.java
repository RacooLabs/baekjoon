import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2231 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int result = 0;
        int i;
        for(i=0;i<=num;i++){

            result = i + i/1000000;
            result = result + (i%1000000)/100000;
            result = result + (i%100000)/10000;
            result = result + (i%10000)/1000;
            result = result + (i%1000)/100;
            result = result + (i%100)/10;
            result = result + (i%10);

            if(result == num) break;

        }

        if(i>num){
            System.out.println(0);
        }else{
            System.out.println(i);
        }








    }

}
