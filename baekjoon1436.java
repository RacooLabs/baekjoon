import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon1436 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int num = Integer.parseInt(br.readLine());

        int mainCount =0;

        for(int i=666;;i++){

            if(check(i) == true){

                mainCount++;

                if(mainCount == num){
                    System.out.println(i);
                    break;
                }

            }

        }



    }

    static boolean check(int i){

        String str = i+"";

        if(str.contains("666")){
            return true;
        }

        return false;

    }


}
