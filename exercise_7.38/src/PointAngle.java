import java.util.Comparator;

/**
 * Created by rubatharisan on 21/11/2016.
 */
public class PointAngle<A, P> {
    private A angle;
    private P point;


    public PointAngle(A angle, P point){
        this.angle = angle;
        this.point = point;
    }


    public A getAngle(){
        return this.angle;
    }

    public P getPoint(){
        return this.point;
    }

}
