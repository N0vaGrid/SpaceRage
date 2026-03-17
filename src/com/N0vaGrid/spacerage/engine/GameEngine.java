package com.N0vaGrid.spacerage.engine;

import com.N0vaGrid.spacerage.controller.InputController;
import com.N0vaGrid.spacerage.service.GameService;
import com.N0vaGrid.spacerage.ui.GameWindow;
import com.N0vaGrid.spacerage.ui.GamePanel;

public class GameEngine implements Runnable {

    private GameService gameService;
    private GamePanel gamePanel;
    private InputController input;

    public GameEngine(){

        gameService = new GameService();
        input = new InputController();

        gamePanel = new GamePanel(gameService);



        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();
        gamePanel.addKeyListener(input);

        GameWindow window = new GameWindow(gamePanel);


    }

    @Override
    public void run() {

        while(true){

            gameService.update(input);

            gamePanel.repaint();

            try{
                Thread.sleep(16);
            }catch(Exception e){
                e.printStackTrace();
            }

        }

    }

}