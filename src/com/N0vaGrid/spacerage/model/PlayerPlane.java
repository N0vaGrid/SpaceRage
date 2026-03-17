package com.N0vaGrid.spacerage.model;

import com.N0vaGrid.spacerage.engine.Animation;
import com.N0vaGrid.spacerage.util.ResourceManager;

import java.awt.*;

public class PlayerPlane extends GameObject {

    private int speed = 5;

    private Animation leftAnim;
    private Animation rightAnim;
    private Animation idleAnim;

    private Animation currentAnim;

    private int frame = 0;
    private long lastTime = 0;
    private int delay = 100;

    private boolean isDead = false;

    private State currentState = State.IDLE;

    private enum State {
        IDLE,
        LEFT,
        RIGHT
    }

    public PlayerPlane(int x,int y){

        this.x = x;
        this.y = y;

        leftAnim = new Animation(ResourceManager.PLAYER_LEFT, 100, true);
        rightAnim = new Animation(ResourceManager.PLAYER_RIGHT, 100, true);
        idleAnim = new Animation(new Image[]{ResourceManager.PLAYER_IDLE}, 100, true);

        currentAnim = idleAnim;

        this.width = currentAnim.getCurrentFrame().getWidth(null);
        this.height = currentAnim.getCurrentFrame().getHeight(null);

    }

    public void update(boolean left, boolean right, boolean up, boolean down){

        if(left){x -= speed;}
        if(right){x += speed;}
        if(up){y -= speed;}
        if(down){y += speed;}

        // 状态判断
        Animation newAnim;

        if(left){
            newAnim = leftAnim;
        }else if(right){
            newAnim = rightAnim;
        }else{
            newAnim = idleAnim;
        }

        // 如果状态变化 → 重置动画
        if(newAnim != currentAnim){
            currentAnim = newAnim;
            currentAnim.reset(); //切换动画重置
        }
        // 动画
        currentAnim.update();
    }

    public void update(){

    }

    public void setLocation(int x,int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public void draw(Graphics g) {

        g.drawImage(currentAnim.getCurrentFrame(), x, y, null);
    }

    public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
    public boolean isDead() {
		return isDead;
	}

}