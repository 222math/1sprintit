package org.example;

import java.net.SocketOption;
import java.util.Random;
import java.util.Scanner;


import static java.lang.Math.max;
import static java.lang.Math.min;

public class Main {




    public static void main(String[] args) {

        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int castley = 5;
        int castlex = 1 + random.nextInt(5);
        int size = 5;

        int secondlife = 0;
        int hp = 3;
        String indicator = "начало";
        String[][] board = new String[5][5];
        for (int y = 1; y <= 5; y++) {
            for (int x = 1; x <= 5; x++) {
                board[x-1][y-1] = "  ";
            }
        };

        Person person = new Person();
        Monsters monsters = new Monsters();

        String leftBlock = " | ";
        String rightBlock = " |";
        String wall = " + —— + —— + —— + —— + —— + ";
        int level = 0;



        System.out.println("ты готов играть?");
        String answer = input.nextLine();
        if (2>1) { //потом_заменим на прповерку на да
            System.out.println("выбери уровень сложности");
            level = input.nextInt();
            person.setLevel(level);
            System.out.println("твой уровень сложности " + level);
            for (int i = 0; i <= level+10; i++) {
                board[random.nextInt(5)][random.nextInt(5)] = "мм";
            }
            for (int i = 0; i <= 3; i++) {
                board[random.nextInt(5)][random.nextInt(5)] = "ку";
            }
            for (int i = 0; i <= 5; i++) {
                board[random.nextInt(5)][random.nextInt(5)] = "xx";
            }
            for (int i = 0; i <= 3; i++) {
                board[random.nextInt(5)][random.nextInt(5)] = "Бм";
            }
        };
        if (2>1){ //потом_заменим на прповерку на да
            while (!(person.getX() == castlex && person.getY() == castley) && person.getHp() > 0){
                board[castlex-1][castley-1] = " з";
                board[person.getX()-1][person.getY()-1] = "гг";
                for (int y = 5; y >= 1; y -= 1){
                    System.out.println(wall);
                    for (int x = 1; x <= 5; x += 1){
                        System.out.print(leftBlock);
                        System.out.print(board[x-1][y-1]);
                    };
                    System.out.println(rightBlock);
                };
                System.out.println(wall);
                board[person.getX()-1][person.getY()-1] = "  ";
                System.out.println(indicator);
                person.check(indicator);


                System.out.println("твои координаты " + person.getX() + " " + person.getY() +" что бы походить введи координаты клетки, ходить можно не более чем на 1 клетку, по диогонали нельзя");
                int x = input.nextInt();
                int y = input.nextInt();
                if (person.moveCorrect(x, y)){
                    person.move(x , y);
                    System.out.println("ход корректный");
                } else {
                    System.out.println("ход не коректный");
                }

                indicator = board[person.getX()-1][person.getY()-1];
                if (indicator.equals("xx")){
                    int xx = random.nextInt(100);
                    if (xx <= 4){
                        indicator = "Бм";
                    }else if (xx <= 34){
                        indicator = "мм";
                    } else if (xx <= 49){
                        indicator = "ку";
                    } else{
                        indicator = "  ";
                    }

                }
            }
            if (hp > 0){
                System.out.println("молодец ты победил");
            } else {
                System.out.println("поражение");
            }
        };
    }
}