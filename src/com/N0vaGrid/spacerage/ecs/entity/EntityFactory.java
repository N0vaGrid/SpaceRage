package com.N0vaGrid.spacerage.ecs.entity;

import com.N0vaGrid.spacerage.ecs.component.*;
import com.N0vaGrid.spacerage.util.ResourceManager;

public class EntityFactory {
    public static Entity createPlayer(ComponentManager cm, EntityManager em){

        Entity e = new Entity();
        em.addEntity(e);

        cm.addComponent(e, new PositionComponent(200, 600));
        cm.addComponent(e, new VelocityComponent(0, 0));

        cm.addComponent(e, new SpriteComponent(
                ResourceManager.PLAYER_IDLE, 50, 50
        ));

        cm.addComponent(e, new ColliderComponent(50, 50));
        cm.addComponent(e, new PlayerComponent());

        return e;
    }

}
