package org.example;
import java.util.Random;
import java.util.Scanner;

public class Monsters {

    public boolean secondlife(int level){
        Random random1 = new Random();
        Scanner input1 = new Scanner(System.in);
        int a = random1.nextInt(5*level + 1);
        int b = random1.nextInt(5*level+1);
        int trueanswer = a*a + b*b;
        System.out.println("твое хп < 1 но, игра дает тебе последний шанс, если решишь задачу твое хп станет 1 задача: в п/у треугольнике катеты равны " + a + " и " + b + " чему равен квадрат гипотенузы");
        int inputanswer = input1.nextInt();
        if (inputanswer == trueanswer) {
            System.out.println("верно");
            return true;
        } else {
            System.out.println("не верно  ");

            return false;
        }
    }



    public boolean taskmonsters (int level){
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
class BigMonsters extends Monsters {
    @Override

    public boolean taskmonsters(int level) {
        Random random = new Random();
        int x = random.nextInt(15*level);
        int y = random.nextInt(10*level);
        int z = random.nextInt(20*level);
        int ans = x * y - z;
        System.out.println("Реши пример: " + x + " * " + y + " - " + z + " = ?");
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        if (answer == ans) {
            System.out.println("верно");
            return true;
        } else {
            System.out.println("не верно");
            return false;
        }
    }
}