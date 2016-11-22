import java.security.SecureRandom;

/**
 * Created by rubatharisan on 22/11/2016.
 */
public class Tester {

    public static void main(String args[]){

        int k = 7; // The sum we are looking for;

        /*
         * A) Give an O(N^) algorithm to solve the problem
         */

        ExerciseA exercise = new ExerciseA();
        exercise.printText();


        /* Let's start out with an predefined array */
        // Make an test array with test values: myIntArray = [1,0,3,9,3,5,0,7,8]
        exercise.makeTestArray(null);

        // Let's print the array.
        System.out.println();
        System.out.println("Initial array: " + exercise.getArray());
        System.out.println();

        // Lets make a nested lookup for the sum of 14.
        startTimer();
        exercise.nestedLookup(k);
        endTimer();

        // Make an an array with random numbers, p1 = size, p2 = max value of a integer in randomInt.
        int[] myRandomArray = exercise.makeIntArray(10, 20);

        // Let's print the array.
        System.out.println();
        System.out.println("Initial array: " + exercise.getArray());
        System.out.println();

        // Lets make a nested lookup for the sum of 14.
        startTimer();
        exercise.nestedLookup(k);
        endTimer();


        System.out.println();
        System.out.println();


        /*
         * B) Give an O(N log N) algorithm to solve the problem
         */

        ExerciseB exerciseB = new ExerciseB();
        exerciseB.printText();

        // Test numbers - with predefined array
        exerciseB.makeTestArray(null);

        System.out.println();
        System.out.println("Initial array: " + exerciseB.getArray());
        exerciseB.javaSort();
        System.out.println("Sorted array: " + exerciseB.getArray());
        System.out.println();

        startTimer();
        exerciseB.findSumBS(k);
        endTimer();

        System.out.println();

        startTimer();
        exerciseB.findSum(k);
        endTimer();

        // Make an an array with random numbers, p1 = size, p2 = max value of a integer in randomInt.
        // Already defined from the previous exercise, so reusing the same array to for this purpose.
        System.out.println();
        System.out.print("** Using a random filled array with values: ");
        System.out.println();

        exerciseB.makeTestArray(myRandomArray);

        System.out.println();
        System.out.println("Initial array: " + exerciseB.getArray());
        exerciseB.javaSort();
        System.out.println("Sorted array: " + exerciseB.getArray());
        System.out.println();

        // Which K should we look for in our Random numbers?
        startTimer();
        exerciseB.findSumBS(k);
        endTimer();

        System.out.println();

        startTimer();
        exerciseB.findSum(k);
        endTimer();

    }

    static long startTime = 0;
    static long endTime = 0;

    public static void startTimer(){
        startTime = System.nanoTime();
    }

    public static void endTimer(){
        endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("[Time] Execution took: " + (duration) + "ns (" + (duration/1000000) + "ms)");
    }


}
