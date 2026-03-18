package com.N0vaGrid.spacerage.ecs.component;

public class VelocityComponent implements Component {

    public int vx, vy;

    public VelocityComponent(int vx, int vy){
        this.vx = vx;
        this.vy = vy;
    }
}