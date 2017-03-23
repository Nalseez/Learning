import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Created by Owner on 3/2/2017.
 */
public class App {

    static void compute(Set<Integer> ogSet){

        System.out.println(ogSet);
        if(ogSet.size() == 1){
            System.out.println(ogSet.toArray()[0]);
        } else {

            Set<Integer> newSet = new LinkedHashSet<>();
            for(int i = 1; i <= ogSet.size(); i++){
                if(i % 2 == 0){
                    newSet.add((Integer)ogSet.toArray()[i - 1]);
                }
            }
            compute(newSet);
        }
    }

    public static void main (String[] args)
    {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int numOfTestCases = sc.nextInt(); // arg1

        for(int i = 0; i < numOfTestCases; i++){

            int players = sc.nextInt();

            Set<Integer> mySet = new LinkedHashSet<>();

            for(int j = 1; j <= players; j++){
                mySet.add(j);
            }

            compute(mySet);


        }
    }
}
