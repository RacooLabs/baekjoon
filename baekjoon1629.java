import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class baekjoon1629 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long a = num[0];
        long b = num[1];
        long c = num[2];

        ArrayList<Long> arr = new ArrayList<Long>();

        arr.add(a%c);

        for(int i=1;i<=64;i++){
            arr.add(((arr.get(i-1)%c)*(arr.get(i-1)%c))%c);
        }

        long n=b;
        String str = "";
        while(n>0){

            if(n%2 == 1){
                str = "1" + str;
            }else{
                str = "0" + str;
            }

            n/=2;

        }

        long sum=1;
        char[] charArr = str.toCharArray();
        for(int i=1;i<=charArr.length;i++){
            if(charArr[charArr.length-i] == '1'){
                sum *= arr.get(i-1)%c;
                sum %= c;
            }
        }


        System.out.println(sum%c);


    }

}
