package com.anton.ClassEnemy;

import com.anton.Player;
import com.anton.TextBattle.HitSuccess;

import java.io.FileNotFoundException;
import java.util.*;

public class Skelet extends Player{
    private static Scanner scanner=new Scanner(System.in);
    Random random=new Random();

    public Skelet(int KO) {
        super(KO);

        HashMap<String,Integer[]> action=new HashMap<>();
        action.put("удар сломанным скиртом", new Integer[]{0,6});
        action.put("удар когтями", new Integer[]{1,5});
        action.put("двойной удар когтями", new Integer[]{2,6});
        List<String> surname= Arrays.asList("Cтарый","Ржавый","Фиолетовый","Зелёный","Трухлявый");

        setClassPlayer("Скелет");
        setName(surname.get(random.nextInt(surname.size()-1)) + " скелет");
        setWeapon(action);
        setInitiative(6+ random.nextInt(3)-1);
        setStrength(15+ random.nextInt(3)-1);
        setDexterity(14+ random.nextInt(3)-1);
        setCostitution(0);
        setCharisma(12+ random.nextInt(3)-1);
        setIntellegence(0);
        setWisdom(10+ random.nextInt(3)-1);

        setHealth(4);
        setHealthmax(getHealth());
        setBasicmodificatorattack((int)KO*3/4);
        setAttackmodificator(20+6);
        setDefense(16);
        setLife(true);
        setIDplayer(false);
    }

    public String Hit (List<Player> enemy,List<Player> all) throws FileNotFoundException {
        setDefenceonround(0);
        setAtackonround(0);
        int damage=0;
        String results="";
        int i=0;
        int tableID=random.nextInt(getWeapon().size());
        String[] tableIDstring=new String[getWeapon().size()];
        Integer[][] tableIDinteger=new Integer[getWeapon().size()][2];

        if (!enemy.get(0).isLife()){
            return "";
        }
        for (Map.Entry<String,Integer[]> x:getWeapon().entrySet()){
            tableIDstring[i]=x.getKey();
            tableIDinteger[i]=x.getValue();
            i++;
        }
        boolean run=true;
        int x=0;
        if (enemy.size()>1){
            x=random.nextInt(enemy.size());
        }else {
            x=0;
        }
        int attacknominal = tableIDinteger[tableID][1] - tableIDinteger[tableID][0];
        int attack = random.nextInt(20) + 1;
        if (attack == 20) {
            damage = random.nextInt(attacknominal) + 1 + tableIDinteger[tableID][0];
            int attackdop = random.nextInt(20) + 1;
            if (attackdop + getAttackmodificator(getBasicmodificatorattack()) > enemy.get(x).getDefense()) {
                damage += random.nextInt(attacknominal) + 1 + tableIDinteger[tableID][0];
            }
            enemy.get(x).setHealth(enemy.get(x).getHealth() - damage);
            results=(getName() + " наносит критический урон " + enemy.get(x).getName().toLowerCase() + " на " + damage);
        } else if ((attack + getAttackmodificator(getBasicmodificatorattack())) > enemy.get(x).getDefense()){
            damage+=random.nextInt(attacknominal) + 1 + tableIDinteger[tableID][0];
            enemy.get(x).setHealth(enemy.get(x).getHealth()-damage);
            results=(getName() + " " + tableIDstring[tableID] + " на " + damage);
        } else {
            results=enemy.get(x).getName()+ " " + HitSuccess.nohit();
        }
        if (enemy.get(x).getHealth()<=0){
            enemy.get(x).setHealth(0);
            enemy.get(x).setLife(false);
            results+=" и " + enemy.get(x).getName().toLowerCase() +  " был убит";
        }
        return results;
    }

}
