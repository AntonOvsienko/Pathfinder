package com.anton;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class FightAlgorithm {

    public static void Fight(Player player, List<Player> enemy) throws FileNotFoundException {
        int isLifePlayer;
        int isLifeEnemy;
        int count = 0;
        List<Player> ListParticipation = new ArrayList<>();
        ListParticipation.addAll(enemy);
        ListParticipation.add(player);
        Collections.sort(ListParticipation, InitiativeComparator);
        while (true) {
            System.out.println("Раунд " + ++count);
            Visual.BattleVisual(ListParticipation);
            String[] textotals = new String[ListParticipation.size()];
            for (int i = 0; i < ListParticipation.size(); i++) {
                if (!ListParticipation.get(i).isLife()) {
                    textotals[i] = "";
                    continue;
                }
                textotals[i] = ListParticipation.get(i).Hit(ListOpponent(ListParticipation.get(i), ListParticipation), ListParticipation);
            }
            for (String x : textotals) {
                System.out.println(x);
            }
            for (int i = 0; i < ListParticipation.size(); i++) {
                if (!ListParticipation.get(i).isLife()) {
                    ListParticipation.remove(i);
                }
            }
            isLifePlayer = 0;
            isLifeEnemy = 0;
            for (Player x : ListParticipation) {
                if (x.isIDplayer()) {
                    isLifePlayer++;
                }
                if (!x.isIDplayer()) {
                    isLifeEnemy++;
                }

            }
            if (isLifePlayer == 0) {
                System.out.println("Вы проиграли");
                break;
            }
            if (isLifeEnemy == 0) {
                System.out.println("Вы выиграли");
                break;
            }
        }
    }

    public static Comparator<Player> InitiativeComparator = new Comparator<Player>() {
        @Override
        public int compare(Player e1, Player e2) {
            if (e1.getInitiative() < e2.getInitiative()) {
                return 1;
            } else if (e1.getInitiative() > e2.getInitiative()) {
                return -1;
            } else {
                return 0;
            }
        }
    };

    public static List<Player> ListOpponent(Player player, List<Player> list) {
        List<Player> opponent = new ArrayList<>();
        for (Player x : list) {
            if (player.isIDplayer() != x.isIDplayer()) {
                opponent.add(x);
            }
        }
        return opponent;
    }
}


