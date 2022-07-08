import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baekjoon1181 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        String[] dict = new String[num];

        for(int i=0;i<num;i++){

            dict[i] = br.readLine();

        }


        for(int s=0;s<dict.length;s++){

            int index = s;

            for(int k=s;k<dict.length;k++){

                if(compare1(dict[index], dict[k])== 1 ){

                    index = k;

                }

            }


            String tmp = dict[index];
            dict[index] = dict[s];
            dict[s] = tmp ;


        }

        for(int i=0;i<dict.length-1; i++){

            if(!dict[i].equals(dict[i+1])) System.out.println(dict[i]);

        }

        System.out.println(dict[dict.length-1]);

    }

    public static int compare1(String s1, String s2){



        if(s1.length() < s2.length()){
            return -1;
        }else if(s1.length() > s2.length()){
            return 1;
        }else{

            int index = 0;

            while(index < s1.length()){
                if(s1.charAt(index) == s2.charAt(index)){

                    index++;

                }else if(s1.charAt(index) < s2.charAt(index)){

                    return -1;

                }else{

                    return 1;
                }

            }

            if(index == s1.length()){
                return 0;
            }

        }


        return 0;

    }

}
