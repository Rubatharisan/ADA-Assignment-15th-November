import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Created by rubatharisan on 20/11/2016.
 */

public class Exercise {
    boolean[] myBooleanArray;


    public static void main(String args[]){
        System.out.println("Hello!");

        Exercise myBooleanArray = new Exercise();

        myBooleanArray.makeBooleanArray(10);

        myBooleanArray.printArray();

        myBooleanArray.sort();

        myBooleanArray.printArray();




    }

    private boolean[] makeBooleanArray(int size){
        SecureRandom random = new SecureRandom();
        myBooleanArray = new boolean[size];

        for (int i = 0; i < size; i++){
            if( random.nextInt(2) == 0 ){
                myBooleanArray[i] = false;
            } else {
                myBooleanArray[i] = true;
            }
        }

        return myBooleanArray;

    }

    private void printArray(){
        System.out.println(Arrays.toString(myBooleanArray));
    }

    private void sort(){

        int falseCounter = 0;

        for (int i = 0; i < myBooleanArray.length; i++){
            if(myBooleanArray[i] == false){
                falseCounter++;
            }
        }

        for (int i = 0; i < myBooleanArray.length; i++){
            if(i < falseCounter){
                myBooleanArray[i] = false;
            } else {
                myBooleanArray[i] = true;
            }
        }


    }


}
