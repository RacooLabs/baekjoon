import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class baekjoon2164 {

    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> d = new ArrayDeque<>();

        int num = Integer.parseInt(br.readLine());

        for(int i=num; i>0; i--){
            d.addFirst(i);
        }

        for(int i = 0 ; i<num-1;i++){

            d.removeFirst();
            int tmp = d.poll();
            d.addLast(tmp);

        }

        System.out.println(d.pollFirst());
    }


}
