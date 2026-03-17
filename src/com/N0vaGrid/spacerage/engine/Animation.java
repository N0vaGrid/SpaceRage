package com.N0vaGrid.spacerage.engine;

import java.awt.Image;

public class Animation {

    private Image[] frames;

    private int frameIndex = 0;

    private long lastTime = 0;
    private int delay;

    private boolean loop;
    private boolean finished = false;

    public Animation(Image[] frames, int delay, boolean loop){

        this.frames = frames;
        this.delay = delay;
        this.loop = loop;

    }

    public void update(){

        if(finished) return;

        long current = System.currentTimeMillis();

        if(current - lastTime < delay){
            return;
        }

        lastTime = current;

        frameIndex++;

        if(frameIndex >= frames.length){

            if(loop){
                frameIndex = 0;
            }else{
                frameIndex = frames.length - 1;
                finished = true;
            }
        }
    }

    public Image getCurrentFrame(){
        return frames[frameIndex];
    }

    public boolean isFinished(){
        return finished;
    }

    public void reset(){
        frameIndex = 0;
        finished = false;
    }
}