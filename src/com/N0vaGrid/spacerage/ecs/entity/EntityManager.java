package com.N0vaGrid.spacerage.ecs.entity;


import com.N0vaGrid.spacerage.ecs.component.ComponentManager;

import java.util.HashSet;
import java.util.Set;

public class EntityManager {

    private Set<Entity> entities = new HashSet<>();

    private Set<Entity> toRemove = new HashSet<>();

    public void addEntity(Entity e){
        entities.add(e);
    }

    public Set<Entity> getEntities(){
        return entities;
    }

    public void removeEntity(Entity e){
        toRemove.add(e);
    }

    // 延迟删除（关键！）
    public void flushRemove(ComponentManager cm){

        for(Entity e : toRemove){

            entities.remove(e);
            cm.removeAllComponents(e);
        }

        toRemove.clear();
    }
}