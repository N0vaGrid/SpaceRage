package com.N0vaGrid.spacerage.ecs.system;

import com.N0vaGrid.spacerage.ecs.component.ComponentManager;
import com.N0vaGrid.spacerage.ecs.component.VelocityComponent;
import com.N0vaGrid.spacerage.ecs.entity.Entity;
import com.N0vaGrid.spacerage.ecs.input.InputState;
import com.N0vaGrid.spacerage.ecs.component.PlayerComponent;

public class InputSystem {

    private InputState input;

    public InputSystem(InputState input){
        this.input = input;
    }

    public void update(ComponentManager cm){

        for(Entity e : cm.getEntities(PlayerComponent.class)){

            VelocityComponent v = cm.getComponent(e, VelocityComponent.class);

            v.dx = 0;
            v.dy = 0;

            if(input.left)  v.dx = -5;
            if(input.right) v.dx = 5;
            if(input.up)    v.dy = -5;
            if(input.down)  v.dy = 5;
        }
    }
}