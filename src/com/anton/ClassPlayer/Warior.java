package com.anton.ClassPlayer;

import com.anton.Player;
import com.anton.PlayerInitialized;
import com.anton.Visual;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

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
        setLvl(1);
        setExptable(new ArrayList<>(Arrays.asList(0,2000,5000,9000,15000,23000,35000,51000,75000,105000,
                            155000,220000,315000,445000,635000,895000,1350000,1800000,
                            2550000,3600000)));   //список опыта
        setExperience(getExptable().get(0));      //начальный опыт
        setExperiencemax(getExptable().get(1));   //опыт следующего уровня
    }

    public static Warior initialized() throws IOException, ClassNotFoundException {
        boolean exit;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите имя персонажа");
        String name=scanner.nextLine();
        do{
            exit=true;

            System.out.println("Выбрать созданного персонажа (1), с выбранными характеристиками (2) или сохранённого (3)");
            int start=scanner.nextInt();

            switch (start){
                case 1:
                    break;
                case 2:
                    int[] character= PlayerInitialized.character();
                    Warior men=new Warior(name,"Воин",character[0],character[1],character[2],character[3],character[4],
                    character[5]);
                    return men;
                case 3:
                    ObjectInputStream ois=new ObjectInputStream(new FileInputStream("PersonCharact.bin"));
                    int[] character2=(int[]) ois.readObject();
                    Warior men2 = new Warior(name, "Воин", character2[0], character2[1], character2[2], character2[3], character2[4],
                            character2[5]);
                    ois.close();
                    return men2;
                default:
                    System.out.println("Неверное значение введите ещё раз");
            }
        }while(exit);
        return null;
    }

    public void Hello(){
        System.out.println("Hello");
    }

    public void Fight (Player enemy){
        Random random=new Random();
        int damage=0;
        int attack=random.nextInt(20)+1;
        Visual.visual();
//        System.out.println(get+" наносит удар "+ player2.getName());
//
//        System.out.println("Бросок");
//        System.out.println("Кубик-"+attack);
//        System.out.println(player1.getName()+" "+(player1.getAttackmodificator()+attack)+"/"+player2.getName()+
//                " "+player2.getDefense());
//        if (attack==20){
//            System.out.println("Гарантированое попадание");
//            damage=random.nextInt(player1.getWeapondamage());
//            int attackdop=random.nextInt(20)+1;
//            if (attackdop>player2.getDefense()){
//                damage+=random.nextInt(player1.getWeapondamage());
//                System.out.println("Прошёл критичный урон всего");
//            }
//            System.out.println(player1.getName()+ " нанёс урон "+ player2.getName() + " на "+ damage);
//            player2.setHealth(player2.getHealth()-damage);
//            return;
//        }
//        if (player1.getHealth()<=0){
//            player1.setLife(false);}
//        if (player2.getHealth()<=0){
//            player2.setLife(false);
//        }
   }

}
