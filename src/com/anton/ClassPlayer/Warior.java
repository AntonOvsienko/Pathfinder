package com.anton.ClassPlayer;

import com.anton.Player;

public class Warior extends Player {


    public Warior(String name) {
        super(name);
        setHealth(10+getContitutionModify());
        setHealthmax(getHealth());
        setClassPlayer("Воин");
        setBasicmodificatorattack(3);
        setAttackmodificator(getStrengthModify()+getBasicmodificatorattack());
        setDefense(10+getDexterityModify());
        setWeapondamage(3);
        setLife(true);
    }
    public String toString() {
        return  getName() + " " + getClassPlayer() + " с характеристиками"+
                "\nСил: " + getStrength() +
                "\nЛов: " + getDexterity() +
                "\nВын: " + getCostitution() +
                "\nИнт: " + getIntellegence() +
                "\nМуд: " + getWisdom() +
                "\nХар: " + getCharisma() +
                "\nЗдоровье: " + getHealth()+"/"+getHealthmax();

    }

}
