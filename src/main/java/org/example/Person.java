package org.example;

import org.example.Main;
import org.example.Monsters;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Person {
    private int level = 0;
    public void setLevel(int level){
        this.level = level;
    }

    Main main = new Main();
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

    public void check(String indicator){
        if (indicator == "ку"){
            this.hp += 1;
            System.out.println("вы пришли к кусту hp =  " + hp);
        }
        if (indicator == "мм"){
            Monsters monsters = new Monsters();
            if (monsters.taskmonsters(level) == false) {
                hp -= 1;
                System.out.println("твое hp " + hp);
            }
        }
        if (indicator == "Бм"){
            Monsters monsters = new BigMonsters();
            if (monsters.taskmonsters(level) == false){
                hp -= 1;
                System.out.println("твое hp " + hp);
            }
        }
    }
}
