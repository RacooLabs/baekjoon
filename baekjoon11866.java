import java.util.Scanner;

public class baekjoon11866 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int peopleNum = sc.nextInt();
        int count = sc.nextInt();

        int[] arr = new int[peopleNum];

        for(int i=0;i<peopleNum;i++) {
            arr[i] = i + 1;
        }

        int restPeople = peopleNum;

        int currentCount = count-1;

        System.out.print("<");

        while(restPeople!=0){

            if(restPeople == 1)
                System.out.print(arr[currentCount]) ;
            else
                System.out.print(arr[currentCount]+", ");

            arr[currentCount] = 0;

            for(int i = 0 ; i<count; i++){
                currentCount++;

                currentCount %= peopleNum;

                if(arr[currentCount] == 0){
                    i--;
                    if(restPeople == 1){
                        break;
                    }
                }

            }

            restPeople--;

        }

        System.out.println(">");

    }


}
