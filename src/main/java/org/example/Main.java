package org.example;


import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void tutorial(){

        System.out.println("=====================================================");
        System.out.println("   ДОБРО ПОЖАЛОВАТЬ В ИГРУ 'ПОИСК ЗАМКА'!");
        System.out.println("=====================================================");
        System.out.println("Ты — отважный искатель приключений.");
        System.out.println("Где-то на этой карте размером 5x5 спрятан древний ЗАМОК (з).");
        System.out.println("Твоя цель — найти его и не погибнуть в пути.");
        System.out.println();
        System.out.println("********** КАК ИГРАТЬ? **********");
        System.out.println("1. Твой персонаж — это 'гг'.");
        System.out.println("2. Чтобы сделать ход, введи координаты X и Y (от 1 до 5).");
        System.out.println("   Ходить можно только по горизонтали или вертикали,");
        System.out.println("   на одну клетку за раз (по диагонали нельзя).");
        System.out.println();
        System.out.println("********** ЧТО ТЕБЯ ЖДЁТ НА КАРТЕ? **********");
        System.out.println("   'мм' — ОБЫЧНЫЙ МОНСТР. Реши простой пример на сложение.");
        System.out.println("   'Бм' — БОЛЬШОЙ МОНСТР. Тут пример посложнее: умножение и вычитание.");
        System.out.println("   'ку' — КУСТ. Отдых и восстановление сил: +1 к здоровью (hp).");
        System.out.println("   'xx' — ТАЙНА. Никогда не знаешь, что скрывает этот икс... c вероятностью 0.5 ничего, 0,05 Бм , 0.3 мм , 0.15 куст");
        System.out.println("   ' з' — ЗАМОК. Твоя цель!");
        System.out.println();
        System.out.println("********** ВАЖНО **********");
        System.out.println("У тебя есть 3 жизни (hp). Если они закончатся — ты проиграл.");
        System.out.println("За неправильный ответ в битве с монстром ты теряешь одну жизнь.");
        System.out.println("Будь внимателен и удачи!");
        System.out.println("=====================================================");
        System.out.println();

    } //туториал писал ии, а вероятность написанна не процентами потомучто по пределению условной вероятности это отношение благоприятных исходов ко всем следовательно от 0 до 1




    public static void main(String[] args) {

        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int castley = 5;
        int castlex = 1 + random.nextInt(5);
        int size = 5;



        String indicator = "начало";
        String[][] board = new String[size][size];
        for (int y = 1; y <= size; y++) {
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
        if (answer.equals("да")) { //потом_заменим на прповерку на да
            System.out.println("выбери уровень сложности");
            level = input.nextInt();
            person.setLevel(level);
            System.out.println("твой уровень сложности " + level);
            tutorial();

            for (int i = 0; i <= level+9; i++) {
                board[random.nextInt(size)][random.nextInt(size)] = "мм";
            }
            for (int i = 0; i <= 3; i++) {
                board[random.nextInt(size)][random.nextInt(size)] = "ку";
            }
            for (int i = 0; i <= 5; i++) {
                board[random.nextInt(size)][random.nextInt(size)] = "xx";
            }
            for (int i = 0; i <= level - 1; i++) {
                board[random.nextInt(size)][random.nextInt(size)] = "Бм";
            }
        };
        if (answer.equals("да")){ //потом_заменим на прповерку на да
            while (!(person.getX() == castlex && person.getY() == castley) && person.getHp() > 0){
                board[castlex-1][castley-1] = " з";
                board[person.getX()-1][person.getY()-1] = "гг";
                for (int y = size; y >= 1; y -= 1){
                    System.out.println(wall);
                    for (int x = 1; x <= size; x += 1){
                        System.out.print(leftBlock);
                        System.out.print(board[x-1][y-1]);
                    };
                    System.out.println(rightBlock);
                };
                System.out.println(wall);
                board[person.getX()-1][person.getY()-1] = "  ";
                System.out.println(indicator);
                person.check(indicator);
                if (person.getHp()<= 0 ){
                    break;
                }
                System.out.println("твое hp " + person.getHp());
                System.out.println("твои координаты " + person.getX() + " " + person.getY());
                System.out.println("введи новые координаты");
                //System.out.println("твои координаты " + person.getX() + " " + person.getY() +" что бы походить введи координаты клетки, ходить можно не более чем на 1 клетку, по диогонали нельзя");
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
            if (person.getHp() > 0){
                System.out.println("молодец ты победил");
            } else {
                System.out.println("поражение");
            }
        };
    }
}