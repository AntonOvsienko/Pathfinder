package com.anton;

import com.anton.ClassEnemy.Skelet;
import com.anton.ClassPlayer.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        //Player men=PlayerInitialized.initialized();     //Создание персонажа
        List<Player> enemy2;
        Player enemy=new Skelet(1);
        System.out.println(Arrays.stream(enemy.getWeapon().get("двойной удар когтями")));
        for (Integer x:enemy.getWeapon().get("двойной удар когтями")){
            System.out.println(x);
        }

//        men=new Warior("Вася");
//        Player enemy=new Skelet(1);
//        Visual.visual();
//        FightAlgorithm.oneVSone(men,enemy);
//        if (!men.isLife()){
//            System.out.println(men.getName()+" упал замертво");
//        }
//        if (!enemy.isLife()){
//            System.out.println(enemy.getName()+" упал замертво");
//        }
    }
}
