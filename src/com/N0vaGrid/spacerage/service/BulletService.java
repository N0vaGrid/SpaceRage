package com.N0vaGrid.spacerage.service;

import com.N0vaGrid.spacerage.model.Bullet;
import com.N0vaGrid.spacerage.model.PlayerPlane;

import java.util.ArrayList;
import java.util.List;

public class BulletService {

    private List<Bullet> bullets = new ArrayList<>();

    private long lastShootTime = 0;

    public void shoot(PlayerPlane player){

        long current = System.currentTimeMillis();

        if(current - lastShootTime < 200){
            return;
        }

        lastShootTime = current;

        Bullet bullet = new Bullet(
                player.getX() + player.getWidth() / 2 ,
                player.getY() - player.getHeight() / 2
        );

        bullet.setX(bullet.getX() - bullet.getWidth() / 2);
        bullets.add(bullet);

    }

    public void update(){

        for(int i=0;i<bullets.size();i++){

            Bullet b = bullets.get(i);

            b.update();

            if(b.isOutOfScreen()){
                bullets.remove(i);
                i--;
            }
        }
    }

    public List<Bullet> getBullets(){
        return bullets;
    }

}
