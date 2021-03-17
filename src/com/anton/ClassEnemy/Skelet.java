package com.anton.ClassEnemy;

import com.anton.Player;

import java.util.Random;

public class Skelet extends Player{
    private Random random=new Random();
    public Skelet(int KO) {
        setClassPlayer("Cкелет");
        setName("Скелет");
        setHealth(random.nextInt(8) + 1 + getCharismaModify());
        setHealthmax(getHealth());
        setStrength(15);
        setDexterity(14);
        setCharisma(12);
        setIntellegence(9);
        setWisdom(10);
        setBasicmodificatorattack((int)KO*3/4);
        setAttackmodificator(getStrengthModify()+getBasicmodificatorattack());
        setDefense(10+getDexterityModify());
        setWeapondamage(6);
        setLife(true);
    }
    public String toString() {
        return  getClassPlayer() + " с характеристиками"+
                "\nСила: " + getStrength() +
                "\nЛовкость: " + getDexterity() +
                "\nВыносливость: " + getCostitution() +
                "\nИнтеллект: " + getIntellegence() +
                "\nМудрость: " + getWisdom() +
                "\nХаризма: " + getCharisma() +
                "\nЗдоровье: " + getHealth();
    }
}
