package com.n0vaGrid.spacerage.ecs.collision;

import com.n0vaGrid.spacerage.ecs.entity.Entity;

public class CollisionEvent {

    public Entity a;
    public Entity b;

    public CollisionEvent(Entity a, Entity b){
        this.a = a;
        this.b = b;
    }

}