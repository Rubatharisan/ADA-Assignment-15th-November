import java.security.SecureRandom;
import java.util.*;

/**
 * Created by rubatharisan on 21/11/2016.
 */
public class Exercise {
    Point[] points;

    public static void main(String args[]){

        Exercise exercise = new Exercise();

        //exercise.generatePoints(1000, 50);

        // Our test points
        exercise.testPoints();

        // Get our points.
        Point[] myPoints = exercise.getPoints();


        // Create an comparator which will compare the angle every time it gets inserted into the list.
        Comparator<PointAngle<Float, Point>> comparator = new Comparator<PointAngle<Float, Point>>(){

            public int compare(PointAngle<Float, Point> AngleA,
                               PointAngle<Float, Point> AngleB)
            {
                return AngleA.getAngle().compareTo(AngleB.getAngle());
            }

        };

        // A outer loop to break out when we have a group of 3 or more.
        outerloop:
        // loop our points
        for(int p = 0; p < exercise.getPoints().length; p++){
            // Create a list called tuples.
            List<PointAngle<Float, Point>> tuples = new ArrayList<PointAngle<Float, Point>>();

            // loop our points
            for(int q = 0; q < exercise.getPoints().length; q++){

                // if p = q, then skip
                if(p != q){

                    // add the angle of the points into the list.
                    tuples.add(new PointAngle(myPoints[p].getAngle(myPoints[q]), myPoints[q]));

                }
            }

            // Sort the angles of all points related to P.
            Collections.sort(tuples, comparator);

            // Count occurrences of an identical angle
            int counter = 1;

            // Get the first point
            PointAngle current = tuples.get(0);

            // Loop the list.
            for(int i = 1; i < tuples.size(); i++){

                // I don't know why, but I had to create this, for it to work with the if statement below.
                Float myFloat = (Float) current.getAngle();

                // Compare an angle (in a sorted list), with another angle - in the sorted list.
                if(tuples.get(i).getAngle().compareTo(myFloat)!=0){
                    // new element found, check for previous solution
                    if(counter>=3){
                        //System.out.println(tuples.get(i-1).getAngle());
                        // Current angle is not equal with the previous one, lets output if counter is eq/above 3.
                        outputSolution(myPoints[p], tuples, i-1, counter);
                        break outerloop;
                    } else {
                        // Reset counter, and get a new point.
                        counter = 1;
                        current = tuples.get(i);
                    }
                } else {
                    // they are equal, let's increase the counter.
                    counter++;
                }

                // If we hit the last angle in the list, then outputSolution, if the last 3 occurrences is the same.
                if(i == tuples.size()-1){
                    // i is last in the array
                    if(counter>=3){
                        outputSolution(myPoints[p], tuples, i, counter);
                        break outerloop;
                    }
                }
            }


        }

    }

    // Output our solution, if any found.
    public static void outputSolution(Point p, List<PointAngle<Float, Point>> tuples, int i, int counter){
        System.out.print("P=  ");
        p.printData();
        System.out.println("===");

        for(int j=0; j < counter; j++) {
            int m = j;
            System.out.print("Q" + (m+1) + "= ");
            //System.out.print(tuples.get(i - j).getAngle());
            tuples.get(i - j).getPoint().printData();
        }
    }

    // Generate some random points - for testing purposes with larger sets.
    public void generatePoints(int amount, int maxXandY){
        SecureRandom randomX = new SecureRandom();
        SecureRandom randomY = new SecureRandom();
        points = new Point[amount];


        for(int i = 0; i < amount; i++) {
            Point myPoint = new Point(randomX.nextInt(maxXandY), randomY.nextInt(maxXandY));
            points[i] = myPoint;
        }

    }

    // My testing points.
    public void testPoints(){
        points = new Point[9];

        Point myPoint01 = new Point(1,1);
        Point myPoint02 = new Point(1,6);

        Point myPoint1 = new Point(2,1);
        Point myPoint2 = new Point(3,2);
        Point myPoint3 = new Point(4,3);
        Point myPoint4 = new Point(5,4);
        Point myPoint5 = new Point(6,5);
        Point myPoint6 = new Point(7,6);

        Point myPoint03 = new Point(5,1);

        points[0] = myPoint1;
        points[1] = myPoint2;
        points[2] = myPoint3;


        points[3] = myPoint01;
        points[4] = myPoint02;
        points[5] = myPoint03;

        points[6] = myPoint4;
        points[7] = myPoint5;
        points[8] = myPoint6;

    }

    public Point[] getPoints(){
        return points;
    }





}
