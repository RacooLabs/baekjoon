import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon9095 {

     public static void main(String[] args) throws IOException {

          Queue<Integer> queue = new LinkedList<>();

          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

          int caseNum = Integer.parseInt(br.readLine());

          for(int i=0;i<caseNum;i++){

               int num = Integer.parseInt(br.readLine());

               int count = 0;

               if(num == 1){
                    System.out.println(1);
                    continue;
               }else if(num == 2){
                    System.out.println(2);
                    continue;
               }else if(num == 3){
                    System.out.println(4);
                    continue;
               }

               queue.offer(1);
               queue.offer(2);
               queue.offer(3);

               while(!queue.isEmpty()){

                    int peekNum = queue.poll();

                    if(peekNum+1 == num){
                         count++;
                         continue;
                    }else{
                         queue.offer(peekNum+1);
                    }

                    if(peekNum+2 == num ){
                         count++;
                         continue;
                    }else{
                         queue.offer(peekNum+2);
                    }

                    if(peekNum+3 == num){
                         count++;
                         continue;
                    }else{
                         queue.offer(peekNum+3);
                    }


               }

               System.out.println(count);

          }



     }

}
