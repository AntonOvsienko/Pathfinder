package com.anton;

import com.anton.Adventure.CreatingAdventure;
import com.anton.Adventure.PreparationForHike;
import com.anton.ClassPlayer.*;
import com.anton.Inventory.*;
import com.anton.Location.Shop;
import com.anton.Routine.Equip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.anton.Inventory.Armor.*;
import static com.anton.Inventory.Weapon.*;


public class Start {

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
//      Player men=PlayerInitialized.Initial();
        List<Player> men = new ArrayList<>();
        PlayerInitialized.PartyInitial(men);
//      enemy.add(new Skelet(1));
//      enemy.add(new Skelet(1));
//      enemy.add(new Skelet(1));
//      FightAlgorithm.Fight(men,enemy);
        PreparationForHike.Preparation(men);

    }
}
