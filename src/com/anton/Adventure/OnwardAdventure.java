package com.anton.Adventure;

import com.anton.FightAlgorithm;
import com.anton.Player;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class OnwardAdventure {
    public static void Onward(Player player, List<String> adventure) throws InterruptedException, FileNotFoundException {
        double dangerlabel=0;
        Scanner scanner=new Scanner(System.in);
        for (int i=0;i< adventure.size();i++){
            if (i%10==0){
                player.Heals();
            }
            if (adventure.get(i).equalsIgnoreCase("Положительное")){
                System.out.println((i+1)+"/"+ adventure.size());
                System.out.println("Положительное действо");
                scanner.nextLine();
            }else if (adventure.get(i).equalsIgnoreCase("Отрицательное")){
                System.out.println((i+1)+"/"+ adventure.size());
                System.out.println("Отрицательное действо");
                FightAlgorithm.Fight(player,EnemyList.List(dangerlabel,player));
                dangerlabel*=0.5;
                scanner.nextLine();
            }else if (adventure.get(i).equalsIgnoreCase("Босс")) {
                System.out.println((i+1)+"/"+ adventure.size());
                System.out.println("Босс");
                scanner.nextLine();
            }
            for (int с=0;с<30;с++){
                System.out.println();
            }
            System.out.println((i+1)+"/"+ adventure.size()+ " Уровень угрозы-"+dangerlabel);
            TimeUnit.MILLISECONDS.sleep(500);
            dangerlabel+=(i*0.05);
        }
    }

}
