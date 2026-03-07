package org.example;
import java.util.Random;
import java.util.Scanner;

public class Monsters {


    static boolean taskmonstermm (int level){
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
            System.out.println("не верно  ");

            return false;
        }
    }
}
