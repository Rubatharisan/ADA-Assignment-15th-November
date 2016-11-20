import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Created by rubatharisan on 20/11/2016.
 */

public class Exercise {
    boolean[] myBooleanArray;


    public static void main(String args[]){

        // Create an instance of our exercise class
        Exercise myBooleanArray = new Exercise();


        // Create a random boolean array with elements: true and false.
        myBooleanArray.makeBooleanArray(10);

        // Lets print our boolean array.
        myBooleanArray.printArray();

        // Lets sort our array - so false elements comes first.
        myBooleanArray.sort();

        // Lets print our sorted array
        myBooleanArray.printArray();

    }

    private boolean[] makeBooleanArray(int size){

        // Lets make a random object by Java.
        SecureRandom random = new SecureRandom();

        // Define our myBooleanArray with a boolean array and size.
        myBooleanArray = new boolean[size];

        // Lets make a for loop that puts our false / true values
        for (int i = 0; i < size; i++){

            // If our next random integer is 0, then put false into the current iteration
            if( random.nextInt(2) == 0 ){
                myBooleanArray[i] = false;
            } else {
                // Otherwise put true in.
                myBooleanArray[i] = true;
            }
        }

        // Return our filled up boolean array
        return myBooleanArray;

    }

    private void printArray(){

        // Lets print our boolean array
        System.out.println(Arrays.toString(myBooleanArray));

    }

    private void sort(){

        // Lets count how many false elements there is in our array.
        int falseCounter = 0;

        // For loop - If we catch any false elements, lets increment our falseCounter.
        for (int i = 0; i < myBooleanArray.length; i++){
            if(myBooleanArray[i] == false){
                falseCounter++;
            }
        }

        // For loop - lets create all first elements until [i] is above falseCounter as false.
        for (int i = 0; i < myBooleanArray.length; i++){
            if(i < falseCounter){
                myBooleanArray[i] = false;
            } else {
                // The rest will be true elements. 
                myBooleanArray[i] = true;
            }
        }


    }


}
