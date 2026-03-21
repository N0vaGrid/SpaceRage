package com.N0vaGrid.spacerage.ecs.system;

import com.N0vaGrid.spacerage.ecs.component.ComponentManager;
import com.N0vaGrid.spacerage.ecs.component.PositionComponent;
import com.N0vaGrid.spacerage.ecs.entity.Entity;
import com.N0vaGrid.spacerage.ecs.component.VelocityComponent;


public class MovementSystem {

    public void update(ComponentManager cm){

        for(Entity e : cm.getEntities(PositionComponent.class)){

            PositionComponent p = cm.getComponent(e, PositionComponent.class);
            VelocityComponent v = cm.getComponent(e, VelocityComponent.class);

            if(v != null){
                p.x += v.dx;
                p.y += v.dy;
            }
        }
    }
}