package com.N0vaGrid.spacerage.ecs.system;

import com.N0vaGrid.spacerage.ecs.component.ComponentManager;
import com.N0vaGrid.spacerage.ecs.component.PositionComponent;
import com.N0vaGrid.spacerage.ecs.component.VelocityComponent;
import com.N0vaGrid.spacerage.ecs.entity.Entity;

public class MovementSystem {

    public void update(ComponentManager cm){

        var positions = cm.getAll(PositionComponent.class);
        var velocities = cm.getAll(VelocityComponent.class);

        for(Entity e : positions.keySet()){

            PositionComponent p = cm.getComponent(e, PositionComponent.class);
            VelocityComponent v = cm.getComponent(e, VelocityComponent.class);

            if(p != null && v != null){
                p.x += v.vx;
                p.y += v.vy;
            }
        }
    }
}