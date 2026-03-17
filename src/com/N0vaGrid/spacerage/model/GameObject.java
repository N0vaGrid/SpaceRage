package com.N0vaGrid.spacerage.model;

import java.awt.Graphics;

public abstract class GameObject {

    protected int x;
    protected int y;

    protected int width;
    protected int height;

    public abstract void draw(Graphics g);

    public abstract void update(boolean left, boolean right, boolean up, boolean down);

    public abstract void update();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX( int x){
        this.x = x ;
    }
    public void setY ( int y){
        this.y = y ;
    }

    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
}