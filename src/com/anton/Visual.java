package com.anton;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Visual {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    public static void visual(){
        System.out.println("-------------------------------------------");
    }
    public static void battle1vs1(Player player1,Player player2){

        System.out.println("--------------------------------");
        System.out.printf("Здоровье:%2s/%-2s |  Здоровье:%2s/%-2s\n",player1.getHealth(),player1.getHealthmax(),player2.getHealth(),player2.getHealthmax());
        System.out.printf("Мод.атак:%2s    |  Мод.атак:%2s\n",player1.getAttackmodificator(),player2.getAttackmodificator());
        System.out.printf("Защита:  %2s    |  Защита:  %2s\n",player1.getDefense(),player2.getDefense());


    }
    public static void health1vs1(Player player1,Player player2){
        System.out.printf("%-10s        |     %-10s\n",player1.getName(),player2.getName());
        System.out.printf("Здоровье:%2d/%-2d    |     Здоровье:%2d/%-2d\n",player1.getHealth(),player1.getHealthmax(),player2.getHealth(),player2.getHealthmax());
    }
    public static void BattleVisual (List<Player> player){

        Collections.sort(player,IDComparator);
        for (int i=0;i< player.size();i++){
            if (player.get(i).isIDplayer()) {
                System.out.print(GREEN);
                System.out.print("\u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557");
                System.out.print(RESET);
            } else{
                System.out.print(RED);
                System.out.print("    \u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                    "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                    "\u2550\u2550\u2557");
                System.out.print(RESET);
            }
        }
        System.out.println("");
        for (int i=0;i< player.size();i++){
            if (player.get(i).isIDplayer()) {
                System.out.print(GREEN);
                System.out.printf("\u2551 %-14s \u2551",player.get(i).getName());
                System.out.print(RESET);
            } else{
                System.out.print(RED);
                System.out.printf("    \u2551 %-20s\u2551",player.get(i).getName());
                System.out.print(RESET);
            }
        }
        System.out.println("");
        for (int i=0;i< player.size();i++){
            if (player.get(i).isIDplayer()) {
                System.out.print(GREEN);
                System.out.print("\u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                "\u2550\u2550\u2550\u2550\u2550\u2563");
                System.out.print(RESET);
            } else{
                System.out.print(RED);
                System.out.print("    \u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                    "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563");
                System.out.print(RESET);
            }
        }
        System.out.println("");
        for (int i=0;i< player.size();i++){
            if (player.get(i).isIDplayer()) {
                System.out.print(GREEN);
                System.out.printf("\u2551 Health:%2d/%-4d \u2551",player.get(i).getHealth(),player.get(i).getHealthmax());
                System.out.print(RESET);
            } else{
                System.out.print(RED);
                System.out.printf("    \u2551 Health:%2d/%-10d\u2551",player.get(i).getHealth(),player.get(i).getHealthmax());
                System.out.print(RESET);
            }
        }
        System.out.println("");
        for (int i=0;i< player.size();i++){
            if (player.get(i).isIDplayer()) {
                System.out.print(GREEN);
                System.out.printf("\u2551 Атака макс:%-3d \u2551",player.get(i).getAttackmodificator()+20);
                System.out.print(RESET);
            } else{
                System.out.print(RED);
                System.out.printf("    \u2551 Атака макс:%-9d\u2551",player.get(i).getAttackmodificator()+20);
                System.out.print(RESET);
            }
        }
        System.out.println("");
        for (int i=0;i< player.size();i++){
            if (player.get(i).isIDplayer()) {
                System.out.print(GREEN);
                System.out.printf("\u2551 Защита:%-3d     \u2551",player.get(i).getDefense());
                System.out.print(RESET);
            } else{
                System.out.print(RED);
                System.out.printf("    \u2551 Защита:%-8d     \u2551",player.get(i).getDefense());
                System.out.print(RESET);
            }
        }
        System.out.println("");
        for (int i=0;i< player.size();i++){
            if (player.get(i).isIDplayer()) {
                System.out.print(GREEN);
                System.out.print("\u255A\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255D");
                System.out.print(RESET);
            } else{
                System.out.print(RED);
                System.out.print("    \u255A\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                        "\u2550\u2550\u255D");
                System.out.print(RESET);
            }
        }
        System.out.println();
    }

    public static Comparator<Player> IDComparator = new Comparator<Player>() {
        @Override
        public int compare(Player e1, Player e2) {
            if (e2.isIDplayer()){
                return 1;
            } else if (e1.isIDplayer()){
                return -1;
            }else{
                return 0;
            }
        }
    };
}
