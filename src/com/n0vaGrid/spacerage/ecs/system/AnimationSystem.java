package com.n0vaGrid.spacerage.ecs.system;

import com.n0vaGrid.spacerage.ecs.component.AnimationComponent;
import com.n0vaGrid.spacerage.ecs.component.ComponentManager;
import com.n0vaGrid.spacerage.ecs.entity.Entity;

public class AnimationSystem {

    public void update(ComponentManager cm){

        for(Entity e : cm.getEntities(AnimationComponent.class)){

            AnimationComponent ac = cm.getComponent(e, AnimationComponent.class);

            if(ac != null){
                ac.animation.update();
            }
        }
    }
}