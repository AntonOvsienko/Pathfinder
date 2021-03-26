package com.anton.ClassPlayer;

import com.anton.DataInput;
import com.anton.Player;
import com.anton.PlayerInitialized;
import com.anton.TextBattle.HitSuccess;
import com.anton.Visual;

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
        setTablemodificatorattack(new int[][]{{1},{2},{3},{4},{5},{6,1},{7,2},{8,3},
                {9,4},{10,5},{11,6,1},{12,7,2},{13,8,3},{14,9,4},{15,10,5},{16,11,6,1},
                {17,12,7,2},{18,13,8,3},{19,14,9,4},{20,15,10,5}});
        setBasehealth(10);                                  //Базовое здоровье
        setHealth(getBasehealth()+getContitutionModify());  //ХП текущая
        setHealthmax(getHealth());                          //ХП максимальная
        setLvl(1);
        setBasicmodificatorattack(1);             //(БМА) Базовый модификатор атаки

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

    public String Hit (List<Player> enemy,List<Player> all) throws FileNotFoundException {
        setDefenceonround(0);
        setAtackonround(0);
        String results="";
        boolean run=true;
        int x=0;
        while (true){
        System.out.println("Выберите действие в бою");
        System.out.println("1.Полная атака");
        System.out.println("2.Осторожная атака");
        System.out.println("3.Глухая оборона+отхил(15%) без атаки");
        int choice=DataInput.InputInteger();
        if (choice==1){
            Visual.BattleVisual(all);
            break;
        } else if (choice==2){
            setDefenceonround(4);
            setAtackonround(-4);
            Visual.BattleVisual(all);
            break;
            }else if (choice == 3){
                setDefenceonround(6);
                setHealth(getHealth()+(int)Math.round((double)getHealthmax()*15/100));
                    if (getHealth()>getHealthmax()){
                      setHealth(getHealthmax());
                }
                    return getName() + " стоит в глухой защите";
            }else{
            System.out.println("Цифра вне диапазона");
        }
    }
        for(int z=0;z<getTablemodificatorattack()[getLvl()-1].length;z++){
            int atmodificator=getTablemodificatorattack()[getLvl()-1][z];
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
            if (attackdop+getAttackmodificator(atmodificator) > enemy.get(x).getDefense()) {
                damage += random.nextInt(getWeapondamage())+getStrengthModify();
            }
            enemy.get(x).setHealth(enemy.get(x).getHealth() - damage);
            results=(getName()+" наносит критический урон "+ enemy.get(x).getName().toLowerCase());
        } else if ((attack+getAttackmodificator(atmodificator))>enemy.get(x).getDefense()){
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
        System.out.println("Какую из характеристик увеличить на + 1");
        charactresLvlUp(1);
        }
    }


}
