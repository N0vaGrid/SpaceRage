package com.N0vaGrid.spacerage.ecs.entity;

import com.N0vaGrid.spacerage.ecs.component.*;
import com.N0vaGrid.spacerage.util.ResourceManager;

public class EntityFactory {
    public static Entity createPlayer(ComponentManager cm, EntityManager em){

        Entity player = new Entity();
        em.addEntity(player);

        cm.addComponent(player, new PositionComponent(200, 600));
        cm.addComponent(player, new VelocityComponent(0, 0));

        cm.addComponent(player, new SpriteComponent(
                ResourceManager.PLAYER_IDLE, 64, 64
        ));

        cm.addComponent(player, new ColliderComponent(64, 64));
        cm.addComponent(player, new PlayerComponent());

        return player;
    }

}
