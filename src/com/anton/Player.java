package com.anton;

import java.util.HashMap;
import java.util.Random;

public class Player {
    private boolean life;
    private String name;
    private String classPlayer;          //Класс игрока
    private int strength;                //Сила
    private int strengthModify;          //Модификтор силы
    private int dexterity ;              //Ловкость
    private int dexterityModify;         //Модификатор ловкости
    private int costitution;             //Вынословисть
    private int contitutionModify;       //Модификатор выносливости
    private int intellegence;            //Интеллект
    private int intellegenceModify;      //Модификатор интеллекта
    private int wisdom;                  //Мудрость
    private int wisdomModify;            //Модификатор Мудрости
    private int charisma;                //Харизма
    private int charismaModify;          //Модификатор харизмы
    private int health;                  //Здоровье
    private int healthmax;               //Здоровье максимальное
    private int weapondamage;            //максимальный урон оружием
    private int attackmodificator;       //модификатор урон
    private int basicmodificatorattack;  //базовый модификатор атаки
    private int defense;                 //параметр защиты
    private boolean IDplayer;                 //состояние игрок(true)-враг(false)
    private HashMap<String, Integer[]> weapon;  //виды действий атаки


    @Override
    public String toString() {
        return  classPlayer + " " + name  + " с характеристиками"+
                ": Сил " + strength +
                ", Лов " + dexterity +
                ", Вын " + costitution +
                ", Инт " + intellegence +
                ", Муд " + wisdom +
                ", Хар " + charisma +
                ", Здоровье " + health;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrengthModify() {
        return strengthModify;
    }

    public void setStrengthModify(int strengthModify) {
        this.strengthModify = strengthModify;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getDexterityModify() {
        return dexterityModify;
    }

    public void setDexterityModify(int dexterityModify) {
        this.dexterityModify = dexterityModify;
    }

    public int getCostitution() {
        return costitution;
    }

    public void setCostitution(int costitution) {
        this.costitution = costitution;
    }

    public int getContitutionModify() {
        return contitutionModify;
    }

    public void setContitutionModify(int contitutionModify) {
        this.contitutionModify = contitutionModify;
    }

    public int getIntellegence() {
        return intellegence;
    }

    public void setIntellegence(int intellegence) {
        this.intellegence = intellegence;
    }

    public int getIntellegenceModify() {
        return intellegenceModify;
    }

    public void setIntellegenceModify(int intellegenceModify) {
        this.intellegenceModify = intellegenceModify;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getWisdomModify() {
        return wisdomModify;
    }

    public void setWisdomModify(int wisdomModify) {
        this.wisdomModify = wisdomModify;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getCharismaModify() {
        return charismaModify;
    }

    public void setCharismaModify(int charismaModify) {
        this.charismaModify = charismaModify;
    }

    public String getClassPlayer() {
        return classPlayer;
    }

    public void setClassPlayer(String classPlayer) {
        this.classPlayer = classPlayer;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackmodificator() {
        return attackmodificator;
    }

    public void setAttackmodificator(int attackmodificator) {
        this.attackmodificator = attackmodificator;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealthmax() {
        return healthmax;
    }

    public void setHealthmax(int healthmax) {
        this.healthmax = healthmax;
    }

    public int getWeapondamage() {
        return weapondamage;
    }

    public void setWeapondamage(int weapondamage) {
        this.weapondamage = weapondamage;
    }

    public int getBasicmodificatorattack() {
        return basicmodificatorattack;
    }

    public void setBasicmodificatorattack(int basicmodificatorattack) {
        this.basicmodificatorattack = basicmodificatorattack;
    }

    public boolean isIDplayer() {
        return IDplayer;
    }

    public void setIDplayer(boolean IDplayer) {
        this.IDplayer = IDplayer;
    }

    public boolean isLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }

    public HashMap<String, Integer[]> getWeapon() {
        return weapon;
    }

    public void setWeapon(HashMap<String, Integer[]> weapon) {
        this.weapon = weapon;
    }
}
