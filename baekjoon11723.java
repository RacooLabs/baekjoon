import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class baekjoon11723 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> m = new HashMap<>();

        HashMap<Integer, Integer> mAll = new HashMap<>();
        for(int k=1;k<=20;k++){
            mAll.put(k,1);
        }

        int caseNum = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<caseNum;i++){
            String[] tmp = br.readLine().split(" ");
            String op = tmp[0];

            if(tmp.length >1){
                int num = Integer.parseInt(tmp[1]);

                if(op.equals("add")){
                    if(m.get(num) == null) m.put(num, 1);

                }else if(op.equals("check")){

                    if(m.get(num) != null) sb.append("1\n");
                    else sb.append("0\n");

                }else if(op.equals("remove")){

                    m.remove(num);

                }else if(op.equals("toggle")){

                    if(m.get(num) == null) m.put(num, 1);
                    else m.remove(num);

                }

            }else{

                if(op.equals("all")) {
                    m = (HashMap<Integer, Integer>) mAll.clone();
                }else if(op.equals("empty")){

                    m.clear();

                }

            }

        }

        System.out.println(sb.toString());

    }

}
