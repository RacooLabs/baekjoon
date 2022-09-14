import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon7662 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseNum = Integer.parseInt(br.readLine());

        for(int i=0;i<caseNum;i++){

            PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

            int calNum = Integer.parseInt(br.readLine());
            int count = 0;

            for(int j=0;j<calNum;j++){

                String[] tmp = br.readLine().split(" ");
                String op = tmp[0];
                int num = Integer.parseInt(tmp[1]);

                if(op.equals("I")){

                    minHeap.add(num);
                    maxHeap.add(num);

                    if(map.get(num) == null){
                        map.put(num, 1);
                    }else{
                        int mapTmp = map.get(num);
                        map.put(num, mapTmp+1);
                    }

                    count++;


                }else if(op.equals("D")){

                    if(num == -1 && !minHeap.isEmpty()){

                        int mapTmp = map.get(minHeap.peek());

                        while(mapTmp == 0 && !minHeap.isEmpty() ){

                            minHeap.poll();

                            if (!minHeap.isEmpty()) {
                                mapTmp = map.get(minHeap.peek());
                            }

                        }

                        if(!minHeap.isEmpty()){
                            int peek = minHeap.peek();
                            mapTmp = map.get(minHeap.peek());
                            map.put(peek, mapTmp-1);
                            minHeap.poll();
                            count--;
                        }


                    }else if(num == 1 && !maxHeap.isEmpty()){

                        int mapTmp = map.get(maxHeap.peek());

                        while(mapTmp == 0 && !maxHeap.isEmpty() ){
                            maxHeap.poll();
                            if (map.get(maxHeap.peek()) != null) {
                                mapTmp = map.get(maxHeap.peek());
                            }

                        }

                        /*for (Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
                            System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
                        }*/

                        if(!maxHeap.isEmpty()){
                            int peek = maxHeap.peek();
                            mapTmp = map.get(maxHeap.peek());
                            map.put(peek, mapTmp-1);
                            maxHeap.poll();

                            count--;
                        }


                    }

                }

            }

            if(!minHeap.isEmpty()){
                int mapTmp1 = map.get(minHeap.peek());

                while(mapTmp1 == 0 && !minHeap.isEmpty() ){

                    minHeap.poll();

                    if (map.get(minHeap.peek()) != null) {
                        mapTmp1 = map.get(minHeap.peek());
                    }

                }
            }


            if(!maxHeap.isEmpty()){
                int mapTmp2 = map.get(maxHeap.peek());

                while(mapTmp2 == 0 && !maxHeap.isEmpty() ){
                    maxHeap.poll();
                    if (map.get(maxHeap.peek()) != null) {
                        mapTmp2 = map.get(maxHeap.peek());
                    }

                }
            }




            if(count <= 0 || (minHeap.isEmpty() && maxHeap.isEmpty())) System.out.println("EMPTY");
            else if (minHeap.isEmpty()){
                System.out.println(maxHeap.peek() +" "+  maxHeap.peek());
            }else if (maxHeap.isEmpty()){
                System.out.println(minHeap.peek() +" "+ minHeap.peek());
            }else{
                System.out.println(maxHeap.peek() +" "+ minHeap.peek());
            }


        }

    }

}
