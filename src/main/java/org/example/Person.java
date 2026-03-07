package org.example;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Person {
    Random random = new Random();
    private int hp = 3;
    private int x = 1 + random.nextInt(5);
    private  int y = 1;

    public int getHp() {
        return hp;
    }
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean moveCorrect (int x, int y){
        return (((getX() == x) && (abs(getY()- y) == 1)) || (getY() == y) && (abs(getX()-x) == 1));
    }
    void move (int x, int y){
        setX(x);
        setY(y);
    }
}
