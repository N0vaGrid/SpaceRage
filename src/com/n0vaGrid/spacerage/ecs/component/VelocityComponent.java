package com.n0vaGrid.spacerage.ecs.component;

public class VelocityComponent implements Component {

    public int dx, dy;

    public VelocityComponent(int vx, int vy){
        this.dx = vx;
        this.dy = vy;
    }
}