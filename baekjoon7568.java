import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class baekjoon7568 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        ArrayList<Person> arr = new ArrayList<>();

        for(int i=0;i<num;i++){

            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            arr.add(new Person(tmp[0], tmp[1], i));

        }

        for(Person p : arr){
            int count = 1;
            for(Person s : arr){
                if(p.weight < s.weight && p.height < s.height){
                    count++;
                }
            }

            System.out.print(count + " ");

        }


    }

    static class Person{

        int weight;
        int height;
        int preOrder;
        int rank;


        public Person(int weight, int height, int preOrder){
            this.weight = weight;
            this.height = height;
            this.preOrder = preOrder;
        }

    }

}
