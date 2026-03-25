package com.n0vaGrid.spacerage.ecs.system;

import com.n0vaGrid.spacerage.config.Config;
import com.n0vaGrid.spacerage.ecs.component.BulletComponent;
import com.n0vaGrid.spacerage.ecs.component.ComponentManager;
import com.n0vaGrid.spacerage.ecs.component.PositionComponent;
import com.n0vaGrid.spacerage.ecs.entity.Entity;
import com.n0vaGrid.spacerage.ecs.entity.EntityManager;

public class CleanupSystem {

    public void update(ComponentManager cm, EntityManager em){

        // 清理超出屏幕的子弹
        for(Entity e : cm.getEntities(BulletComponent.class)){

            PositionComponent p = cm.getComponent(e, PositionComponent.class);

            if(p != null){
                // 超出屏幕上边界
                if(p.y < -50){
                    em.removeEntity(e);
                }
                // 超出屏幕下边界
                else if(p.y > Config.HEIGHT + 50){
                    em.removeEntity(e);
                }
                // 超出屏幕左边界
                else if(p.x < -50){
                    em.removeEntity(e);
                }
                // 超出屏幕右边界
                else if(p.x > Config.WIDTH + 50){
                    em.removeEntity(e);
                }
            }
        }
    }
}
