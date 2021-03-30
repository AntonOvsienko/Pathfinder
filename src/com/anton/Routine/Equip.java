package com.anton.Routine;

import com.anton.Inventory.Inventory;
import com.anton.Player;

import java.util.ArrayList;
import java.util.List;

public class Equip {

    public static void StartEquipment(Player player){
        List<Inventory> lefthand=new ArrayList<>();
        List<Inventory> righthand=new ArrayList<>();
        List<Inventory> fullequpment=new ArrayList<>();

        for (Inventory x:player.getPersonthings())
            for (int i=0;i<player.getTypeweapon().size();i++) {
                if (x.getType().equals(player.getTypeweapon().get(i)))
                    lefthand.add(x);
            }

        for (Inventory x:player.getPersonthings())
            for (int i=0;i<player.getTypearmor().size();i++) {
                if (x.getType().equals(player.getTypearmor().get(i))&!x.getType().equals("Щит"))
                    fullequpment.add(x);
            }
        for (Inventory x:player.getPersonthings()) {
                if(player.isShield()&x.getType().equals("Щит"))
                    righthand.add(x);
            }
        while(true){
        System.out.println("Экипировка:");
        System.out.println("1.Левая рука:"+player.getWeaponequepleft().getName());
        System.out.println("2.Правая рука:"+player.getWeaponequepright().getName());
        System.out.println("3.Туловище:"+player.getArmorequep().getName());
        System.out.println("Что изменим?");
        if (DataInput.InputInteger()==1){
            for (int i=1;i< lefthand.size()+1;i++){
                System.out.println(i+lefthand.get(i).getName());
            }
            player.setWeaponequepleft(lefthand.get(DataInput.InputInteger(lefthand.size())));
        }
        }
    }
}
