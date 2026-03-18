package com.N0vaGrid.spacerage.ecs.system;

import com.N0vaGrid.spacerage.ecs.component.AnimationComponent;
import com.N0vaGrid.spacerage.ecs.component.ComponentManager;
import com.N0vaGrid.spacerage.ecs.component.Component;

public class AnimationSystem {

    public void update(ComponentManager cm){

        var anims = cm.getAll(AnimationComponent.class);

        for(Component c : anims.values()){
            AnimationComponent ac = (AnimationComponent)c;
            ac.animation.update();
        }
    }
}