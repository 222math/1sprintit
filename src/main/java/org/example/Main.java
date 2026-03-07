package org.example;

import java.net.SocketOption;
import java.util.Random;
import java.util.Scanner;


import static java.lang.Math.max;
import static java.lang.Math.min;

public class Main {
    static boolean taskmonster (int level){

        Random random1 = new Random();
        Scanner input1 = new Scanner(System.in);
        int a = random1.nextInt(1000*level + 1);
        int b = random1.nextInt(1000*level+1);
        int trueanswer = a + b;
        System.out.println("задача: " + (a) + "+" + b);
        int inputanswer = input1.nextInt();
        if (inputanswer == trueanswer) {
            System.out.println("верно");
            return true;
        } else {
            System.out.print("не верно  ");

            return false;
        }
    }

    public static void main(String[] args) {

        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int castley = 5;
        int castlex = 1 + random.nextInt(5);
        int size = 5;
        int level = 0;
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


        String leftBlock = " | ";
        String rightBlock = " |";
        String wall = " + —— + —— + —— + —— + —— + ";




        System.out.println("ты готов играть?");
        String answer = input.nextLine();
        if (2>1) { //потом_заменим на прповерку на да
            System.out.println("выбери уровень сложности");
            level = input.nextInt();
            System.out.println("твой уровень сложности " + level);
            for (int i = 0; i <= level+10; i++) {
                board[random.nextInt(5)][random.nextInt(5)] = "мм";
            }
        };
        if (2>1){ //потом_заменим на прповерку на да
            while (!(person.getX() == castlex && person.getY() == castley) && hp > 0){
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
                if (indicator.equals("реши задачу ")) {

                    if (taskmonster(level) == false) {
                        hp -= 1;
                    }
                    System.out.println("hp = " + hp);
                }



                int x = input.nextInt();
                int y = input.nextInt();
                if (person.moveCorrect(x, y)){
                    person.move(x , y);
                } else {
                    System.out.println("ход не коректный");
                }

                if ((board[person.getX()-1][person.getY()-1] == "  ")){
                    indicator = "это пустая клетка";
                } else {
                    indicator = "реши задачу ";
                }
                System.out.println(person.getX());
                System.out.println(person.getY());
            };
            if (hp > 0){
                System.out.println("молодец ты победил");
            } else {
                System.out.println("поражение");
            }
        };
    }
}