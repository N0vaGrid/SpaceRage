package com.N0vaGrid.spacerage.service;

import com.N0vaGrid.spacerage.model.EnemyPlane;

import java.util.ArrayList;
import java.util.List;

public class EnemyService {

    private List<EnemyPlane> enemies = new ArrayList<>();

    private long lastSpawnTime = 0;

    public void update(){

        spawn();
        move();
    }

    private void spawn(){

        long current = System.currentTimeMillis();

        if(current - lastSpawnTime < 4000){
            return;
        }

        lastSpawnTime = current;

        int x = (int)(Math.random() * 400);

        enemies.add(new EnemyPlane(x,0));
    }

    private void move(){

        for(int i=0;i<enemies.size();i++){

            EnemyPlane e = enemies.get(i);

            e.update();

            if(e.isOutOfScreen(800)){
                enemies.remove(i);
                i--;
            }
        }
    }

    public List<EnemyPlane> getEnemies(){
        return enemies;
    }

}