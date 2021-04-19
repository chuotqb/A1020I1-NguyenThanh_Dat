package bai6_inheritance.bai_tap;

public class Point3D extends Point2D {
    private float z=0.0f;

    public Point3D() {

    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {

        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x,float y,float z){
        super.setX(x);
        super.setY(y);
        this.z=z;
    }
    public float[] getXYZ(){
        float xyz[]=new float[]{this.getX(),this.getY(),this.getZ()};
        return xyz;
    }

    @Override
    public String toString() {
        return "Point3D" +
                 " which is a subclass of "
                + super.toString()+
                " z=" + getZ() ;
    }
}
