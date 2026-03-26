package com.n0vaGrid.spacerage.ecs.component;
import com.n0vaGrid.spacerage.engine.Animation;

public class AnimationComponent implements Component {

    public Animation idle;
    public Animation left;
    public Animation right;

    public Animation current;

    // 多动画（玩家、敌人）
    public AnimationComponent(Animation idle, Animation left, Animation right){
        this.idle = idle;
        this.left = left;
        this.right = right;

        this.current = idle;
    }
    // 单动画（爆炸、特效）
    public AnimationComponent(Animation animation){
        this.current = animation;
    }
}