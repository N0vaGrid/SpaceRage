package com.n0vaGrid.spacerage.ecs.system;


import com.n0vaGrid.spacerage.ecs.component.*;
import com.n0vaGrid.spacerage.ecs.entity.Entity;
import com.n0vaGrid.spacerage.ecs.entity.EntityManager;
import com.n0vaGrid.spacerage.engine.Animation;
import com.n0vaGrid.spacerage.util.ResourceManager;

public class CollisionSystem {

    public void update(ComponentManager cm, EntityManager em){

        for(Entity bullet : cm.getEntities(BulletComponent.class)){

            PositionComponent bp = cm.getComponent(bullet, PositionComponent.class);
            ColliderComponent bc = cm.getComponent(bullet, ColliderComponent.class);

            for(Entity enemy : cm.getEntities(EnemyComponent.class)){

                PositionComponent ep = cm.getComponent(enemy, PositionComponent.class);
                ColliderComponent ec = cm.getComponent(enemy, ColliderComponent.class);

                if(bp != null && bc != null && ep != null && ec != null){

                    if(checkCollision(bp, bc, ep, ec)){

                        // 删除子弹
                        em.removeEntity(bullet);

                        // 删除敌机
                        em.removeEntity(enemy);

                        // 生成爆炸
                        createExplosion(cm, em, ep.x, ep.y);
                    }
                }
            }
        }
    }

    private boolean checkCollision(PositionComponent a, ColliderComponent ac,
                                   PositionComponent b, ColliderComponent bc){

        return a.x < b.x + bc.width &&
               a.x + ac.width > b.x &&
               a.y < b.y + bc.height &&
               a.y + ac.height > b.y;
    }

    private void createExplosion(ComponentManager cm, EntityManager em, int x, int y){

        Entity explosion = new Entity();
        em.addEntity(explosion);

        cm.addComponent(explosion, new PositionComponent(x, y));

        cm.addComponent(explosion, new AnimationComponent(
                new Animation(ResourceManager.EXPLOSIONS, 50, false)
        ));
    }
}