package com.N0vaGrid.spacerage.model;

import java.awt.Graphics;
import java.awt.Image;
import com.N0vaGrid.spacerage.util.ResourceManager;

public class Background {

    private int y1 = 0;
    private int y2 = -800;

    private int speed = 1;

    private Image image;

    public Background(){

        image = ResourceManager.BG;

    }

    public void update(){

        y1 += speed;
        y2 += speed;

        if(y1 >= 800){
            y1 = -800;
        }

        if(y2 >= 800){
            y2 = -800;
        }

    }

    public void draw(Graphics g){

        g.drawImage(image, 0, y1, null);
        g.drawImage(image, 0, y2, null);

    }

}