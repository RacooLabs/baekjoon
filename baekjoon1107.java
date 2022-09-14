import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class baekjoon1107 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int targetCh = Integer.parseInt(br.readLine());
        int brokenNum = Integer.parseInt(br.readLine());
        int[] brokenBtns;

        if(brokenNum == 0){
            brokenBtns = new int[0];

        }else{
            brokenBtns = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }


        ArrayList<Integer> availableBtn = new ArrayList<>();


        for(int i=0;i<10;i++){

            boolean isAvailable = true;

            for(int j=0;j<brokenBtns.length;j++){

                if(i == brokenBtns[j]){
                    isAvailable = false;
                }

            }

            if(isAvailable){
                availableBtn.add(i);
            }

        }


        int testCh = 0;

        int index[] = {-1, -1,-1,-1,-1,0};

        int beforeCh = -1;

        if(brokenNum < 10){

            while(true){

                String tmp = "";

                for(int i=0;i<6;i++){
                    if(index[i] >= 0){
                        tmp += availableBtn.get(index[i]).toString();
                    }else{
                        tmp += 0+"";
                    }

                }


                testCh = Integer.parseInt(tmp);

                if(testCh > targetCh){

                    break;

                }else{

                    beforeCh = testCh;

                    index[5]++;

                    for(int i=5;i>=1;i--){

                        if(index[i] == availableBtn.size()){

                            index[i] = 0; index[i-1]++;

                        }

                    }

                    if(index[0] == availableBtn.size()){
                        index[0] = 0; break;
                    }


                }


            }


        }

        int nearestNum;

        if(beforeCh != -1){

            if(Math.abs(targetCh - testCh) > Math.abs(targetCh- beforeCh)){
                nearestNum = beforeCh;
            }else if (Math.abs(targetCh - testCh) < Math.abs(targetCh- beforeCh)){
                nearestNum = testCh;
            }else{
                if((testCh+"").length() < (beforeCh+"").length()){
                    nearestNum = testCh;
                }else{
                    nearestNum = beforeCh;
                }
            }

        }else{
            nearestNum = testCh;
        }


        int plusMinusNum = Math.abs(nearestNum - targetCh);

        int count = 0;
        count += (nearestNum+"").length();
        count += plusMinusNum;

        //System.out.println(testCh + "@" + beforeCh);
        //System.out.println(nearestNum + "@" + plusMinusNum);

        if(brokenBtns.length!=10){
            System.out.println(Math.abs(targetCh - 100) < count ? Math.abs(targetCh - 100) : count);
        }else{
            System.out.println(Math.abs(targetCh - 100));
        }


    }

}
