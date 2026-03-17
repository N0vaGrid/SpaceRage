package com.N0vaGrid.spacerage.model;

import java.awt.Graphics;
import java.awt.Image;

import com.N0vaGrid.spacerage.engine.Animation;
import com.N0vaGrid.spacerage.util.ResourceManager;

public class Explosion {

    private int x, y;

    private Animation animation;

    public Explosion(int x, int y){

        this.animation = new Animation(
                ResourceManager.EXPLOSIONS,
                50,
                false
        );

        // 居中（推荐）
        int w = ResourceManager.EXPLOSIONS[0].getWidth(null);
        int h = ResourceManager.EXPLOSIONS[0].getHeight(null);

        this.x = x - w / 2;
        this.y = y - h / 2;
    }

    public void update(){
        animation.update();
    }

    public void draw(Graphics g){

        g.drawImage(animation.getCurrentFrame(), x, y, null);

    }

    public boolean isDead(){
        return animation.isFinished();
    }

}