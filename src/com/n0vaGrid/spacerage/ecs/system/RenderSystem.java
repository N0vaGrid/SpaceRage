package com.n0vaGrid.spacerage.ecs.system;



import com.n0vaGrid.spacerage.ecs.component.*;
import com.n0vaGrid.spacerage.ecs.entity.Entity;

import java.awt.Graphics;

public class RenderSystem {


    public void render(ComponentManager cm, Graphics g){

        for(Entity e : cm.getEntities(SpriteComponent.class)){

            PositionComponent p = cm.getComponent(e, PositionComponent.class);
            SpriteComponent s = cm.getComponent(e, SpriteComponent.class);
            AnimationComponent ac = cm.getComponent(e, AnimationComponent.class);
            ColliderComponent collider = cm.getComponent(e, ColliderComponent.class);

            if(ac != null){
                g.drawImage(ac.animation.getCurrentFrame(), p.x, p.y, null);
            }
            else if(s != null){
                g.drawImage(s.image, p.x, p.y, s.width, s.height, null);
            }

            // 绘制碰撞器
            g.drawRect(p.x,p.y,collider.width,collider.height);
        }
    }
}