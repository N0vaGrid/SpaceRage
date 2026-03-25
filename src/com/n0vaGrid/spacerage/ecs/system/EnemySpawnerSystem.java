package com.n0vaGrid.spacerage.ecs.system;

import com.n0vaGrid.spacerage.ecs.component.ComponentManager;
import com.n0vaGrid.spacerage.ecs.entity.EntityFactory;
import com.n0vaGrid.spacerage.ecs.entity.EntityManager;

import java.util.Random;

public class EnemySpawnerSystem {

    private EntityFactory factory;
    private long lastSpawnTime = 0;

    private static final long SPAWN_INTERVAL = 2000; // 2秒

    private Random random = new Random();

    public EnemySpawnerSystem(EntityFactory factory){
        this.factory = factory;
    }

    public void update(ComponentManager cm ,EntityManager em){

        long now = System.currentTimeMillis();

        if(now - lastSpawnTime > SPAWN_INTERVAL){

            spawnEnemy(cm,em);

            lastSpawnTime = now;
        }
    }

    private void spawnEnemy(ComponentManager cm,EntityManager  em){

        int x = random.nextInt(700) + 50;

        factory.createEnemy();
    }

}