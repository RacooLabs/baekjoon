import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon4949 {

    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(;;){

            char[] arr = br.readLine().toCharArray();

            if(arr.length == 1 && arr[0] == '.'){
                break;
            }

            Stack<String> s = new Stack<>();
            boolean isGood = true;

            for(int j=0;j<arr.length;j++){

                if(arr[j] == '(')
                    s.push("(");

                else if(arr[j] == '[')

                    s.push("[");

                else if (arr[j] == ')')
                {
                    if(s.empty()){
                        isGood = false;
                        break;
                    }

                    if(s.peek() == "["){
                        isGood = false;
                        break;
                    }

                    s.pop();

                }else if (arr[j] == ']'){

                    if(s.empty()){
                        isGood = false;
                        break;
                    }

                    if(s.peek() == "("){
                        isGood = false;
                        break;
                    }

                    s.pop();

                }
            }

            if(s.empty() && isGood){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }

        }
    }

}
