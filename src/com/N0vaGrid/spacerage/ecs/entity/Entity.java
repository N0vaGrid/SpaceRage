package com.N0vaGrid.spacerage.ecs.entity;

public class Entity {

    private static int nextId = 0;

    private int id;

    public Entity(){
        this.id = nextId++;
    }

    public int getId(){
        return id;
    }
}