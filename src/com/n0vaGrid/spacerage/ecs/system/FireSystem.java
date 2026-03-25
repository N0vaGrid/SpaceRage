package com.n0vaGrid.spacerage.ecs.system;

import com.n0vaGrid.spacerage.ecs.component.*;
import com.n0vaGrid.spacerage.ecs.entity.EntityFactory;
import com.n0vaGrid.spacerage.ecs.entity.EntityManager;
import com.n0vaGrid.spacerage.ecs.entity.Entity;
import com.n0vaGrid.spacerage.ecs.input.InputState;
import com.n0vaGrid.spacerage.util.ResourceManager;

public class FireSystem {

    private long lastFireTime = 0;
    private int cooldown = 200;
    private InputState input;
    private EntityFactory factory;

    public FireSystem(InputState input , EntityFactory factory){
        this.input = input;
        this.factory = factory;
    }

    public void update(ComponentManager cm, EntityManager em){

        long now = System.currentTimeMillis();

        for(Entity e : cm.getEntities(PlayerComponent.class)){

            if(!input.fire) continue;

            PositionComponent p = cm.getComponent(e, PositionComponent.class);

            VelocityComponent v = new VelocityComponent(0, -8);


            if(now - lastFireTime < cooldown) continue;

            factory.createBullet(p.x ,p.y);

            lastFireTime = now;
        }
    }
}