import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class baekjoon11661 {

    static public class Num implements Comparable<Num>{

        int x, y;

        public Num(int x, int y){
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(Num n) {
            if(y < n.y){
                return -1;
            }else if( y == n.y){

                if(x< n.x){
                    return -1;
                }else if(x == n.x){
                    return 0;
                }else{
                    return 1;
                }

            }else{
                return 1;
            }
        }
    }


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int line = Integer.parseInt(br.readLine());
        ArrayList<Num> nList = new ArrayList<>();


        for (int i=0;i<line;i++){

            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            nList.add(new Num(tmp[0], tmp[1]));

        }

        Collections.sort(nList);

        for(int i=0;i<nList.size();i++){
            System.out.println(nList.get(i).x + " " + nList.get(i).y);
        }



    }

}
