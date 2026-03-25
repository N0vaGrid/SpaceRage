package com.n0vaGrid.spacerage.ecs.component;
import com.n0vaGrid.spacerage.engine.Animation;

public class AnimationComponent implements Component {

    public Animation animation;

    public AnimationComponent(Animation animation){
        this.animation = animation;
    }
}