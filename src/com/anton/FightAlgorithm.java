package com.anton;

import com.anton.TextBattle.HitSuccess;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class FightAlgorithm {
    public static void oneVSone(Player player,Player enemy) throws FileNotFoundException, InterruptedException {
        boolean win=true;
        Player player1;
        Player player2;
        int initiation1=player.getDexterity();
        int initiation2=player.getDexterity();
        if (initiation1>initiation2){
            player1=player;
            player2=enemy;
        }else{
            player2=player;
            player1=enemy;
        }
        Visual.battle1vs1(player1,player2);
        System.out.println("Инициатива на стороне " + player1.getName());
        do{
            Visual.health1vs1(player1,player2);
            Player player3;
            battle(player1, player2);
            if (player1.getHealth()<=0||player2.getHealth()<=0){
                win=false;
            }else{
                player3=player1;
                player1=player2;
                player2=player3;
            }
        }while(win);
    }
    public static void battle (Player player1,Player player2) throws InterruptedException, FileNotFoundException {
        Random random=new Random();
        int damage=0;
        int attack=random.nextInt(20)+1;
        Visual.visual();
        System.out.println(player1.getName()+" наносит удар "+ player2.getName());
        for (int i=0;i<7;i++){
            System.out.print(7-i);
            TimeUnit.MILLISECONDS.sleep(250);
            System.out.print(".");
            TimeUnit.MILLISECONDS.sleep(250);
            System.out.print(".");
            TimeUnit.MILLISECONDS.sleep(250);
            System.out.print(".");
            TimeUnit.MILLISECONDS.sleep(250);
        }
        System.out.println("Бросок");
        System.out.println("Кубик-"+attack);
        System.out.println(player1.getName()+" "+(player1.getAttackmodificator()+attack)+"/"+player2.getName()+
                " "+player2.getDefense());
        if (attack==20){
            System.out.println("Гарантированое попадание");
            damage=random.nextInt(player1.getWeapondamage());
            int attackdop=random.nextInt(20)+1;
            if (attackdop>player2.getDefense()){
                damage+=random.nextInt(player1.getWeapondamage());
                System.out.println("Прошёл критичный урон всего");
            }
            System.out.println(player1.getName()+ " нанёс урон "+ player2.getName() + " на "+ damage);
            player2.setHealth(player2.getHealth()-damage);
            return;
        }

        if ((attack+player1.getAttackmodificator())>player2.getDefense()){
            damage+=random.nextInt(player1.getWeapondamage())+1;
            System.out.println(player1.getName()+ " " + HitSuccess.hit()+" на "+damage);
            player2.setHealth(player2.getHealth()-damage);
        } else {
            System.out.println(player2.getName()+ " " + HitSuccess.nohit());
        }
        if (player1.getHealth()<=0){
            player1.setLife(false);}
        if (player2.getHealth()<=0){
            player2.setLife(false);
        }
    }

}