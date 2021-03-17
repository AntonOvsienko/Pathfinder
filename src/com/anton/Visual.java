package com.anton;

public class Visual {
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

}
