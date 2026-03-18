package com.N0vaGrid.spacerage.ecs.component;

public class PositionComponent implements Component {

    public int x, y;

    public PositionComponent(int x, int y){
        this.x = x;
        this.y = y;
    }
}