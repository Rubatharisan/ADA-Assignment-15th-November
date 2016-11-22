import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Created by rubatharisan on 21/11/2016.
 */
public class ExerciseA {
    int[] myIntArray;

    public int[] makeTestArray(int[] myArray){


        if(myArray == null) {

            // Define the size of myIntArray.
            this.myIntArray = new int[9];

            // Let's define the values inside that should reside inside myIntArray.
            System.out.println();
            System.out.print("** Using a predefined array with values: ");
            myArray = new int[] {1, 0, 3, 9, 3, 5, 0, 7, 8};
            System.out.print(Arrays.toString(myArray));

        } else {

            // Define the size of myIntArray.
            this.myIntArray = new int[myArray.length];

        }

        // Let's make a for loop that inserts the values into myIntArray.
        for(int i = 0; i < myArray.length; i++){
            this.myIntArray[i] = myArray[i];
        }

        // Return the value.
        return this.myIntArray;
    }

    // Lets make an array filled with random numbers.
    public int[] makeIntArray(int size, int max){

        // Let's get Java's secure random object.
        SecureRandom random = new SecureRandom();

        // Let's define the size of myIntArray.
        myIntArray = new int[size];

        // Let's make a for loop that inserts the random values into myIntArray.
        for (int i = 0; i < size; i++){
            myIntArray[i] = random.nextInt(max);
        }

        System.out.println();
        System.out.print("** Using a random values filled array: ");
        System.out.print(Arrays.toString(myIntArray));

        // Return myIntArray.
        return myIntArray;

    }

    // Let's make a nested for loop that compares
    public boolean nestedLookup(int theSum){
        boolean breakOut = false;

        System.out.println("[Nested for-loop] We are looking for a pair that gives out the sum: " + theSum);
        for (int i = 0; i < myIntArray.length; i++){
            for(int k = i+1; k < myIntArray.length; k++){
                //System.out.println(myIntArray[i] + " " + myIntArray[k]);
                if(i != k) {
                    if ((myIntArray[i] + myIntArray[k]) == theSum) {
                        // Found a match - we could break the for loop - but we want to see the worst case.
                        System.out.println("Pair found: " + myIntArray[i] + " + " + myIntArray[k] + " = " + theSum);
                        breakOut = true;
                        //break;
                    }
                }
            }
        }

        if(!breakOut){
            System.out.println("Sorry, no pairs were found in the given array.");
        }

        return breakOut;
    }

    public String getArray(){
        return Arrays.toString(this.myIntArray);
    }

    public void printText(){
        System.out.println("###");
        System.out.println("# A) Give an O(N^2) algorithm to solve the problem");
        System.out.println("##");

    }
}
