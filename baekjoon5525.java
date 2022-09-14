import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baekjoon5525 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long p = Integer.parseInt(br.readLine());

        long length = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int count = 0;

        ArrayList<Integer> arrList = new ArrayList<>();

        long testNum = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == 'I') {
                testNum++;

                if (testNum == 1) {
                    count++;

                } else if (testNum > 1) {
                    arrList.add(count-1);
                    count = 1;
                    testNum = 1;
                }

                if(i == str.length()-1 && count > 1){
                    arrList.add(count-1);
                }

            }else if(str.charAt(i) == 'O') {

                testNum--;
                if(testNum < 0 && count <= 0){
                    testNum = 0;
                    continue;
                }

                if(testNum < 0 ){
                    arrList.add(count-1);
                    testNum=0;
                    count=0;
                }

                if(i == str.length()-1 && count > 1){
                    arrList.add(count-1);
                }

            }
        }

      /*System.out.println("@@");
       for(int i=0;i<arrList.size();i++){

            System.out.println(arrList.get(i));

        }*/

        long sum = 0;
        for(int i=0;i<arrList.size();i++){

            if(arrList.get(i)+1-p >= 0){
                sum+=arrList.get(i)+1-p;
            }


        }

        System.out.println(sum);



    }


}
