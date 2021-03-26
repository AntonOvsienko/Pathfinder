package com.anton.ClassPlayer;

import com.anton.DataInput;
import com.anton.Player;
import com.anton.PlayerInitialized;
import com.anton.TextBattle.HitSuccess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class Warior extends Player {
    private static Scanner scanner=new Scanner(System.in);

    public Warior(String name,String classPlayer,int strength,int dexterity,int costitution,int intellegence,
                  int wisdom,int charisma) {

        super(name,classPlayer,strength,dexterity,costitution,intellegence,wisdom,charisma);
        setBasehealth(10);                                  //Базовое здоровье
        setHealth(getBasehealth()+getContitutionModify());  //ХП текущая
        setHealthmax(getHealth());                          //ХП максимальная

        setBasicmodificatorattack(3);             //(БМА) Базовый модификатор атаки

        setWeapondamage(3);                       //максимальный урон оружием
        setLife(true);                            //состояние живой или мёртвый
        setIDplayer(true);                        //состояние свой-чужой
        setLvl(1);                                //начальный лвл
        setExptable(new ArrayList<>(Arrays.asList(0,2000,5000,9000,15000,23000,35000,51000,75000,105000,
                            155000,220000,315000,445000,635000,895000,1350000,1800000,
                            2550000,3600000)));   //список опыта
        setExperience(getExptable().get(0));      //начальный опыт
        setExperiencemax(getExptable().get(1));   //опыт следующего уровня
        setInitiative(getDexterity());            //Инициатива;
    }

    public static Warior initialized(String name) throws IOException, ClassNotFoundException {
        Scanner scanner=new Scanner(System.in);
        boolean exit;
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

    public String Hit (List<Player> enemy) throws FileNotFoundException {
        setDefenceonround(0);
        setAtackonround(0);
        String results="";
        boolean run=true;
        int x=0;
        while (true){
        System.out.println("Выберите действие в бою");
        System.out.println("1.Полная атака");
        System.out.println("Выберите действие в бою");
        System.out.println("Выберите действие в бою");
        System.out.println("Выберите действие в бою");
        break;
        }

        if (enemy.size()>1){
            do {
                System.out.println(getName()+ " " +getHealth()+"/"+getHealthmax()+" выберите противника:");
                for (int i=0;i<enemy.size();i++){
                    System.out.println((i + 1) + "." + enemy.get(i).getName() + "-" + enemy.get(i).getHealth() + "/" + enemy.get(i).getHealthmax());
                }
                x= DataInput.InputInteger();
                if (x>enemy.size()) {
                    System.out.println("Невереное число, не более " + enemy.size());
                    continue;
                }
                x--;
                run=false;
                }while(run);
        }else {
            x=0;
        }
        Random random=new Random();
        int damage=0;
        int attack=random.nextInt(20)+1;
        if (attack==20) {
            damage = random.nextInt(getWeapondamage())+getStrengthModify();
            int attackdop = random.nextInt(20) + 1;
            if (attackdop+getAttackmodificator() > enemy.get(x).getDefense()) {
                damage += random.nextInt(getWeapondamage())+getStrengthModify();
            }
            enemy.get(x).setHealth(enemy.get(x).getHealth() - damage);
            results=(getName()+" наносит критический урон "+ enemy.get(x).getName());
        } else if ((attack+getAttackmodificator())>enemy.get(x).getDefense()){
            damage+=random.nextInt(getWeapondamage())+1+getStrengthModify();
            enemy.get(x).setHealth(enemy.get(x).getHealth()-damage);
            results=(getName()+ " " + HitSuccess.hit()+" на "+damage);
        } else {
            results=enemy.get(x).getName()+ " " + HitSuccess.nohit();
        }
        if (enemy.get(x).getHealth()<=0){
            enemy.get(x).setHealth(0);
            enemy.get(x).setLife(false);
            results+=" и "+ enemy.get(x).getName().toLowerCase() + " был убит";
        }
        return results;
    }

    public void LvlUp(int x){
        int remaningexp;
        for (int i=0;i>x;i++){
        if (getExperience()-getExperiencemax()>0){
            remaningexp=getExperience()-getExperiencemax();
        }else{
            remaningexp=0;
        }
        setLvl(getLvl()+1);
        setExperience(getExptable().get(getLvl()-1)+remaningexp);
        setExperiencemax(getExptable().get(getLvl()));
        System.out.println("Какой из навыков увеличить на +"+(2+getIntellegenceModify()));
        charactresLvlUp(2+getIntellegenceModify());
        }
    }


}
