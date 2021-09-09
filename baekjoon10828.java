import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon10828 {

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int lineN = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();

        for(int i=0;i<lineN;i++){
            String[] c = br.readLine().split(" ");

            if(c[0].equals("push")) s.push(Integer.parseInt(c[1]));
            else if(c[0].equals("pop")){
                if(s.size()==0){
                    sb.append("-1\n");
                    System.out.print(sb);
                    sb.setLength(0);
                    continue;
                }

                sb.append(s.pop() + "\n");

            }else if(c[0].equals("size")){
                sb.append(s.size() + "\n");
            }else if(c[0].equals("empty")){

                if(s.size()==0){
                    sb.append("1\n");
                }else{
                    sb.append("0\n");
                }

            }else if(c[0].equals("top")){

                if(s.size()==0){
                    sb.append("-1\n");
                    System.out.print(sb);
                    sb.setLength(0);
                    continue;
                }

                sb.append(s.peek()+"\n");
            }

            System.out.print(sb);
            sb.setLength(0);

        }

    }
}
