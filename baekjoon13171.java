import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baekjoon13171 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long a = Long.parseLong(br.readLine());
        long x = Long.parseLong(br.readLine());

        long modNum = 1000000007;

        ArrayList<Long> arr = new ArrayList<Long>();
        arr.add(a%modNum);

        for(int i=1;i<64;i++){
            arr.add((arr.get(i-1))%modNum*(arr.get(i-1))%modNum);
        }

        long n = x;
        String str = "";
        while (n > 0) {

            if(n%2==1){
                str = "1"+str;
            }else{
                str = "0"+str;
            }

            n/=2;

        }

        long sum = 1;

        char[] binaryChar = str.toCharArray();

        for(int i=1;i<=binaryChar.length;i++) {

            if (binaryChar[binaryChar.length - i] == '0'){

            }else if(binaryChar[binaryChar.length - i] == '1'){
                sum *= arr.get(i-1)%modNum;
                sum %= modNum;
            }
        }

        System.out.println(sum%modNum);

    }

}