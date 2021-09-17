import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon1920 {

    public static int lower_bound(int a[], int key){

        int i = 0;
        int j = a.length;


        while(i<j) {

            int mid = (i+j)/2;

            if(a[mid] >= key){
                j = mid;

            }else{
                i = mid+1;
            }

        }

        return j;

    }

    public static int upper_bound(int a[], int key){

        int i = 0;
        int j = a.length;


        while(i<j) {

            int mid = (i+j)/2;

            if(a[mid] > key){
                j = mid;

            }else{
                i = mid+1;
            }

        }

        return j;

    }


    public static void main(String args[]) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int findnum = Integer.parseInt(br.readLine());
        int[] findnums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(nums);

        for(int i=0;i<findnum;i++){
            int result = upper_bound(nums, findnums[i]) - lower_bound(nums, findnums[i]);
            if(result > 0){
                System.out.println("1");
            }else{
                System.out.println("0");
            }

        }

    }

}
