package com.n0vaGrid.spacerage.ecs.component;

import java.awt.Image;

public class SpriteComponent implements Component {

    public Image image;

    public int width, height;

    public SpriteComponent(Image image, int w, int h){
        this.image = image;
        this.width = w;
        this.height = h;
    }
}