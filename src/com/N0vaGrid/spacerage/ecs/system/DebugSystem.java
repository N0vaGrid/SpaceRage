package com.N0vaGrid.spacerage.ecs.system;

import com.N0vaGrid.spacerage.ecs.component.ComponentManager;
import com.N0vaGrid.spacerage.ecs.component.PositionComponent;

public class DebugSystem {

    public void update(ComponentManager cm){

        for(var entity : cm.getEntities(PositionComponent.class)){

            PositionComponent p = cm.getComponent(entity, PositionComponent.class);

            // 简单测试：让所有实体往下移动
            p.y += 1;
        }
    }
}