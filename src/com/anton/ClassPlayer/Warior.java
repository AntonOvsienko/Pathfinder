package com.anton.ClassPlayer;

import com.anton.Player;

public class Warior extends Player {

    public Warior(String name,String classPlayer,int strength,int dexterity,int costitution,int intellegence,
                  int wisdom,int charisma) {

        setName(name);                 //Общие данные
        setClassPlayer(classPlayer);   //Общие данные

        setStrength(strength);         //Характеристики
        setDefense(dexterity);         //Характеристики
        setCostitution(costitution);   //Характеристики
        setIntellegence(intellegence); //Характеристики
        setWisdom(wisdom);             //Характеристики
        setCharisma(charisma);         //Характеристики

        if (strength>6){                                //Модификаторы
            setStrengthModify((strength-10)/2);
        } else{
            setStrengthModify(0);
        }
        if (dexterity>6){
            setDexterityModify((dexterity-10)/2);
        } else{
            setDexterityModify(0);
        }
        if (costitution>6){
            setContitutionModify((costitution-10)/2);
        }
        else{
            setContitutionModify(0);
        }
        if (intellegence>6){
            setIntellegenceModify((intellegence-10)/2);
        }
        else{
            setIntellegenceModify(0);
        }
        if (wisdom>6){
            setWisdomModify((wisdom-10)/2);
        }
        else{
            setWisdomModify(0);
        }
        if (charisma>6){
            setCharismaModify((charisma-10)/2);
        }
        else{
            setCharismaModify(0);
        }

        setHealth(10+getContitutionModify());  //ХП текущая
        setHealthmax(getHealth());             //ХП максимальная

        setBasicmodificatorattack(3);                                          //(БМА) Базовый модификатор атаки
        setAttackmodificator(getStrengthModify()+getBasicmodificatorattack()); //Модификатор атаки в бою

        setDefense(10+getDexterityModify());      //защита в бою
        setWeapondamage(3);                       //максимальный урон оружием
        setLife(true);                            //состояние живой или мёртвый
        setIDplayer(true);                        //состояние свой-чужой

    }
}
