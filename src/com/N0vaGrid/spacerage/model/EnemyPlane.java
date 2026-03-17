package com.N0vaGrid.spacerage.model;

import java.awt.Graphics;
import java.awt.Image;

import com.N0vaGrid.spacerage.util.ResourceManager;

public class EnemyPlane extends GameObject {

    private int speed = 1;

    private Image image;

    public EnemyPlane(int x,int y){

        this.x = x;
        this.y = y;

        this.image = ResourceManager.ENEMY; // 先用玩家图，后面可换enemy.png

        this.width = image.getWidth(null);
        this.height = image.getHeight(null);

    }

    @Override
    public void update() {

        y += speed;

    }

    @Override
    public void update(boolean left, boolean right, boolean up, boolean down){

    }

    @Override
    public void draw(Graphics g) {

        g.drawImage(image, x, y, null);

    }

    public boolean isOutOfScreen(int screenHeight){
        return y > screenHeight;
    }

}