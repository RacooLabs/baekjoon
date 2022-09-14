import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class baekjoon1931 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        ArrayList<Meeting> arr = new ArrayList<>();
        for(int i=0;i<num;i++){

            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr.add(new Meeting(tmp[0], tmp[1]));

        }

        Collections.sort(arr, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {

                if(o1.end < o2.end){
                    return -1;
                }else if(o1.end > o2.end){
                    return 1;
                }else{

                    if(o1.start < o2.start){
                        return -1;
                    }else if(o1.start > o2.start){
                        return 1;
                    }else{
                        return 0;
                    }

                }

            }
        });

        int count = 0;
        int endTime = 0;

        for(int i=0;i<arr.size();i++){

            if(endTime<= arr.get(i).start){
                count++;
                endTime = arr.get(i).end;
            }

        }

        System.out.println(count);


    }

    static class Meeting{

        int start;
        int end;


        Meeting(int start,int end){

            this.start = start;
            this.end = end;

        }

    }

}
