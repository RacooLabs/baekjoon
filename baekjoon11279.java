import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon11279 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[100001];

        int caseNum = Integer.parseInt(br.readLine());
        int index = 0;

        for(int i=0;i<caseNum;i++){

            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                //remove
                int topNum = arr[1];

                if(index < 1){
                    System.out.println(0);
                    continue;
                } else{
                    System.out.println(arr[1]);
                }

                arr[1] = arr[index];
                arr[index] = 0;
                index--;
                int tmp = arr[1];

                int point = 1;


                while(true){

                    if(point*2 < arr.length && point*2+1 < arr.length && (arr[point*2] != 0 && arr[point*2+1] != 0)) {
                        int maxPoint = arr[point * 2] > arr[point * 2 + 1] ? point * 2 : point * 2+1;


                        if (tmp < arr[maxPoint]) {
                            arr[point] = arr[maxPoint];
                            point = maxPoint;
                        } else {

                            arr[point] = tmp;
                            break;

                        }



                    }else if (point*2 < arr.length && (arr[point*2] != 0)) {

                        int maxPoint = point * 2;

                        if (tmp < arr[maxPoint]) {
                            arr[point] = arr[maxPoint];
                            point = maxPoint;
                        } else {

                            arr[point] = tmp;
                            break;

                        }

                    }else {

                        arr[point] = tmp;
                        break;

                    }

                }



            }else{
                //add

                index++;

                arr[index] = num;
                int tmp = arr[index];
                int point = index;

                while(true){

                    if(tmp > arr[point/2] && point != 1){
                        arr[point] = arr[point/2];
                        point /= 2;
                    }else{
                        arr[point] = tmp;
                        break;
                    }


                }

            }

        }


    }

}
