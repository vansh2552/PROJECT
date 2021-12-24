package sample;

import java.io.Serializable;

public class user /*implements Serializable*/{
    private String name;
    private int currentPosition=0;
    private int restartCount=0;
    public user(String name){
        this.name=name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public int getRestartCount() {
        return restartCount;
    }

    public void setRestartCount(int restartCount) {
        this.restartCount = restartCount;
    }
}
