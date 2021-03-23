package com.anton;

import com.anton.ClassEnemy.*;
import java.util.ArrayList;
import java.util.List;

public class EnemyInitialized extends Player{
    private List<Player> enemy;

    public EnemyInitialized(){
        enemy.add(new Skelet(0));
        enemy.add(new Skelet(1));
    }

    public List<Player> getEnemy() {
        return enemy;
    }

    public void setEnemy(List<Player> enemy) {
        this.enemy = enemy;
    }
}

