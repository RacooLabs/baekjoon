import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon6064 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());



        for (int i = 0; i < num; i++) {
            int tmp[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            long M = tmp[0];
            long N = tmp[1];
            long x = tmp[2];
            long y = tmp[3];

            boolean isFind = false;

            long k = 0;

            long lcm_i = lcm(M, N);

            if (M == x && N == y){
                System.out.println(lcm_i);
            }else{

                if(M==x) x = 0;
                if(N==y) y = 0;

                for (k = x; k <= M * N; k += M) {

                    if (k % N == y) {
                        isFind = true;
                        break;
                    }

                }

                if (isFind) System.out.println(k);
                else System.out.println(-1);

            }

        }

    }



    static long gcd(long a, long b){

        if(a > b){
            long tmp = a;
            a = b;
            b = tmp;
        }

        while(b>0){

            long tmp = b;
            b %= a;
            a = tmp;

        }

        return a;

    }

    static long lcm(long a, long b){

        long gcd_i = gcd(a, b);

        return gcd_i * a/gcd_i * b/gcd_i;

    }




}


