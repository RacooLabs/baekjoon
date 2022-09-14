import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ArrayList;

public class baekjoon5430 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int caseNum = Integer.parseInt(br.readLine());

        for(int i=0; i<caseNum;i++){

            String[] op = br.readLine().split("");
            int arrLength = Integer.parseInt(br.readLine());
            String opTmp = br.readLine();
            opTmp = opTmp.replace("[", "");
            opTmp = opTmp.replace("]", "");

            String[] arr = opTmp.split(",");

            //ArrayList<Integer> arrList = new ArrayList<Integer>();

            int[] arrList = new int[1000001];
            int left = 0;
            int right = arrLength-1;

            for(int k=0; k<arr.length ; k++){
                if(!arr[k].equals("")){
                    arrList[k] = Integer.parseInt(arr[k]);
                }
            }

            boolean isError = false;
            int flipCount = 0;


            for(int k=0;k<op.length;k++){
                if(op[k].equals("R")){

                    flipCount ++;

                }else if(op[k].equals("D")){

                    if(left <= right){
                        if(flipCount % 2 == 0) left++;
                        else right--;

                    }else{
                        isError = true;
                    }

                }
            }

            if(isError){
                sb.append("error"+"\n");
            }else{
                sb.append("[");

                if(flipCount % 2 == 0){

                    for(int c=left;c<right;c++){
                        sb.append(arrList[c]+",");
                    }
                    if(left <= right)sb.append(arrList[right]);

                }else{

                    for(int c=right;c>left;c--){
                        sb.append(arrList[c]+",");
                    }
                    if(left <= right) sb.append(arrList[left]);

                }

                sb.append("]"+"\n");

            }

        }

        System.out.println(sb);

    }

}
