package com.anton.Inventory;

import java.util.HashMap;

public class Weapon extends Inventory {


    public Weapon(String name, int cost, double weight, int damage, String type, int crit, int amount) {
        super(name, cost, weight, damage, type, crit, amount);
    }

    public static HashMap<String,Weapon> weapon =new HashMap<>(){{
        put("1",new Weapon("Кинжал",2000,1,4,"Одноручное",
                19,1));
        put("2",new Weapon("Серп",6000,2,6,"Одноручное",
                20,1));
        put("3",new Weapon("Рапира",20000,2,6,"Полуторное",
                18,1));
        }
    };
    @Override
    public String toString() {
        return "Оружие(" + getName() +
                ", вес-" + getWeight()+
                ", стоимость-" + getCost() +
                ", урон-" + getDamage() +
                ", критический-" + getCrit() +
                ", кол-во-" + getAmount() +
                ")\n";
    }
}


