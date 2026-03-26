package com.n0vaGrid.spacerage.ecs.system;

import com.n0vaGrid.spacerage.ecs.component.*;
import com.n0vaGrid.spacerage.ecs.entity.Entity;
import com.n0vaGrid.spacerage.ecs.entity.EntityManager;
import com.n0vaGrid.spacerage.ecs.collision.CollisionEvent;
import com.n0vaGrid.spacerage.engine.Animation;
import com.n0vaGrid.spacerage.util.ResourceManager;

import java.util.ArrayList;
import java.util.List;

public class CollisionSystem {

    private List<CollisionEvent> events = new ArrayList<>();

    public void update(ComponentManager cm, EntityManager em){

        events.clear();

        List<Entity> colliders = new ArrayList<>(
                cm.getEntities(ColliderComponent.class)
        );

        // 检测所有碰撞
        for(int i = 0; i < colliders.size(); i++){

            Entity a = colliders.get(i);

            PositionComponent pa = cm.getComponent(a, PositionComponent.class);
            ColliderComponent ca = cm.getComponent(a, ColliderComponent.class);

            for(int j = i + 1; j < colliders.size(); j++){

                Entity b = colliders.get(j);

                PositionComponent pb = cm.getComponent(b, PositionComponent.class);
                ColliderComponent cb = cm.getComponent(b, ColliderComponent.class);

                if(pa == null || pb == null) continue;

                if(checkCollision(pa, ca, pb, cb)){

                    events.add(new CollisionEvent(a, b));

                }

            }

        }

        // 处理碰撞
        for(CollisionEvent e : events){

            handleCollision(cm, em, e.a, e.b);

        }

    }

    private boolean checkCollision(PositionComponent a, ColliderComponent ac,
                                   PositionComponent b, ColliderComponent bc){

        return a.x < b.x + bc.width &&
               a.x + ac.width > b.x &&
               a.y < b.y + bc.height &&
               a.y + ac.height > b.y;
    }

    private void handleCollision(ComponentManager cm, EntityManager em,
                                 Entity a, Entity b){

        // 子弹击中敌机
        if(cm.hasComponent(a, BulletComponent.class)
        && cm.hasComponent(b, EnemyComponent.class)){

            bulletHitEnemy(cm, em, a, b);
        }

        else if(cm.hasComponent(b, BulletComponent.class)
        && cm.hasComponent(a, EnemyComponent.class)){

            bulletHitEnemy(cm, em, b, a);
        }

        // 玩家撞敌机
        else if(cm.hasComponent(a, PlayerComponent.class)
        && cm.hasComponent(b, EnemyComponent.class)){

            playerHitEnemy(cm, em, a, b);
        }

        else if(cm.hasComponent(b, PlayerComponent.class)
        && cm.hasComponent(a, EnemyComponent.class)){

            playerHitEnemy(cm, em, b, a);
        }

    }

    private void bulletHitEnemy(ComponentManager cm, EntityManager em,
                                Entity bullet, Entity enemy){

        System.out.println("Bullet hit enemy");

        PositionComponent ep = cm.getComponent(enemy, PositionComponent.class);

        em.removeEntity(bullet);
        em.removeEntity(enemy);

        createExplosion(cm, em, ep.x, ep.y);

    }

    private void playerHitEnemy(ComponentManager cm, EntityManager em,
                                Entity player, Entity enemy){

        System.out.println("Player hit enemy");

        PositionComponent ep = cm.getComponent(enemy, PositionComponent.class);

        em.removeEntity(enemy);

        createExplosion(cm, em, ep.x, ep.y);

    }

    private void createExplosion(ComponentManager cm, EntityManager em,
                                 int x, int y){

        System.out.println("create explosion");

        Entity explosion = new Entity();

        em.addEntity(explosion);

        cm.addComponent(explosion,
                new PositionComponent(x, y));

        AnimationComponent ac = new AnimationComponent();

        ac.addAnimation("explode",
                new Animation(
                        ResourceManager.EXPLOSIONS,
                        50,
                        false
                ));

        ac.forcePlay("explode", true);

        cm.addComponent(explosion, ac);

        cm.addComponent(explosion,
                new SpriteComponent(ResourceManager.EXPLOSIONS[0], 50, 50));

        cm.addComponent(explosion,
                new DestroyOnFinishComponent());

    }

}