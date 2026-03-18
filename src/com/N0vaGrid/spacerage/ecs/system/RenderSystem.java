package com.N0vaGrid.spacerage.ecs.system;

import com.N0vaGrid.spacerage.ecs.component.ComponentManager;
import com.N0vaGrid.spacerage.ecs.component.PositionComponent;
import com.N0vaGrid.spacerage.ecs.component.SpriteComponent;
import com.N0vaGrid.spacerage.ecs.entity.Entity;

import java.awt.Graphics;

public class RenderSystem {

    public void render(ComponentManager cm, Graphics g){

        var sprites = cm.getAll(SpriteComponent.class);

        for(Entity e : sprites.keySet()){

            PositionComponent p = cm.getComponent(e, PositionComponent.class);
            SpriteComponent s = cm.getComponent(e, SpriteComponent.class);

            if(p != null && s != null){
                g.drawImage(s.image, p.x, p.y, s.width, s.height, null);
            }
        }
    }
}