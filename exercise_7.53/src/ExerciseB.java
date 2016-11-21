import java.security.SecureRandom;
import java.util.Arrays;


/**
 * Created by rubatharisan on 21/11/2016.
 */
public class ExerciseB {

    static int myIntArray[];
    static int runs = 0;
    static int startIndex = 0;
    static int k;

    public void setArray(int[] array) {
        this.myIntArray = array;
    }

    private int[] makeIntArray(int size, int max){
        SecureRandom random = new SecureRandom();
        this.myIntArray = new int[size];

        for (int i = 0; i < size; i++){
            this.myIntArray[i] = random.nextInt(max);
        }

        return this.myIntArray;

    }

    public void findSum(int i) {
        k = i;
        if(this.myIntArray[startIndex] > i){
            System.out.println("Sorry the least element in the array, is higher than the summation");
        } else {
            int complementary = i - this.myIntArray[startIndex];
            //System.out.println("We choose startIndex as : " + startIndex + " with value " + this.array[startIndex] + ". Lets search for: " + complementary);
            binarySearch(0, (int) Math.floor(this.myIntArray.length/2), this.myIntArray.length-1, complementary);
        }

    }

    private void findSum(){
        startIndex++;
        //System.out.println("We are looking for the sum " + k);
        if(this.myIntArray[startIndex] > k){
            System.out.println("Sorry the least element in the array, is higher than the summation");
        } else {
            int complementary = k - this.myIntArray[startIndex];
            int mid = (int) Math.floor((startIndex+(this.myIntArray.length-1))/2);
            System.out.println("We choose startIndex as : " + startIndex + " with value " + this.myIntArray[startIndex] + ". Lets search for: " + complementary);
            binarySearch(startIndex, mid, this.myIntArray.length-1, complementary);
        }
    }


    private void binarySearch(int start, int mid, int end, int complementaryInteger){
        this.runs++;

        boolean foundComplementary = false;
        boolean possible = true;
        System.out.println("* RUN " + this.runs + " ------------------------------------------------");
        System.out.println();
        System.out.println("-- K = " + this.k + ", ");
        System.out.println("-- C = K - array[i] => C = " + this.k + " - " + (myIntArray[startIndex]) + " = " + (this.k-myIntArray[startIndex]));
        System.out.println("-- Start index: " + start + " with value: " +  this.myIntArray[start]);
        System.out.println("-- Mid index: " + mid + " with value: " +  this.myIntArray[mid]);
        System.out.println("-- End index: " + end + " with value: " +  this.myIntArray[end]);
        System.out.println("-- Searching for C:  " + complementaryInteger);
        //printArray(start, mid, end);
        System.out.println("---------------------------------------------------------");

        if(this.myIntArray[start] == complementaryInteger){
            System.out.println("Found complementary at index: " + start);
            foundComplementary = true;
        }

        if(this.myIntArray[end] == complementaryInteger){
            System.out.println("Found complementary at index: " + end);
            foundComplementary = true;
        }

        if(this.myIntArray[mid] == complementaryInteger){
            System.out.println("Found complementary at index: " + mid);
            foundComplementary = true;
        }


        if(this.myIntArray[start] > complementaryInteger){
            possible = false;

        }

        if(this.myIntArray[end] < complementaryInteger){
            possible = false;
        }

        if(start > end){
            possible = false;
        }

        if(foundComplementary == false && possible) {
            if (this.myIntArray[mid] > complementaryInteger) {
                binarySearch(start, (int) Math.floor((mid+start)/2), mid - 1, complementaryInteger);
            }

            if (this.myIntArray[mid] < complementaryInteger) {
                binarySearch(mid + 1, (int) Math.floor((mid+end)/2), end, complementaryInteger);
            }
        }

        if(!possible){
            System.out.println("Sorry the element '" + complementaryInteger +  "' does not exist in our sub array.");
            findSum();
        }



    }


    public String getArray(){
        return Arrays.toString(this.myIntArray);
    }


    public void javaSort(){
        Arrays.sort(this.myIntArray);
    }

    public void printArray(int start, int mid, int end){
        String indexNumbers = "";
        String theValues = "";
        String seperatorTop = "------";
        for(int i = start; i < end + 1; i++){
            indexNumbers = indexNumbers + i + " | ";
            theValues = theValues + myIntArray[i] + " | ";
            seperatorTop = seperatorTop + "-";
        }
        System.out.println(seperatorTop);
        System.out.print("index | ");
        System.out.println(indexNumbers);
        System.out.print("value | ");
        System.out.println(theValues);
        System.out.println(seperatorTop);


        System.out.println();
    }

    public static void main(String[] args) {

        ExerciseB exercise = new ExerciseB();
        SecureRandom number = new SecureRandom();
        exercise.makeIntArray(25, 100);
        System.out.println();
        System.out.println("Initial random array: " + exercise.getArray());
        exercise.javaSort();
        System.out.println("Sorted array: " + exercise.getArray());
        System.out.println();

        exercise.findSum(number.nextInt(100));
    }

}
