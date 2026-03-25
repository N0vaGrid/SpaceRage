package com.n0vaGrid.spacerage.ecs.component;

public class ColliderComponent implements Component {

    public int width, height;

    public ColliderComponent(int width, int height){
        this.width = width;
        this.height = height;
    }
}