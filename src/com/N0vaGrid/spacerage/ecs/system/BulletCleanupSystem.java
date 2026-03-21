package com.N0vaGrid.spacerage.ecs.system;

import com.N0vaGrid.spacerage.ecs.component.BulletComponent;
import com.N0vaGrid.spacerage.ecs.component.ComponentManager;
import com.N0vaGrid.spacerage.ecs.component.PositionComponent;
import com.N0vaGrid.spacerage.ecs.entity.Entity;
import com.N0vaGrid.spacerage.ecs.entity.EntityManager;

public class BulletCleanupSystem {

    private int screenHeight = 800;

    public void update(ComponentManager cm, EntityManager em){

        for(Entity e : cm.getEntities(BulletComponent.class)){

            PositionComponent p = cm.getComponent(e, PositionComponent.class);

            if(p.y < 0){
                em.removeEntity(e);
            }
        }
    }
}