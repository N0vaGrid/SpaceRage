package com.N0vaGrid.spacerage.service;

import com.N0vaGrid.spacerage.controller.InputController;
import com.N0vaGrid.spacerage.model.*;
import com.N0vaGrid.spacerage.service.*;

import java.util.List;


public class GameService {

    private PlayerPlane player;

    private BulletService bulletService;
    private EnemyService enemyService;
    private ExplosionService explosionService;
    private CollisionService collisionService;
    private ScoreService scoreService;
    private Background background;

    private boolean gameOver = false;

    public GameService(){

        player = new PlayerPlane(220,650);

        bulletService = new BulletService();
        enemyService = new EnemyService();
        explosionService = new ExplosionService();
        collisionService = new CollisionService();
        scoreService = new ScoreService();
        background = new Background();

    }

    public void update(InputController input){

        if(gameOver) return;

        player.update(
                input.left,
                input.right,
                input.up,
                input.down
        );

        // 发射子弹
        if(input.shoot){
            bulletService.shoot(player);
        }

        bulletService.update();
        enemyService.update();
        explosionService.update();
        background.update();

        collisionService.check(
                player,
                bulletService.getBullets(),
                enemyService.getEnemies(),
                explosionService,
                scoreService
        );

        if(player.isDead()){
            gameOver = true;
        }

    }

    // getter 给渲染用
    public PlayerPlane getPlayer(){
        return player;
    }
    public List<Bullet> getBullets(){
        return bulletService.getBullets();
    }
    public List<EnemyPlane> getEnemies(){
        return enemyService.getEnemies();
    }
    public List<Explosion> getExplosions(){
        return explosionService.getExplosions();
    }
    public int getScore(){
        return scoreService.getScore();
    }
    public boolean isGameOver(){
        return gameOver;
    }
    public Background getBackground(){
        return background;
    }
}