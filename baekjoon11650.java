import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class baekjoon11650 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        ArrayList<Point> arr = new ArrayList<>();

        for(int i=0;i<num;i++){

            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            arr.add(new Point(tmp[0], tmp[1]));



        }

        Collections.sort(arr, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {

                if(o1.x < o2.x){
                    return -1;

                }else if(o1.x > o2.x){
                    return 1;

                }else{

                    if(o1.y < o2.y){

                        return -1;

                    }else if(o1.y > o2.y){
                        return 1;
                    }else{
                        return 0;
                    }

                }

            }
        });

        for(int i=0;i<arr.size();i++){

            System.out.println(arr.get(i).x + " " + arr.get(i).y);

        }


    }

    static class Point{

        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

}
