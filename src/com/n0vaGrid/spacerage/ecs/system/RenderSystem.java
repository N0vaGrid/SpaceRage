package com.n0vaGrid.spacerage.ecs.system;

import com.n0vaGrid.spacerage.config.Config;
import com.n0vaGrid.spacerage.ecs.component.*;
import com.n0vaGrid.spacerage.ecs.entity.Entity;
import com.n0vaGrid.spacerage.ui.Star;
import com.n0vaGrid.spacerage.util.ResourceManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RenderSystem {

    private int backgroundY = 0;
    // 滚动速度
    private int scrollSpeed = 2;

    private List<Star> stars = new ArrayList<>();
    private Random random = new Random();

    public RenderSystem(){
        //绘制星星
        for(int i = 0; i < 120; i++){

            int x = random.nextInt(Config.WIDTH);
            int y = random.nextInt(Config.HEIGHT);

            int layer = random.nextInt(3);

            int speed;
            int size;

            if(layer == 0){
                speed = 1;   // 远处
                size = 1;
            }
            else if(layer == 1){
                speed = 2;   // 中层
                size = 2;
            }
            else{
                speed = 2;   // 近处
                size = 3;
            }

            stars.add(new Star(x, y, speed, size));
        }
    }

    public void render(ComponentManager cm, Graphics g){

        //绘制背景

        Image bg = ResourceManager.BG;

        backgroundY += scrollSpeed;

        if(backgroundY >= bg.getHeight(null)){
            backgroundY = 0;
        }

        g.drawImage(bg, 0, backgroundY - bg.getHeight(null), null);
        g.drawImage(bg, 0, backgroundY, null);

        //绘制星星
        g.setColor(Color.white);

        for(Star s : stars){

            if(s.size == 1)
                g.setColor(new Color(150,150,150));
            else if(s.size == 2)
                g.setColor(new Color(200,200,200));
            else
                g.setColor(Color.WHITE);

            s.y += s.speed;

            if(s.y > Config.HEIGHT){
                s.y = -10;
                s.x = random.nextInt(Config.WIDTH);
            }

            //闪烁
            s.twinkleTimer++;

            if(s.twinkleTimer > s.twinkleDelay){

                s.twinkleTimer = 0;
                s.twinkleDelay = 30 + random.nextInt(60);

            }

            //绘制星星
            if(s.size == 1){

                if(s.twinkleTimer < s.twinkleDelay / 2)
                    g.fillRect(s.x, s.y, s.size, s.size);

            }else{

                g.fillRect(s.x, s.y, s.size, s.size);

            }

        }

        //绘制游戏对象

        for(Entity e : cm.getEntities(SpriteComponent.class)){

            PositionComponent p = cm.getComponent(e, PositionComponent.class);
            SpriteComponent s = cm.getComponent(e, SpriteComponent.class);
            ColliderComponent collider = cm.getComponent(e, ColliderComponent.class);

            if(s != null){
                g.drawImage(s.image, p.x, p.y, s.width, s.height, null);
            }


            // 绘制碰撞器
            if(collider != null){
                //g.drawRect(p.x,p.y,collider.width,collider.height);
            }
        }
    }
}