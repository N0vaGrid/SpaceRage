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

                if(ac.current != ac.left){
                    ac.left.reset();
                    ac.current = ac.left;
                }

            }
            else if(input.right){

                if(ac.current != ac.right){
                    ac.right.reset();
                    ac.current = ac.right;
                }

            }
            else{

                if(ac.current == ac.left){
                    ac.leftReturn.reset();
                    ac.current = ac.leftReturn;
                }
                else if(ac.current == ac.right){
                    ac.rightReturn.reset();
                    ac.current = ac.rightReturn;
                }

            }
        }
    }
}