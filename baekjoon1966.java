import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon1966 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfTest = Integer.parseInt(br.readLine());

        for(int i=0;i<numOfTest;i++){

            int tmp[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] queue = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


            ArrayList<Num> numQueue = new ArrayList<>();

            for(int k=0;k<queue.length;k++){

                numQueue.add(new Num(k, queue[k]));

            }


            for(int s=0;s<numQueue.size();s++){

                for(int j=s+1;j<numQueue.size();j++){

                    if(numQueue.get(s).num < numQueue.get(j).num){

                        Num tmpNum = numQueue.get(s);
                        numQueue.remove(s);
                        numQueue.add(numQueue.size(), tmpNum);
                        s--;
                        break;

                    }

                }

            }


            int findNum = tmp[1];

            for(int k=0;k<numQueue.size();k++){
                if(numQueue.get(k).preOrder == findNum) System.out.println(k+1);
            }


        }


    }

    static class Num{


        int preOrder;
        int num;

        public Num(int preOrder, int num) {
            this.preOrder = preOrder;
            this.num = num;
        }


    }

}
