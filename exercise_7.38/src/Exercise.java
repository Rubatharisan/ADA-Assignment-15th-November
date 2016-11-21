import java.security.SecureRandom;
import java.util.*;

/**
 * Created by rubatharisan on 21/11/2016.
 */
public class Exercise {
    Point[] points;

    public static void main(String args[]){

        Exercise exercise = new Exercise();

        //exercise.generatePoints(1000, 100);

        exercise.testPoints();

        Point[] myPoints = exercise.getPoints();

        List<PointAngle<Float, Point>> tuples = new ArrayList<PointAngle<Float, Point>>();
        // insert elements in no special order
        //tuples.add(new PointAngle<>(new Float(17.23), new Point(2,3)));
        //tuples.add(new PointAngle<>(new Float(14.21), new Point(4,2)));

        Comparator<PointAngle<Float, Point>> comparator = new Comparator<PointAngle<Float, Point>>(){

            public int compare(PointAngle<Float, Point> AngleA,
                               PointAngle<Float, Point> AngleB)
            {
                return AngleA.getAngle().compareTo(AngleB.getAngle());
            }

        };


        for(int p = 0; p < exercise.getPoints().length; p++){

            for(int q = 0; q < exercise.getPoints().length; q++){
                if(p != q){
                    //myPoints[q].printData();
                    //System.out.println(myPoints[p].getAngle(myPoints[q]).getClass().getName());
                    tuples.add(new PointAngle(myPoints[p].getAngle(myPoints[q]), myPoints[q]));
                    //System.out.println(myPoints[0].getAngle(myPoints[p]));
                    //myAngels[p] = myPoints[0].getAngle(myPoints[p]);
                }
            }

            Collections.sort(tuples, comparator);

            int counter = 1;
            PointAngle current = tuples.get(0);

            for(int i = 1; i < tuples.size(); i++){
                //System.out.println(tuples.get(i).getAngle() + " == " + current.getAngle() );
                //System.out.println(tuples.get(i).getAngle().getClass().getName() + " == " + current.getAngle().getClass().getName());
                //System.out.println(tuples.get(i).getAngle().getClass() == current.getAngle().getClass());

                Float myFloat = (Float) current.getAngle();
                if(tuples.get(i).getAngle().compareTo(myFloat)!=0){
                    // new element found, check for previous solution
                    if(counter>=3){
                        outputSolution(myPoints[p], tuples, i-1, counter);
                        //output solution
                        // exit somehow
                        break;
                    } else {
                        counter = 1;
                        current = tuples.get(i);
                    }
                } else {
                    // they are equal
                    counter++;
                }
                if(i == tuples.size()-1){
                    // i is last in the array
                    if(counter>=3){
                        outputSolution(myPoints[p], tuples, i, counter);
                        //output solution
                        // exit somehow
                        break;
                    }
                }


//                if(tuples.get(i).getAngle().compareTo(myFloat)==0){
//                    counter++;
//
//
//
//                } else {
//
//                    if(counter == 3){
//                        System.out.println("Found 3 colinear points");
//                        //System.out.println(tuples.get(i-3).getPoint());
//                        tuples.get(i-2).getPoint().printData();
//                        tuples.get(i-1).getPoint().printData();
//
//                    }
//
//                    counter = 1;
//                    current = tuples.get(i);
//                }


            }

            break;


            /* System.out.println(tuples.get(0).getAngle());
            System.out.println(tuples.get(1).getAngle());
            System.out.println(tuples.get(2).getAngle()); */

        }

        // Arrays.sort(myAngels);

        /* for(int i = 0; i < 100; i++){
            System.out.println(myAngels[i]);
        } */
    }

    public static void outputSolution(Point p, List<PointAngle<Float, Point>> tuples, int i, int counter){
        System.out.println("===");
        p.printData();
        System.out.println("===");

        for(int j=0; j < counter; j++) {
            System.out.println("-");
            System.out.println(tuples.get(i - j).getAngle());
            tuples.get(i - j).getPoint().printData();
        }
    }

    public void generatePoints(int amount, int maxXandY){
        SecureRandom randomX = new SecureRandom();
        SecureRandom randomY = new SecureRandom();
        points = new Point[amount];


        for(int i = 0; i < amount; i++) {
            Point myPoint = new Point(randomX.nextInt(maxXandY), randomY.nextInt(maxXandY));
            points[i] = myPoint;
        }

    }

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
