package com.anton.ClassEnemy;

import com.anton.Player;

import java.util.HashMap;
import java.util.Map;

public class Skelet extends Player{
    private int initiative;
    private int armorclass;

    public Skelet(int KO) {
        HashMap<String,Integer[]> maptemp=new HashMap<>();
        maptemp.put("сломанный скирт", new Integer[]{0,6});
        maptemp.put("удар когтями", new Integer[]{1,5});
        maptemp.put("двойной удар когтями", new Integer[]{2,6});
        setWeapon(maptemp);

        setClassPlayer("Cкелет");
        setName("Скелет");
        setInitiative(6);
        setArmorclass(16);

        setStrength(15);
        setDexterity(14);
        setCostitution(0);
        setCharisma(12);
        setIntellegence(0);
        setWisdom(10);

        if (getStrength()>6){                                //Модификаторы
            setStrengthModify((getStrength()-10)/2);
        } else{
            setStrengthModify(0);
        }
        if (getDexterity()>6){
            setDexterityModify((getDexterity()-10)/2);
        } else{
            setDexterityModify(0);
        }
        if (getCostitution()>6){
            setContitutionModify((getCostitution()-10)/2);
        }
        else{
            setContitutionModify(0);
        }
        if (getIntellegence()>6){
            setIntellegenceModify((getIntellegence()-10)/2);
        }
        else{
            setIntellegenceModify(0);
        }
        if (getWisdom()>6){
            setWisdomModify((getWisdom()-10)/2);
        }
        else{
            setWisdomModify(0);
        }
        if (getCharisma()>6){
            setCharismaModify((getCharisma()-10)/2);
        }
        else{
            setCharismaModify(0);
        }

        setHealth(4);
        setHealthmax(getHealth());

        setBasicmodificatorattack((int)KO*3/4);
        setAttackmodificator(getStrengthModify()+getBasicmodificatorattack());

        setDefense(10+getDexterityModify());
        setWeapondamage(6);
        setLife(true);
        setIDplayer(false);
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getArmorclass() {
        return armorclass;
    }

    public void setArmorclass(int armorclass) {
        this.armorclass = armorclass;
    }

}
