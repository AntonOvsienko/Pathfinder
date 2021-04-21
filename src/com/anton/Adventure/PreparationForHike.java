package com.anton.Adventure;

import com.anton.FightAlgorithm;
import com.anton.Inventory.Inventory;
import com.anton.Location.Shop;
import com.anton.Player;
import com.anton.Routine.DataInput;
import com.anton.Routine.Equip;
import com.anton.Visual;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class PreparationForHike {
    Output output;
    Input input;

    public static void Preparation(Player player) throws InterruptedException, FileNotFoundException {
        int pointer = 0;
        LinkedList<String> listAdventure=new LinkedList<String>();
        Output output;
        Input input;
        Thread thrd1;
        Thread thrd2;
        ReentrantLock locker=new ReentrantLock();


        while(true){
            System.out.println("Выберите действие:");
            System.out.println("1.Посмотреть инвентарь");
            System.out.println("2.Зайти в лавку");
            System.out.println("3.В путь");
            pointer = DataInput.InputInteger();
            if (pointer == 1){
                Visual.MyInventar(player);
                Equip.Equipment(player);
                }else if (pointer == 2){
                Shop.ShopChoice(player);
                }else if (pointer == 3){
                    break;
            }
        }

        while(true){
            System.out.println("Выберите сложность:");
            System.out.println("1.Легкая прогулка");
            System.out.println("2.Серьёзное превозмогание");
            System.out.println("3.Вернуться к подготовке");
            pointer = DataInput.InputInteger();
            if (pointer == 1){
                output=new Output(player,listAdventure,100);
                input=new Input(player,listAdventure,100);
                thrd1 = new Thread(input);
                thrd2 = new Thread(output);

                thrd1.start();
                thrd2.start();

                thrd1.join();
                thrd2.join();

                break;
            }else if (pointer == 2){
            }else if (pointer == 3){
                Preparation(player);
            }
        }
    }
}

class Output implements Runnable {
    Player player;
    LinkedList<String> listAdventure;
    int way;

    Output(Player player, LinkedList<String> listAdventure, int way) {
        this.player = player;
        this.listAdventure = listAdventure;
        this.way = way;
    }

    public void Output() {
        double dangerlabel = 0;
        Scanner scanner = new Scanner(System.in);
        String reflaction;

        synchronized (listAdventure){
        for (int i = 0; i < way; i++) {
            while (listAdventure.size() == 0) {
                System.out.println("Поток вывода остановлен");
                try {
                    listAdventure.wait(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            reflaction = listAdventure.pollFirst();
            System.out.println("Поток вывода включён");
            if (i % 10 == 0) {
                player.Heals();
            }
            if (reflaction.equalsIgnoreCase("Положительное")) {
                System.out.println((i + 1) + "/" + way);
                System.out.println("Положительное действо");
//                scanner.nextLine();
            } else if (reflaction.equalsIgnoreCase("Отрицательное")) {
                System.out.println((i + 1) + "/" + way);
                System.out.println("Отрицательное действо");
                //FightAlgorithm.Fight(player,EnemyList.List(dangerlabel,player));
                dangerlabel *= 0.25;
//                scanner.nextLine();
            } else if (reflaction.equalsIgnoreCase("Босс")) {
                System.out.println((i + 1) + "/" + way);
                System.out.println("Босс");
//                scanner.nextLine();
            }
//            for (int с=0;с<30;с++){
//                System.out.println();
//            }
            System.out.println((i + 1) + "/" + way + " Уровень угрозы-" + dangerlabel);
            dangerlabel += (i * 0.05);
            listAdventure.notify();
        }
        }
    }

    @Override
    public void run() {
        Output();
    }
}
class Input implements Runnable{
    Player player;
    LinkedList<String> listAdventure;
    int way;
    Random random=new Random();
    int counter=0;
    double positive=5;
    double negative=10;
    double free=85;
    double tempcell=0;
    double modifikator=0;


    Input (Player player, LinkedList<String> listAdventure,int way){
    this.player=player;
    this.listAdventure=listAdventure;
    this.way=way;

    }

    public void Lvl() {
        synchronized (listAdventure) {
            for (int i = 0; i < way; i++) {
                while (listAdventure.size() > 5) {
                    System.out.println("Поток ввода отключён");
                    try {
                        listAdventure.wait(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Поток ввода включён");
                counter = random.nextInt(100) + 1;
                if (i == 50) {
                    listAdventure.add("Отдых");
                } else if (i == 99) {
                    listAdventure.add("Босс");
                } else if (i == 149) {
                    listAdventure.add("Босс");
                } else {
                    if (counter <= positive) {
                        listAdventure.add("Положительное");
                        tempcell = (positive * 0.8);
                        positive -= tempcell;
                        negative += (tempcell / 2);
                        free += (tempcell / 2);
                    } else if (counter > positive && counter < (negative + positive)) {
                        listAdventure.add("Отрицательное");
                        tempcell = (negative * 0.4);
                        negative -= tempcell;
                        positive += (tempcell / 2);
                        free += (tempcell / 2);
                    } else if (counter >= (negative + positive)) {
                        listAdventure.add("Нейтральное");
                        tempcell = (free * 0.2);
                        free -= free;
                        negative += (tempcell / 2);
                        positive += (tempcell / 2);
                    }
                }
                listAdventure.notify();
            }
        }
    }
    @Override
    public void run() {
            Lvl();
    }
}

