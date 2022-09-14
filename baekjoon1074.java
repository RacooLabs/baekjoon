import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.pow;

public class baekjoon1074 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        int N = arr[0];
        int r = arr[1];
        int c = arr[2];

        long count= -1;


        ArrayList<Cell> queue = new ArrayList<Cell>();

        queue.add(new Cell(0, (long)Math.pow(2,N)-1, 0, (long)Math.pow(2,N)-1));

        while(!queue.isEmpty()){

            Cell tmp = queue.get(0);
            queue.remove(0);

            long dxy = (tmp.endDy - tmp.startDy + 1)/2;

            //System.out.println(dxy);


            if(dxy > 0 ){

                if(tmp.startDy <= c  && c<= tmp.startDy + dxy-1 && tmp.startDx <= r && r<= tmp.startDx + dxy-1){
                    queue.add(new Cell(tmp.startDy, tmp.startDy + dxy-1, tmp.startDx, tmp.startDx + dxy-1));
                    count += Math.pow(dxy, 2)*0;
                }else if(tmp.startDy + dxy <= c  && c<= tmp.startDy + dxy*2-1 && tmp.startDx <= r && r<=tmp.startDx + dxy-1){

                    queue.add(new Cell(tmp.startDy + dxy, tmp.startDy + dxy*2-1, tmp.startDx, tmp.startDx + dxy-1));
                    count += Math.pow(dxy, 2)*1;

                }else if(tmp.startDy <= c  && c<= tmp.startDy + dxy-1 && tmp.startDx + dxy  <= r && r<= tmp.startDx + dxy*2-1){
                    queue.add(new Cell(tmp.startDy, tmp.startDy + dxy-1, tmp.startDx  + dxy, tmp.startDx + dxy*2-1 ));
                    count += Math.pow(dxy, 2)*2;

                }else if(tmp.startDy  + dxy <= c  && c<= tmp.startDy + dxy*2-1 && tmp.startDx  + dxy <= r && r<= tmp.startDx + dxy*2-1){
                    queue.add(new Cell(tmp.startDy  + dxy , tmp.startDy + dxy*2-1, tmp.startDx  + dxy, tmp.startDx + dxy*2-1 ));
                    count += Math.pow(dxy, 2)*3;

                }


                /*System.out.println(tmp.startDy+"@"+(tmp.startDy+ dxy-1)+"@"+(tmp.startDx)+"@"+(tmp.startDx + dxy-1));
                System.out.println(tmp.startDy + dxy+"@"+(tmp.startDy+  dxy*2-1)+"@"+(tmp.startDx)+"@"+(tmp.startDx + dxy-1));
                System.out.println(tmp.startDy+"@"+(tmp.startDy+ dxy-1)+"@"+(tmp.startDx  + dxy)+"@"+(tmp.startDx + dxy*2-1));
                System.out.println((tmp.startDy + dxy)+"@"+(tmp.startDy+ dxy*2-1)+"@"+(tmp.startDx + dxy)+"@"+(tmp.startDx + dxy*2-1));*/

            }else{

                count++;

                //System.out.println(tmp.startDy + "@@" + tmp.startDx);

                if(tmp.startDy == c && tmp.startDx == r){
                    break;
                }

            }


        }

        System.out.println(count);


    }

    static class Cell{

        long startDy = 0;
        long endDy = 0;
        long startDx = 0;
        long endDx = 0;

        public Cell(long startDy, long endDy, long startDx, long endDx) {
            this.startDy = startDy;
            this.endDy = endDy;
            this.startDx = startDx;
            this.endDx = endDx;
        }


    }

}
