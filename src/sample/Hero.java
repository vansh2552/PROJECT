package sample;

public class Hero extends GameObjects{
    private int Coins=0;
    //private ArrayList<weapon> weapons;
    public Hero(float x, float y) {
        super(x, y);
        //this.weapons=new ArrayList<>();
    }

    @Override
    public void if_collides(GameObjects hero) {
        //empty
    }

}
