package com.N0vaGrid.spacerage.ecs.component;

import com.N0vaGrid.spacerage.ecs.component.Component;
import com.N0vaGrid.spacerage.ecs.entity.Entity;

import java.util.*;

public class ComponentManager {

    private Map<Class<?>, Map<Entity, Component>> components = new HashMap<>();

    public <T extends Component> void addComponent(Entity e, T component){

        components
                .computeIfAbsent(component.getClass(), k -> new HashMap<>())
                .put(e, component);
    }

    public <T extends Component> T getComponent(Entity e, Class<T> type){

        Map<Entity, Component> map = components.get(type);

        if(map == null) return null;

        return type.cast(map.get(e));
    }

    public <T extends Component> Collection<Component> getAll(Class<T> type){

        return components.getOrDefault(type, new HashMap<>()).values();
    }

    public Set<Entity> getEntities(Class<? extends Component> type){

        return components.getOrDefault(type, new HashMap<>()).keySet();
    }
}