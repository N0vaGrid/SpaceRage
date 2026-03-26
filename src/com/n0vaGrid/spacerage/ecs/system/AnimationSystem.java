package com.n0vaGrid.spacerage.ecs.system;

import com.n0vaGrid.spacerage.ecs.component.AnimationComponent;
import com.n0vaGrid.spacerage.ecs.component.ComponentManager;
import com.n0vaGrid.spacerage.ecs.component.DestroyOnFinishComponent;
import com.n0vaGrid.spacerage.ecs.component.SpriteComponent;
import com.n0vaGrid.spacerage.ecs.entity.Entity;
import com.n0vaGrid.spacerage.ecs.entity.EntityManager;

public class AnimationSystem {

    public void update(ComponentManager cm , EntityManager em){

        for(Entity e : cm.getEntities(AnimationComponent.class)){

            AnimationComponent ac =
                    cm.getComponent(e, AnimationComponent.class);

            SpriteComponent sc =
                    cm.getComponent(e, SpriteComponent.class);

            if(ac == null || sc == null) continue;

            DestroyOnFinishComponent destroy =
                    cm.getComponent(e, DestroyOnFinishComponent.class);

            if(ac.current.isFinished()){

                ac.locked = false;

                if(destroy != null){
                    em.removeEntity(e);
                }

            }

            ac.current.update();

            if(ac.current.isFinished()){

                ac.locked = false;

            }

            sc.image = ac.current.getCurrentFrame();
        }
    }
}