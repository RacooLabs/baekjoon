import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class baekjoon10773 {

    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> s = new Stack<>();

        int num = Integer.parseInt(br.readLine());

        for(int i=0;i<num;i++){
            int get = Integer.parseInt(br.readLine());
            if(get == 0){
                if(!s.empty())
                    s.pop();

            }else{
                s.push(get);
            }
        }

        int sum = 0;

        for(;!s.empty();){
            sum+=s.pop();
        }

        System.out.println(sum);


    }

}
