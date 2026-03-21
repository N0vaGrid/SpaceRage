package com.N0vaGrid.spacerage.app;

import com.N0vaGrid.spacerage.engine.GameEngine;
import com.N0vaGrid.spacerage.ui.GamePanel;
import com.N0vaGrid.spacerage.ui.GameWindow;

public class main {
    public static void main(String[] args) {

        GameEngine engine = new GameEngine();

        GamePanel panel = new GamePanel(engine);

        panel.setEngine(engine);

        new GameWindow(panel);

        // 启动游戏循环
        panel.startGameLoop();

    }
}
