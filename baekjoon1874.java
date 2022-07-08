import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baekjoon1874 {

    public static void main(String[] args) throws IOException {

        ArrayList<Integer> stack = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        ArrayList<Integer> inputArr = new ArrayList<>();

        for(int k=0;k<num;k++){
            inputArr.add(Integer.parseInt(br.readLine()));
        }

        int top = 0;

        int i=1;
        int index = 0;

        boolean isCorrect = true;

        StringBuilder str = new StringBuilder();

        while(top>=0 && index < num){

            if(stack.contains(inputArr.get(index))){
                int tmp = stack.get(top-1);
                stack.remove(top-1);
                top-=1;
                str.append("-\n");
                index++;

            }else{

                stack.add(i);
                top+=1;
                str.append("+\n");
                i++;

                if(i>num+1){

                    isCorrect = false;
                    break;
                }

            }

        }

        if(isCorrect){
            System.out.println(str);
        }else{
            System.out.println("NO");
        }

    }

}
