package com.n0vaGrid.spacerage.ecs.system;

import com.n0vaGrid.spacerage.ecs.component.AnimationComponent;
import com.n0vaGrid.spacerage.ecs.component.ComponentManager;
import com.n0vaGrid.spacerage.ecs.component.PlayerComponent;
import com.n0vaGrid.spacerage.ecs.input.InputState;
import com.n0vaGrid.spacerage.ecs.entity.Entity;

public class PlayerAnimationSystem {

    private InputState input;

    public PlayerAnimationSystem(InputState input){
        this.input = input;
    }

    public void update(ComponentManager cm){

        for(Entity e : cm.getEntities(PlayerComponent.class)){

            AnimationComponent ac =
                    cm.getComponent(e, AnimationComponent.class);

            if(ac == null) continue;

            if(input.left){

                ac.play("left");

            }
            else if(input.right){

                ac.play("right");

            }
            else{

                ac.play("idle");

            }
        }
    }
}