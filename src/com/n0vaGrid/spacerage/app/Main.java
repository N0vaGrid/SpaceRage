package com.n0vaGrid.spacerage.app;

import com.n0vaGrid.spacerage.engine.GameEngine;
import com.n0vaGrid.spacerage.ui.GamePanel;
import com.n0vaGrid.spacerage.ui.GameWindow;

public class Main {
    public static void Main(String[] args) {

        GameEngine engine = new GameEngine();

        GamePanel panel = new GamePanel(engine);

        panel.setEngine(engine);

        new GameWindow(panel);

        // 启动游戏循环
        panel.startGameLoop();

    }
}
