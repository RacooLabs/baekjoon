import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon1259 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 1;

        while(num != 0){

            boolean isGood = true;

            String strOfNum= br.readLine();
            num = Integer.parseInt(strOfNum);

            String[] arr = strOfNum.split("");

            if(num != 0){

                for(int i=0;i<arr.length/2;i++){

                    if(!arr[i].equals(arr[arr.length-1-i])){
                        isGood = false;
                    }

                }

            }

            if(num != 0){
                if(isGood){
                    System.out.println("yes");
                }else{
                    System.out.println("no");
                }
            }


        }


    }

}
