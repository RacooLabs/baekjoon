import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon2798 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int numOfCard = arr[0];
        int mainNum = arr[1];
        int gap = mainNum;
        int answer = 0;

        for(int i=0;i<numOfCard;i++){

            for(int j=0;j<numOfCard;j++){

                if(j!=i){

                    for(int k=0;k<numOfCard;k++){

                        if(k!=i && k!=j){

                            int sum = 0;
                            sum+=cards[i];
                            sum+=cards[j];
                            sum+=cards[k];

                            if(sum <= mainNum && gap > (mainNum-sum)){

                                gap = mainNum-sum;
                                answer = sum;

                            }

                        }

                    }

                }



            }

        }

        System.out.println(answer);

    }

}
