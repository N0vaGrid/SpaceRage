package com.n0vaGrid.spacerage.ui;

import com.n0vaGrid.spacerage.ecs.input.InputState;
import com.n0vaGrid.spacerage.ecs.system.RenderSystem;
import com.n0vaGrid.spacerage.engine.GameEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel  {

    private RenderSystem renderSystem;
    private InputState input;

    private GameEngine engine;

    public GamePanel(GameEngine engine) {

        this.engine = engine;
        this.input = engine.getInput();

        setFocusable(true);
        requestFocusInWindow();

        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                handleKeyPressed(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e){
                handleKeyReleased(e.getKeyCode());
            }
        });

        this.renderSystem = new RenderSystem();
    }


    @Override
    protected void paintComponent(Graphics g) {


        super.paintComponent(g);

       // System.out.println("paint"); // ⭐ 打印

        renderSystem.render(engine.getCM(), g);

    }


    public void setEngine(GameEngine engine) {
        this.engine = engine;
    }

    public void startGameLoop(){

        Timer timer = new Timer(16, e -> {

            engine.update();  // 逻辑

            repaint();        // 渲染

        });

        timer.setCoalesce(true);   // 如果Timer事件堆积，只执行一次

        timer.start();
    }

    private void handleKeyPressed(int key){
        switch(key){
            case KeyEvent.VK_LEFT:  input.left = true; break;
            case KeyEvent.VK_RIGHT: input.right = true; break;
            case KeyEvent.VK_UP:    input.up = true; break;
            case KeyEvent.VK_DOWN:  input.down = true; break;
            case KeyEvent.VK_SPACE: input.fire = true; break;
        }
    }

    private void handleKeyReleased(int key){
        switch(key){
            case KeyEvent.VK_LEFT:  input.left = false; break;
            case KeyEvent.VK_RIGHT: input.right = false; break;
            case KeyEvent.VK_UP:    input.up = false; break;
            case KeyEvent.VK_DOWN:  input.down = false; break;
            case KeyEvent.VK_SPACE: input.fire = false; break;
        }
    }

}