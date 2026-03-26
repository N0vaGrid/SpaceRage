package com.n0vaGrid.spacerage.ecs.entity;

import com.n0vaGrid.spacerage.ecs.component.*;
import com.n0vaGrid.spacerage.engine.Animation;
import com.n0vaGrid.spacerage.util.ResourceManager;

import javax.swing.text.Position;
import java.awt.*;

public class EntityFactory {

    private EntityManager em;
    private ComponentManager cm;

    public EntityFactory(EntityManager entityManager, ComponentManager componentManager) {
        em = entityManager;
        cm = componentManager;
    }
    public Entity createPlayer(){

        Entity player = new Entity();
        em.addEntity(player);

        // 位置
        cm.addComponent(player, new PositionComponent(200, 600));
        // 速度
        cm.addComponent(player, new VelocityComponent(0, 0));
        // 图片
        cm.addComponent(player, new SpriteComponent(
                ResourceManager.PLAYER_IDLE, 64, 64
        ));

        // 动画
        Animation idle = new Animation(
                new Image[]{ResourceManager.PLAYER_IDLE},
                200,
                true
        );

        Animation left = new Animation(
                ResourceManager.PLAYER_LEFT,
                120,
                 false
        );

        Animation right = new Animation(
                ResourceManager.PLAYER_RIGHT,
                120,
                false
        );

        //回正动画
        Image[] leftReturnFrames = new Image[]{
                ResourceManager.PLAYER_LEFT[1],
                ResourceManager.PLAYER_LEFT[0],
                ResourceManager.PLAYER_IDLE
        };
        Animation leftReturn = new Animation(leftReturnFrames,120,false);
        Image[] rightReturnFrames = new Image[]{
                ResourceManager.PLAYER_RIGHT[1],
                ResourceManager.PLAYER_RIGHT[0],
                ResourceManager.PLAYER_IDLE
        };
        Animation rightReturn = new Animation(rightReturnFrames,120,false);

        AnimationComponent anim =
                new AnimationComponent(idle, left, right);
        anim.leftReturn = leftReturn;
        anim.rightReturn = rightReturn;

        cm.addComponent(player, anim);


        // 碰撞器
        cm.addComponent(player, new ColliderComponent(64, 64));
        cm.addComponent(player, new PlayerComponent());

        return player;
    }

    public Entity createEnemy() {

        Entity enemy = new Entity();
        em.addEntity(enemy);

        int x = (int)(Math.random() * 700) + 50;
        int y = -50;

        // 位置
        cm.addComponent(enemy,
                new PositionComponent(x, y));

        // 速度（向下移动）
        cm.addComponent(enemy,
                new VelocityComponent(0, 2));

        // 图片
        cm.addComponent(enemy,
                new SpriteComponent(ResourceManager.ENEMY , 64, 64));

        // 碰撞器
        cm.addComponent(enemy, new ColliderComponent(64, 64));

        // 标记这是敌人
        cm.addComponent(enemy,
                new EnemyComponent());

        return enemy;
    }

/*    public Entity createExplosion(int x, int y){

    }*/

    public Entity createBullet(int x ,int y){

        Entity bullet = new Entity();
        em.addEntity(bullet);

        cm.addComponent(bullet, new PositionComponent(x, y));
        cm.addComponent(bullet, new VelocityComponent(0, -8));

        cm.addComponent(bullet, new SpriteComponent(
                ResourceManager.BULLET, 64, 64
        ));

        cm.addComponent(bullet, new ColliderComponent(64, 64));
        cm.addComponent(bullet, new BulletComponent());

        return bullet;
    }
}
