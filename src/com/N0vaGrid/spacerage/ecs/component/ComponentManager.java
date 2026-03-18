package com.N0vaGrid.spacerage.ecs.component;

import com.N0vaGrid.spacerage.ecs.entity.Entity;

import java.util.*;

public class ComponentManager {

    private Map<Class<?>, Map<Entity, Component>> components = new HashMap<>();

    //为指定实体添加一个组件
    public <T extends Component> void addComponent(Entity e, T component){

        components
            .computeIfAbsent(component.getClass(), k -> new HashMap<>())
            .put(e, component);
    }

    //获取指定实体的指定组件
    public <T extends Component> T getComponent(Entity e, Class<T> type){

        Map<Entity, Component> map = components.get(type);

        if(map == null) return null;

        return type.cast(map.get(e));
    }

    //获取所有同类组件
    public <T extends Component> Map<Entity, Component> getAll(Class<T> type){
        return components.getOrDefault(type, new HashMap<>());
    }
}