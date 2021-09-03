import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon10866 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();



        int lineNum = Integer.parseInt(br.readLine());


        int arrNum = 10000;

        int[] arr = new int[arrNum];
        int frontPos = 0;
        int backPos = 0;

        for (int i = 0; i < lineNum; i++) {


            String[] array = br.readLine().split(" ");


            if(array[0].equals("push_front")){

                arr[frontPos] = Integer.parseInt(array[1]);

                frontPos--;

                if(frontPos < 0)
                    frontPos = arrNum-1;


            }else if (array[0].equals("push_back")){

                backPos++;
                backPos %= arrNum;

                arr[backPos] = Integer.parseInt(array[1]);

            }else if (array[0].equals("pop_front")){

                if(frontPos == backPos) {
                    System.out.println("-1");
                    continue;
                }

                frontPos++;
                frontPos %= arrNum;

                System.out.println(arr[frontPos]);


            }else if (array[0].equals("pop_back")){

                if(frontPos == backPos) {
                    System.out.println("-1");
                    continue;
                }

                System.out.println(arr[backPos]);

                backPos--;
                if(backPos < 0)
                    backPos = arrNum-1;


            }else if (array[0].equals("size")){

                int size = frontPos<=backPos ? backPos - frontPos : arrNum - (frontPos - backPos) ;

                System.out.println(size);

            }else if (array[0].equals("empty")){


                if(frontPos == backPos){
                    System.out.println("1");
                }else{
                    System.out.println("0");
                }

            }else if (array[0].equals("front")){

                if(frontPos == backPos) {
                    System.out.println("-1");
                    continue;
                }

                int tmpfrontPos = frontPos + 1;
                tmpfrontPos %= arrNum;

                System.out.println(arr[tmpfrontPos]);


            }else if (array[0].equals("back")) {

                if (frontPos == backPos) {
                    System.out.println("-1");
                    continue;
                }

                System.out.println(arr[backPos]);

            }


        }

    }



}
