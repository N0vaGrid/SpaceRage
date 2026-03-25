package com.n0vaGrid.spacerage.ui;

import javax.swing.*;

import com.n0vaGrid.spacerage.config.Config;

public class GameWindow extends JFrame {

    public GameWindow(JPanel panel) {

        setTitle("spacerage");

        setSize(Config.WIDTH, Config.HEIGHT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setResizable(false);

        setVisible(true);

        // 添加游戏画布
        add(panel);

        // 关键：让 GamePanel 获得焦点，才能接收键盘输入
        panel.requestFocusInWindow();
    }

}
