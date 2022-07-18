import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class baekjoon10814{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        ArrayList<Person> arrPerson = new ArrayList<>();

        for(int i=0;i<num;i++){

            String[] tmpArr = br.readLine().split(" ");

            arrPerson.add(new Person(Integer.parseInt(tmpArr[0]), tmpArr[1]));
        }

        Collections.sort(arrPerson, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {

                if(o1.age > o2.age){
                    return 1;
                }else if(o1.age < o2.age){
                    return -1;
                }else{
                    return 0;
                }

            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<arrPerson.size();i++){
            sb.append(arrPerson.get(i).age).append(" ").append(arrPerson.get(i).name).append("\n");
        }

        System.out.println(sb);


    }


    static class Person{

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        int age;
        String name;

    }


}
