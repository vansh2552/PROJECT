package sample;

public abstract class GameObjects {
    private float[] position;
    public GameObjects(float x,float y){
        position=new float[2];
        position[0]=x;
        position[1]=y;
    }
    public GameObjects(float [] p_arr){
        this.position=p_arr;
    }
    public abstract void if_collides(GameObjects hero);
    //public abstract void display(AnchorPane gameAnchor);

    public float[] getPosition() {
        return position;
    }
    public void setX(float x) {
        this.position[0] = x;
    }

    public void setY(float y) {
        this.position[1] = y;
    }
    public void set_Position(float x,float y) {
        this.position[0] = x;
        this.position[1] = y;
    }
    public void setPosition(float[] position) {
        this.position = position;
    }

}
