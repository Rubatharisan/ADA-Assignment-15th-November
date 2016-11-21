/**
 * Created by rubatharisan on 21/11/2016.
 */
public class Point {
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void printData(){
        System.out.println("X: " + this.x + ", Y: " + this.y);
    }

    public Float getAngle(Point target) {
        float angle = (float) Math.toDegrees(Math.atan2(target.y - this.y, target.x - this.x));

        if(angle < 0){
            angle += 360;
        }

        return new Float(angle);
    }



}
