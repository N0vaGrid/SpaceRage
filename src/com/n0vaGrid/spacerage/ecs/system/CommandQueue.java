package com.n0vaGrid.spacerage.ecs.system;

import java.util.LinkedList;
import java.util.Queue;

public class CommandQueue {

    private Queue<Runnable> commands = new LinkedList<>();

    public void add(Runnable command){
        commands.add(command);
    }

    public void execute(){
        while(!commands.isEmpty()){
            commands.poll().run();
        }
    }
}