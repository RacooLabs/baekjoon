import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon10816 {

    public static int lowerBound(int[] arr, int target, int size){

        int mid, start, end;

        start = 0;
        end = size;

        while(start < end){

            mid = (start + end) / 2;

            if (arr[mid] >= target){
                end = mid;
            }else start = mid + 1;
        }

        return end;
    }

    public static int upperBound(int[] arr, int target, int size){

        int mid, start, end;

        start = 0;
        end = size;

        while(start < end){
            mid = (start + end) / 2;

            if (arr[mid] > target){
                end = mid;
            }else start = mid + 1;

        }

        return end;
    }


    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cardN = Integer.parseInt(br.readLine());
        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int findCardN = Integer.parseInt(br.readLine());
        int[] findCards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(cards);

        int[] countArr = new int[findCardN];


        for(int i=0;i<findCardN;i++){
            countArr[i] = upperBound(cards,findCards[i], cardN) - lowerBound(cards,findCards[i], cardN);
        }

        for (int k = 0;k<findCardN;k++){
            sb.append(countArr[k] + " ");
        }

        System.out.println(sb);


    }




}
