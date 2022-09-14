import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon1676 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int twoCount = 0;
        int fiveCount = 0;

        for(int i=1;i<=num;i++){
            int c = i;

            while(c>0){
                if(c%2==0){
                    c/=2;
                    twoCount++;
                }else{
                    break;
                }
            }

            c = i;

            while(c>0){
                if(c%5==0){
                    c/=5;
                    fiveCount++;
                }else{
                    break;
                }
            }

        }

        System.out.println(twoCount > fiveCount ? fiveCount : twoCount);

    }

}
