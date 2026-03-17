package com.N0vaGrid.spacerage.model;

import com.N0vaGrid.spacerage.util.ResourceManager;

import java.awt.*;

public class Bullet extends GameObject {

    private int speed = 8;

    private Image image;

    public Bullet(int x,int y){

        this.x = x;
        this.y = y;

        this.image = ResourceManager.BULLET;

        this.width = image.getWidth(null);
        this.height = image.getHeight(null);

    }

    @Override
    public void update() {

        y -= speed;

    }

    @Override
    public void update(boolean left, boolean right, boolean up, boolean down){

    }

    @Override
    public void draw(Graphics g) {

        g.drawImage(image, x, y, null);

    }

    public boolean isOutOfScreen(){

        return y < 0;

    }

}