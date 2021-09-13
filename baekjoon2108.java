import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class baekjoon2108 {

    public static class Number implements Comparable<Number>{

        @Override
        public int compareTo(Number n){

            if(this.numCount < n.numCount){
                return -1;

            }else if (this.numCount == n.numCount){

                if(this.num > n.num){
                    return -1;
                }else if (this.num == n.num){
                    return 0;
                }else{
                    return 1;
                }

            }else{
                return 1;
            }
        }

        int num = 0;
        int numCount = 0;

        public Number(int num){
            this.num = num;
        }

    }


    public static void main (String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        ArrayList<Integer> l = new ArrayList<>();

        int sum = 0;

        for(int i=0;i<num;i++){
            int tmp = Integer.parseInt(br.readLine());
            sum += tmp;
            l.add(tmp);
        }

        l.sort(Comparator.naturalOrder());

        int mid = l.get(l.size()/2);

        int before = l.get(0);

        ArrayList<Number> ln = new ArrayList<>();
        Number n = new Number(l.get(0));
        n.numCount++;
        ln.add(n);

        int count = 0;

        for(int i=1;i<l.size(); i++){

            if(l.get(i) == before){
                n.numCount++;
            }else{

                before = l.get(i);
                n = new Number(l.get(i));
                n.numCount++;
                ln.add(n);

            }

        }

        Collections.sort(ln);

        System.out.println(Math.round((double)sum/num));
        System.out.println(mid);

        int index = 0;

        if(ln.size() <= 1){
            index = 0;
        }else{
            index = ln.size()-2;
        }

        if(ln.size() > 1){

            if(ln.get(ln.size()-1).numCount == ln.get(ln.size()-2).numCount){
                System.out.println(ln.get(index).num);
            }else{
                System.out.println(ln.get(ln.size()-1).num);
            }

        }else{
            System.out.println(ln.get(0).num);
        }

        System.out.println(l.get(l.size()-1) - l.get(0));



    }

}
