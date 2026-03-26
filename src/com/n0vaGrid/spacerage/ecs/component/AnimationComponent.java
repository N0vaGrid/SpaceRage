package com.n0vaGrid.spacerage.ecs.component;
import com.n0vaGrid.spacerage.engine.Animation;

import java.util.HashMap;
import java.util.Map;

public class AnimationComponent implements Component {
    public Map<String, Animation> animations = new HashMap<>();

    public Animation current;

    public void addAnimation(String name, Animation animation){
        animations.put(name, animation);
    }

    public void play(String name){

        Animation next = animations.get(name);

        if(next == null) return;

        if(current != next){
            next.reset();
            current = next;
        }
    }
}