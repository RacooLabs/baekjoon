import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class baekjoon10828 {

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Integer> stack = new LinkedList<>();

        int caseNum = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<caseNum;i++){

            String[] str = br.readLine().split(" ");
            String op;
            int num = 0;
            op = str[0];
            if(str.length > 1) num = Integer.parseInt(str[1]);

            if(op.equals("push")){

                stack.add(0, num);

            }else if(op.equals("top")){

                if(stack.size() > 0) sb.append(stack.get(0) + "\n");
                else sb.append(-1 + "\n");

            }else if(op.equals("size")){

                sb.append(stack.size() + "\n");

            }else if(op.equals("pop")){

                if(stack.size() > 0) sb.append(stack.remove(0) + "\n");
                else sb.append(-1 + "\n");


            }else if(op.equals("empty")){

                if(stack.size() == 0) sb.append(1 + "\n");
                else sb.append(0 + "\n");
            }



        }
        System.out.println(sb);


    }
}
