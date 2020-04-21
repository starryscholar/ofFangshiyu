package cn.edu.usts.game;

import java.io.Serializable;

/**
 * Created by 11616 on 2020/4/2.
 */

public class Computer implements Player,Serializable {
    private String name = "computer";
    private int score = 0;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int play(int i) {
        int x=0+(int)(Math.random()*2);
        return x;
    }
}
