package com.anton;

import com.anton.ClassEnemy.*;
import com.anton.ClassPlayer.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        boolean exit;
        Player men;
        List<Player> enemy2;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Создать персонажа случайного(1) с выбранными характеристиками(2) или сохранённого(3)");
        do{
            exit=true;
            int start=scanner.nextInt();
            switch (start){
                case 1:
                    men=new Warior("Вася");
                    exit=false;
                    break;
                case 2:
                    int[] character=PlayerInitialized.character();
                    exit=false;
                    break;
                case 3:

                    break;
                default:
                    System.out.println("Неверное значение введите ещё раз");
                    }
            }while(exit);

        men=new Warior("Вася");
        Player enemy=new Skelet(1);
        Visual.visual();
        FightAlgorithm.oneVSone(men,enemy);
        if (!men.isLife()){
            System.out.println(men.getName()+" упал замертво");
        }
        if (!enemy.isLife()){
            System.out.println(enemy.getName()+" упал замертво");
        }
    }
}
