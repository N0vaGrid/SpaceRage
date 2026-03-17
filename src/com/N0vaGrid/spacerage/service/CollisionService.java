package com.N0vaGrid.spacerage.service;

import com.N0vaGrid.spacerage.model.Bullet;
import com.N0vaGrid.spacerage.model.EnemyPlane;
import com.N0vaGrid.spacerage.model.GameObject;
import com.N0vaGrid.spacerage.model.PlayerPlane;

import java.util.List;

public class CollisionService {

    public void check(
            PlayerPlane player,
            List<Bullet> bullets,
            List<EnemyPlane> enemies,
            ExplosionService explosionService,
            ScoreService scoreService
    ){

        // 子弹 vs 敌机
        for(int i=0;i<bullets.size();i++){

            Bullet b = bullets.get(i);

            for(int j=0;j<enemies.size();j++){

                EnemyPlane e = enemies.get(j);

                if(isCollide(b,e)){

                    explosionService.addExplosion(e.getX()+e.getWidth()/2, e.getY()+e.getHeight()/2);

                    scoreService.addScore(10);

                    bullets.remove(i);
                    enemies.remove(j);

                    i--;
                    break;
                }
            }
        }

        // 玩家 vs 敌机
        for(EnemyPlane e : enemies){

            if(isCollide(player,e)){
                explosionService.addExplosion(player.getX(), player.getY());
                player.setDead( true);
            }
        }

    }

    private boolean isCollide(GameObject a, GameObject b){

        return a.getX() < b.getX() + b.getWidth() &&
               a.getX() + a.getWidth() > b.getX() &&
               a.getY() < b.getY() + b.getHeight() &&
               a.getY() + a.getHeight() > b.getY();

    }

}