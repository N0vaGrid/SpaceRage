package com.N0vaGrid.spacerage.service;
import com.N0vaGrid.spacerage.model.Explosion;

import java.util.ArrayList;
import java.util.List;

public class ExplosionService {

    private List<Explosion> explosions = new ArrayList<>();

    public void addExplosion(int x,int y){
        explosions.add(new Explosion(x,y));
    }

    public void update(){

        for(int i=0;i<explosions.size();i++){

            Explosion e = explosions.get(i);

            e.update();

            if(e.isDead()){
                explosions.remove(i);
                i--;
            }
        }
    }

    public List<Explosion> getExplosions(){
        return explosions;
    }

}