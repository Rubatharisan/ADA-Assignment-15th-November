import java.security.SecureRandom;
import java.util.Arrays;


/**
 * Created by rubatharisan on 21/11/2016.
 */
public class ExerciseB {

    static int myIntArray[];

    // Create an array with random integers
    public int[] makeIntArray(int size, int max){
        SecureRandom random = new SecureRandom();
        this.myIntArray = new int[size];

        for (int i = 0; i < size; i++){
            this.myIntArray[i] = random.nextInt(max);
        }

        System.out.println();
        System.out.print("** Using a random values filled array: ");
        System.out.print(Arrays.toString(myIntArray));

        return this.myIntArray;

    }

    // Make an test array with specified inputs - great for testing
    public int[] makeTestArray(int[] myArray){

        if(myArray == null) {
            this.myIntArray = new int[9];

            System.out.println();
            System.out.print("** Using a predefined array with values: ");
            myArray = new int[] {1, 0, 3, 9, 3, 5, 0, 7, 8};
            //myArray = new int[] {0, 0, 0, 0, 1, 2, 4, 8, 8, 9};
            System.out.print(Arrays.toString(myArray));
        } else {
            this.myIntArray = new int[myArray.length];
        }

        for(int i = 0; i < myArray.length; i++){
            this.myIntArray[i] = myArray[i];
        }

        return this.myIntArray;
    }




    public void findSum(int k) {

        int start = 0;
        int end = this.myIntArray.length -1;
        boolean foundSum = false;

        System.out.println("[Custom Search] We are looking for a pair that gives out the sum: " + k);

        while(start < end){
            int toFind = k - this.myIntArray[start];
            boolean found = false;
            while(start < end && !found && this.myIntArray[end]>= toFind){
                if(this.myIntArray[end] == toFind){
                    found = true;
                    foundSum = true;
                    System.out.println("Pair found: " + this.myIntArray[start] + " + " + this.myIntArray[end] + " = " + k);
                } else {
                    end--;
                }
            }
            start++;
        }

        if(!foundSum){
            System.out.println("Sorry, no pairs were found in the given array.");
        }
    }

    public void findSumBS(int k) {

        int end = this.myIntArray.length -1;
        boolean foundSum = false;


        System.out.println("[Binary Search] We are looking for a pair that gives out the sum: " + k);

        for(int i = 0; i < this.myIntArray.length; i++){

            int toFind = k - this.myIntArray[i];

            if(toFind < 0){
                break;
            }

            int start = i;

            while(start <= end){
                int mid = (int) Math.floor((start+end)/2);


                if(this.myIntArray[mid] == toFind){
//                    System.out.println(this.myIntArray[i]);
//                    System.out.println(k - this.myIntArray[i]);
//                    System.out.println(start);
//                    System.out.println(toFind);
                    System.out.println("Pair found: " + this.myIntArray[i] + " + " + this.myIntArray[mid] + " = " + k);
                    foundSum = true;
                    break;
                }

                if(this.myIntArray[mid] < toFind){
                    start = mid + 1;
                }

                if(this.myIntArray[mid] > toFind){
                    end = mid - 1;
                }

            }

            if(foundSum){
                //break;
            }
        }


        if(!foundSum){
            System.out.println("Sorry, no pairs were found in the given array.");
        }
    }


    public String getArray(){
        return Arrays.toString(this.myIntArray);
    }


    public void javaSort(){
        Arrays.sort(this.myIntArray);
    }

    public void printText(){
        System.out.println("###");
        System.out.println("# B) Give an O(N log N) algorithm to solve the problem");
        System.out.println("# (Hint: first sort it, then linear time to find the sum)");
        System.out.println("##");

    }

}
