package com.n0vaGrid.spacerage.ecs.system;

import com.n0vaGrid.spacerage.ecs.component.*;
import com.n0vaGrid.spacerage.ecs.entity.EntityManager;
import com.n0vaGrid.spacerage.ecs.entity.Entity;
import com.n0vaGrid.spacerage.util.ResourceManager;

public class FireSystem {

    private long lastFireTime = 0;
    private int cooldown = 200;

    public void update(ComponentManager cm, EntityManager em){

        long now = System.currentTimeMillis();

        for(Entity e : cm.getEntities(PlayerComponent.class)){

            if(now - lastFireTime < cooldown) continue;

            PositionComponent p = cm.getComponent(e, PositionComponent.class);

            Entity bullet = new Entity();
            em.addEntity(bullet);

            cm.addComponent(bullet, new PositionComponent(p.x , p.y));
            cm.addComponent(bullet, new VelocityComponent(0, -8));

            cm.addComponent(bullet, new SpriteComponent(
                    ResourceManager.BULLET, 64, 64
            ));

            cm.addComponent(bullet, new ColliderComponent(10, 20));
            cm.addComponent(bullet, new BulletComponent());

            lastFireTime = now;
        }
    }
}