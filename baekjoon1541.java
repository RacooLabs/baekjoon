import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class baekjoon1541 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        ArrayList<Integer> st = new ArrayList<Integer>();
        ArrayList<Character> ct = new ArrayList<Character>();
        

        if(str.charAt(0) != '-'){
            str = "+"+str;
        }

        for(int i=0;i<str.length();i++){

            char s = str.charAt(i);

            switch(s){

                case '+':
                    ct.add('+');

                    int k = i+1;
                    while(k != str.length() && str.charAt(k) != '+' && str.charAt(k) != '-' ){
                        k++;
                    }

                    String tmpStr1 = str.substring(i+1,k);
                    i += tmpStr1.length();
                    st.add(Integer.parseInt(tmpStr1));
                    break;

                case '-':

                    ct.add('-');

                    int k2 = i+1;
                    while( k2 != str.length() && str.charAt(k2) != '+' && str.charAt(k2) != '-'){
                        k2++;
                    }

                    String tmpStr2 = str.substring(i+1,k2);
                    i += tmpStr2.length();
                    st.add(Integer.parseInt(tmpStr2));
                    break;

            }

        }



        int result = 0;
        int pointer = 0;

        boolean isMinus = false;


        for(int i=0;i<ct.size();i++){

            char s = ct.get(i);

            switch(s){

                case '+':

                    if(isMinus){
                        result -= st.get(pointer);

                    }else{
                        result += st.get(pointer);
                    }
                    pointer++;

                    break;

                case '-':

                    isMinus = true;

                    result -= st.get(pointer);
                    pointer++;
                    break;

            }

        }

        System.out.println(result);




    }

}
