package com.anton;

import com.anton.ClassEnemy.Skelet;
import com.anton.ClassPlayer.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Start {

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        Player men=PlayerInitialized.Initial();
        List<Player> enemy = new ArrayList<>();
        enemy.add(new Skelet(1));
        enemy.add(new Skelet(1));
        enemy.add(new Skelet(1));
        FightAlgorithm.Fight(men,enemy);
    }
}
