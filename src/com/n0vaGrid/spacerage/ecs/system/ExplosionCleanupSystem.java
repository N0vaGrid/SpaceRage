package com.n0vaGrid.spacerage.ecs.system;

import com.n0vaGrid.spacerage.ecs.component.AnimationComponent;
import com.n0vaGrid.spacerage.ecs.component.ComponentManager;
import com.n0vaGrid.spacerage.ecs.entity.Entity;
import com.n0vaGrid.spacerage.ecs.entity.EntityManager;

public class ExplosionCleanupSystem {

    public void update(ComponentManager cm, EntityManager em){

        for(Entity e : cm.getEntities(AnimationComponent.class)){

            AnimationComponent ac = cm.getComponent(e, AnimationComponent.class);

            if(ac.animation.isFinished()){
                em.removeEntity(e);
            }
        }
    }
}