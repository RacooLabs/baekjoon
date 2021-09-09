import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon10845 {

    public static void main (String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList();

        int lineNum = Integer.parseInt(br.readLine());

        for(int i=0;i<lineNum;i++){

            String[] c = br.readLine().split(" ");

            if(c[0].equals("push")) q.add(Integer.parseInt(c[1]));
            else if(c[0].equals("front")) {
                if (q.isEmpty()){
                    sb.append("-1" + "\n");
                    continue;
                }

                sb.append(q.peek()+"\n");
            }
            else if(c[0].equals("back")){

                if (q.isEmpty()){
                    sb.append("-1" + "\n");
                    continue;
                }

                Object[] array = q.toArray();
                int lastE = (int)array[q.size()-1];
                sb.append(lastE+"\n");
            }
            else if(c[0].equals("pop")){

                if (q.isEmpty()){
                    sb.append("-1" + "\n");
                    continue;
                }

                sb.append(q.poll()+"\n");
            }
            else if(c[0].equals("size")) sb.append(q.size()+"\n");
            else if(c[0].equals("empty")) {
                if (q.isEmpty())
                    sb.append("1" + "\n");
                else
                    sb.append("0" + "\n");

            }

            System.out.print(sb);
            sb.setLength(0);


        }


    }

}
