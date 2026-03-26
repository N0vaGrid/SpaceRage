package com.n0vaGrid.spacerage.ecs.component;
import com.n0vaGrid.spacerage.engine.Animation;

import java.util.HashMap;
import java.util.Map;

public class AnimationComponent implements Component {
    public Map<String, Animation> animations = new HashMap<>();

    public Animation current;

    public String currentName;

    public boolean locked = false;

    public void addAnimation(String name, Animation animation){
        animations.put(name, animation);
    }

    public void play(String name){

        if(locked) return;

        Animation next = animations.get(name);

        if(next == null) return;

        if(current != next){

            next.reset();
            current = next;
            currentName = name;

        }
    }

    public void forcePlay(String name, boolean lock){

        Animation next = animations.get(name);

        if(next == null) return;

        next.reset();

        current = next;
        currentName = name;

        locked = lock;

    }

    public boolean isPlaying(String name){

        return current == animations.get(name);

    }
}