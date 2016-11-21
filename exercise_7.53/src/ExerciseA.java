import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Created by rubatharisan on 21/11/2016.
 */
public class ExerciseA {
    int[] myIntArray;

    public static void main(String args[]){

        // A)
        ExerciseA exercise = new ExerciseA();
        exercise.makeIntArray(10, 20);
        exercise.printArray();
        exercise.nestedLookup(4);


    }

    private int[] makeIntArray(int size, int max){
        SecureRandom random = new SecureRandom();
        myIntArray = new int[size];

        for (int i = 0; i < size; i++){
            myIntArray[i] = random.nextInt(max);
        }

        return myIntArray;

    }

    private boolean nestedLookup(int theSum){
        boolean breakOut = false;

        System.out.println("We are looking for a pair that gives out the sum: " + theSum);
        for (int i = 0; i < myIntArray.length; i++){
            for(int k = 0; k < myIntArray.length; k++){
                //System.out.println(myIntArray[i] + " " + myIntArray[k]);
                if((myIntArray[i] + myIntArray[k]) == theSum){
                    // Found a match - we could break the for loop - but we want to see the worst case.
                    System.out.println("Pair found: " + myIntArray[i] + " + " + myIntArray[k] + " = " + theSum);
                    breakOut = true;
                }
            }
        }

        if(!breakOut){
            System.out.println("No matching pair found to give the sum: " + theSum);
        }
        return breakOut;
    }

    private void printArray(){
        System.out.println("Our array of random numbers:");
        System.out.println(Arrays.toString(myIntArray));
    }
}
