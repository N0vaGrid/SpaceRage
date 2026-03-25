package com.n0vaGrid.spacerage.engine;

import com.n0vaGrid.spacerage.ecs.component.*;
import com.n0vaGrid.spacerage.ecs.entity.EntityFactory;
import com.n0vaGrid.spacerage.ecs.entity.EntityManager;
import com.n0vaGrid.spacerage.ecs.input.InputState;
import com.n0vaGrid.spacerage.ecs.system.*;
import com.n0vaGrid.spacerage.ui.GamePanel;

public class GameEngine implements Runnable {

    private GamePanel panel;

    private CommandQueue commandQueue = new CommandQueue();

    private ComponentManager componentManager;
    private EntityManager entityManager;

    private EntityFactory factory;

    private InputState input;

    // 系统
    private MovementSystem movementSystem;
    private BulletCleanupSystem bulletCleanupSystem;
    private AnimationSystem animationSystem;
    private CollisionSystem collisionSystem;
    private ExplosionCleanupSystem explosionCleanupSystem;
    private InputSystem inputSystem;
    private FireSystem fireSystem;
    private EnemySpawnerSystem enemySpawnerSystem;
    private CleanupSystem cleanupSystem;



    public GameEngine(){
        componentManager = new ComponentManager();
        entityManager = new EntityManager();

        factory = new EntityFactory(entityManager, componentManager);
        factory.createPlayer();

        input = new InputState();

        inputSystem = new InputSystem(input);
        movementSystem = new MovementSystem();
        fireSystem = new FireSystem();
        collisionSystem = new CollisionSystem();
        animationSystem = new AnimationSystem();
        cleanupSystem = new CleanupSystem();
        enemySpawnerSystem = new EnemySpawnerSystem(factory);

    }

    @Override
    public void run() {



        while(true){

            update();

            try{
                Thread.sleep(16);
            }catch(Exception e){
                e.printStackTrace();
            }

        }

    }

    public ComponentManager getCM(){ return componentManager; }
    public InputState getInput(){ return input; }
    public CommandQueue getCommandQueue(){return commandQueue;}

    public void update(){
        inputSystem.update(componentManager);

        movementSystem.update(componentManager);

        fireSystem.update(componentManager, entityManager);

        enemySpawnerSystem.update(componentManager, entityManager);

        collisionSystem.update(componentManager, entityManager);

        cleanupSystem.update(componentManager, entityManager);

        //bulletCleanupSystem.update(componentManager, entityManager);

        //explosionCleanupSystem.update(componentManager, entityManager);

        commandQueue.execute();

    }

}