package com.n0vaGrid.spacerage.ecs.entity;

import com.n0vaGrid.spacerage.ecs.component.*;
import com.n0vaGrid.spacerage.util.ResourceManager;

public class EntityFactory {

    private EntityManager em;
    private ComponentManager cm;

    public EntityFactory(EntityManager entityManager, ComponentManager componentManager) {
        em = entityManager;
        cm = componentManager;
    }
    public Entity createPlayer(){

        Entity player = new Entity();
        em.addEntity(player);

        // 位置
        cm.addComponent(player, new PositionComponent(200, 600));
        // 速度
        cm.addComponent(player, new VelocityComponent(0, 0));
        // 图片
        cm.addComponent(player, new SpriteComponent(
                ResourceManager.PLAYER_IDLE, 64, 64
        ));

        // 碰撞器
        cm.addComponent(player, new ColliderComponent(64, 64));
        cm.addComponent(player, new PlayerComponent());

        return player;
    }

    public Entity createEnemy() {

        Entity enemy = new Entity();
        em.addEntity(enemy);

        int x = (int)(Math.random() * 700) + 50;
        int y = -50;

        // 位置
        cm.addComponent(enemy,
                new PositionComponent(x, y));

        // 速度（向下移动）
        cm.addComponent(enemy,
                new VelocityComponent(0, 2));

        // 图片
        cm.addComponent(enemy,
                new SpriteComponent(ResourceManager.ENEMY , 64, 64));

        // 碰撞器
        cm.addComponent(enemy, new ColliderComponent(64, 64));

        // 标记这是敌人
        cm.addComponent(enemy,
                new EnemyComponent());

        return enemy;
    }

}
