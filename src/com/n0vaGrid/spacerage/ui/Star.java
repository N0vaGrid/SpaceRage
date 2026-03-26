package com.n0vaGrid.spacerage.ui;

public class Star {

    public int x;
    public int y;
    public int speed;
    public int size;
    public int twinkleTimer;
    public int twinkleDelay;

    public Star(int x, int y, int speed, int size){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.size = size;
        this.twinkleTimer = 0;
        this.twinkleDelay = 30 + (int)(Math.random()*60);
    }

}