package com.N0vaGrid.spacerage.ui;

import com.N0vaGrid.spacerage.config.Config;
import com.N0vaGrid.spacerage.model.PlayerPlane;
import com.N0vaGrid.spacerage.service.GameService;
import com.N0vaGrid.spacerage.util.ResourceManager;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel  {

    private Thread gameThread;

    private GameService gameService;
    public GamePanel(GameService gameService) {

        this.gameService = gameService;
    }


    @Override
    protected void paintComponent(Graphics g) {


        super.paintComponent(g);

        // 背景
        gameService.getBackground().draw(g);
        //绘制玩家
        gameService.getPlayer().draw(g);

        // 渲染子弹
        for(var bullet : gameService.getBullets()){
            bullet.draw(g);
        }
        // 渲染敌人
        for(var enemy : gameService.getEnemies()){
            enemy.draw(g);
        }

        // 渲染爆炸
        for(var ex : gameService.getExplosions()){
            ex.draw(g);
        }
        // 绘制分数
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Score: " + gameService.getScore(), 10, 20);

        //游戏结束画面
        if(gameService.isGameOver()){

            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 48));

            // 获取文字宽度以便居中
            int textWidth = g.getFontMetrics().stringWidth("GAME OVER");
            g.drawString("GAME OVER", Config.WIDTH/2 - textWidth/2, Config.HEIGHT/2);

        }

    }

}