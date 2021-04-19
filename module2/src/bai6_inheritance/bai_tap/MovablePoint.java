package bai6_inheritance.bai_tap;

public class MovablePoint extends Point {
    private float xSpeed=0.0f;
    private float ySpeed=0.0f;

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return this.xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return this.ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed,float ySpeed){
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }
    public float[] getSpeed(){
        float  xy[]=new float[]{this.getxSpeed(),this.getySpeed()};
        return xy;
    }
    public MovablePoint move(){
        this.setX(this.getX()+xSpeed);
        this.setY(this.getY()+ySpeed);
        return this;
    }

    @Override
    public String toString() {
        return "MovablePoint " +
                "xSpeed=" + getxSpeed() +
                ", ySpeed=" + getySpeed() +
                " which is a subclass of "+
                super.toString();
    }
}
