import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class baekjoon1927 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[] heap = new int[300000];

        int back = 1;

        for(int i=0;i<num;i++){

            int inputNum = Integer.parseInt(br.readLine());


            if(inputNum== 0) {

                if(back <= 1) {
                    System.out.println(0);
                    continue;
                }

                //하나 꺼내기
                System.out.println(heap[1]);
                heap[1] = heap[back-1];
                heap[back-1] = 0;
                int tmp = heap[1];

                int minIndex = 1; //현재 위치한 인덱스

                while (true) {

                    int downIndex = 0;

                    if(heap[minIndex * 2]  != 0 &&heap[minIndex * 2 + 1]  != 0 ){
                        downIndex = heap[minIndex * 2] < heap[minIndex * 2 + 1] ? minIndex * 2 : minIndex * 2 + 1;
                    }else if(heap[minIndex * 2]  != 0 &&heap[minIndex * 2 + 1]  == 0 ){
                        downIndex = minIndex * 2;
                    }else if (heap[minIndex * 2] == 0 &&heap[minIndex * 2 + 1]  == 0){
                        heap[minIndex] = tmp;
                        back--;
                        break;
                    }

                    if (tmp <= heap[downIndex]) {

                        heap[minIndex] = tmp;
                        back--;
                        break;

                    } else {

                        heap[minIndex] = heap[downIndex];
                        minIndex = downIndex;

                    }


                }



            }else{

                heap[back] = inputNum;
                int tmp = heap[back];

                int upIndex = back;

                if(upIndex>1){

                    while(true){

                        if(tmp < heap[upIndex/2]){
                            heap[upIndex] = heap[upIndex/2];
                            upIndex = upIndex/2;

                        }else{

                            heap[upIndex] = tmp;
                            break;
                        }

                    }

                }

                back++;


            }


        }




    }

}
