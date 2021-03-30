package com.anton.Location;

import com.anton.Routine.DataInput;
import com.anton.Inventory.*;
import com.anton.Player;
import com.anton.Routine.DeleteRepeatList;
import com.anton.Visual;

import java.util.HashMap;

public class Shop extends Inventory{
    public static void WeaponShop(Player player, HashMap<String,Weapon> weapon) {
        Visual.ShopWeaponVisual(weapon);
            while (true) {
                String x = DataInput.InputString().toLowerCase();
                int count = 0;
                for (HashMap.Entry<String, Weapon> entry : weapon.entrySet()) {
                    if (x.equals(entry.getKey())) {
                        if (!DeleteRepeatList.MergeList(player,entry.getValue().getName())){
                        player.getPersonthings().add(new Weapon(weapon.get(x).getName(),
                                weapon.get(x).getCost(),
                                weapon.get(x).getWeight(), weapon.get(x).getDamage(), weapon.get(x).getType(),
                                weapon.get(x).getCrit(), weapon.get(x).getAmount()));
                        }
                        player.setMoney(player.getMoney() - weapon.get(x).getCost());
                    } else {
                        count++;
                    }
                }
                if (count != weapon.size()) {
                    break;
                } else {
                    System.out.println("Введено неверное значение");
                }
            }
        }
    public static void ArmorShop(Player player, HashMap<String, Armor> armor) {
        Visual.ShopArmorVisual(armor);
        while (true) {
            String x = DataInput.InputString().toLowerCase();
            int count = 0;
            for (HashMap.Entry<String, Armor> entry : armor.entrySet()) {
                if (x.equalsIgnoreCase(entry.getKey())) {
                    if (!DeleteRepeatList.MergeList(player,entry.getValue().getName())){
                        player.getPersonthings().add(new Armor(armor.get(x).getName(),
                                armor.get(x).getCost(),
                                armor.get(x).getWeight(), armor.get(x).getType(),
                                armor.get(x).getAmount(), armor.get(x).getBonusdefencearmor(),
                                armor.get(x).getDexteryboundarylimit(),armor.get(x).getFinestrengthdextery() ));
                    }
                    player.setMoney(player.getMoney() - armor.get(x).getCost());
                } else {
                    count++;
                }
            }
            if (count != armor.size()) {
                break;
            } else {
                System.out.println("Введено неверное значение");
            }
        }
    }
}
