package com.N0vaGrid.spacerage.service;

public class ScoreService {

    private int score = 0;

    public void addScore(int value){
        score += value;
    }

    public int getScore(){
        return score;
    }

}