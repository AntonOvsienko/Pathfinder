package com.anton.Adventure;

import com.anton.Inventory.Inventory;
import com.anton.Location.Shop;
import com.anton.Player;
import com.anton.Routine.DataInput;
import com.anton.Routine.Equip;
import com.anton.Visual;

import java.io.FileNotFoundException;

public class PreparationForHike {
    public static void Preparation(Player player) throws InterruptedException, FileNotFoundException {
        int pointer = 0;

        while(true){
            System.out.println("Выберите действие:");
            System.out.println("1.Посмотреть инвентарь");
            System.out.println("2.Зайти в лавку");
            System.out.println("3.В путь");
            pointer = DataInput.InputInteger();
            if (pointer == 1){
                Visual.MyInventar(player);
                Equip.Equipment(player);
                }else if (pointer == 2){
                Shop.ShopChoice(player);
                }else if (pointer == 3){
                    break;
            }
        }
        while(true){
            System.out.println("Выберите сложность:");
            System.out.println("1.Легкая прогулка");
            System.out.println("2.Серьёзное превозмогание");
            System.out.println("3.Вернуться к подготовке");
            pointer = DataInput.InputInteger();
            if (pointer == 1){
                OnwardAdventure.Onward(player,CreatingAdventure.Lvl(100));
            }else if (pointer == 2){
                OnwardAdventure.Onward(player,CreatingAdventure.Lvl(150));
            }else if (pointer == 3){
                Preparation(player);
            }
        }
    }
}
