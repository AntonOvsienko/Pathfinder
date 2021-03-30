package com.anton;

import com.anton.ClassPlayer.*;
import com.anton.Inventory.*;
import com.anton.Location.Shop;
import com.anton.Routine.Equip;

import java.io.IOException;

import static com.anton.Inventory.Armor.*;
import static com.anton.Inventory.Weapon.*;


public class Start {

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
//        Player men=PlayerInitialized.Initial();
//        List<Player> enemy = new ArrayList<>();
//        enemy.add(new Skelet(1));
//        enemy.add(new Skelet(1));
//        enemy.add(new Skelet(1));
//        FightAlgorithm.Fight(men,enemy);
          Player men=new Warior("Вася","Warior",15,15,15,15,15,15);
          System.out.println(men.getMoney());
          Shop.ArmorShop(men, armor);
          Shop.ArmorShop(men, armor);
          Shop.ArmorShop(men, armor);
          Shop.ArmorShop(men, armor);
          Shop.WeaponShop(men, weapon);
          Shop.WeaponShop(men, weapon);
          Equip.StartEquipment(men);
//          System.out.println(men.getPersonthings());
//          System.out.println(men.getMoney());
    }
}
