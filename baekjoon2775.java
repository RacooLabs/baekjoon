import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2775 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testNum = Integer.parseInt(br.readLine());

        for(int i=0;i<testNum;i++){
            
            int resultFloor = Integer.parseInt(br.readLine());
            int resultRoom = Integer.parseInt(br.readLine());

            int[] preFloor = new int[15];
            int[] nextFloor = new int[15];

            for(int k=1;k<=14;k++){
                preFloor[k] = k;
            }

            int floorCount = 1;

            while(floorCount < resultFloor + 1){

                
                for(int k=1;k<=14;k++){

                    int sum=0;
                    for(int s=1;s<=k;s++){
                        sum+= preFloor[s];

                    }
                    nextFloor[k] = sum;
                }

                floorCount++;

                if(floorCount < resultFloor + 1){

                    for(int k=1;k<=14;k++) preFloor[k] = nextFloor[k];

                }

            }

            System.out.println(nextFloor[resultRoom]);


        }

    }

}
