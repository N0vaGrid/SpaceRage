package com.N0vaGrid.spacerage.engine;

import com.N0vaGrid.spacerage.controller.InputController;
import com.N0vaGrid.spacerage.ecs.component.ComponentManager;
import com.N0vaGrid.spacerage.ecs.component.PositionComponent;
import com.N0vaGrid.spacerage.ecs.entity.Entity;
import com.N0vaGrid.spacerage.ecs.system.DebugSystem;
import com.N0vaGrid.spacerage.service.GameService;
import com.N0vaGrid.spacerage.ui.GameWindow;
import com.N0vaGrid.spacerage.ui.GamePanel;

public class GameEngine implements Runnable {

    private GameService gameService;
    private GamePanel gamePanel;
    private InputController input;
    private ComponentManager componentManager;
    private DebugSystem debugSystem;

    public GameEngine(){

        gameService = new GameService();
        input = new InputController();

        gamePanel = new GamePanel(gameService);

        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();
        gamePanel.addKeyListener(input);

        componentManager = new ComponentManager();
        debugSystem = new DebugSystem();

        GameWindow window = new GameWindow(gamePanel);

        Entity test = new Entity();

        componentManager.addComponent(test, new PositionComponent(100, 100));

    }

    @Override
    public void run() {

        while(true){

            gameService.update(input);
            debugSystem.update(componentManager);

            gamePanel.repaint();

            try{
                Thread.sleep(16);
            }catch(Exception e){
                e.printStackTrace();
            }

        }

    }

}