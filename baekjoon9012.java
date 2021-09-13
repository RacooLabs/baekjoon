import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon9012 {
    public static void main(String args[])throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for(int i=0;i<num;i++){

            Stack<String> s = new Stack<>();
            boolean isGood = true;

            char[] arr = br.readLine().toCharArray();

            for(int j=0;j<arr.length;j++){

                if(arr[j] == '(')
                    s.push("(");
                else if (arr[j] == ')')
                {
                    if(s.empty()){
                        isGood = false;
                        break;
                    }
                    s.pop();
                }


            }

            if(s.empty() && isGood){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }

    }
}
