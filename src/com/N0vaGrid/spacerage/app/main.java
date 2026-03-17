package com.N0vaGrid.spacerage.app;

import com.N0vaGrid.spacerage.engine.GameEngine;
import com.N0vaGrid.spacerage.ui.GameWindow;

public class main {
    public static void main(String[] args) {

        GameEngine engine = new GameEngine();

        new Thread(engine).start();

    }
}
