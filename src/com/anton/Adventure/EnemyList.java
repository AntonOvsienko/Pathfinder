package com.anton.Adventure;

import com.anton.ClassEnemy.Skelet;
import com.anton.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EnemyList {
    public static List<Player> List(double danger,Player player){
        Random random=new Random();
        int KO= (int) (player.getLvl()+danger*0.1);
        List<Player> enemy=new ArrayList<>();
        List<Player> enemylvl1=new ArrayList<Player>(Arrays.asList(new Skelet()));
        while (true){
            if (player.getLvl()==1){
                while (true){
                    int i= random.nextInt(enemylvl1.size())+1;
                    if (KO==0){
                        return enemy;
                    } else if (i>KO){
                        continue;
                    }else{
                    enemy.add(new Skelet());
                    KO-=enemylvl1.get(i-1).getLvl();
                    }
                }
            }
        }
    }
}
