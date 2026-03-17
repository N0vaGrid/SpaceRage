package com.N0vaGrid.spacerage.util;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.IOException;

public class ResourceManager {

    public static Image PLAYER_IDLE;
    public static Image BULLET;
    public static Image BG;
    public static Image ENEMY;
    public static Image[] EXPLOSIONS;
    public static Image[] PLAYER_LEFT;
    public static Image[] PLAYER_RIGHT;

    static {
        try {
            PLAYER_IDLE = ImageIO.read(
                    ResourceManager.class.getResource("/resources/images/Player/player_b_m.png")
            );

            BULLET = ImageIO.read(
                    ResourceManager.class.getResource("/resources/images/FX/exhaust_01.png")
            );
            ENEMY = ImageIO.read(
                    ResourceManager.class.getResource("/resources/images/Enemies/enemy_1_b_m.png")
            );
            BG = ImageIO.read(
                    ResourceManager.class.getResource("/resources/images/BG.png")
            );

            EXPLOSIONS = new Image[10];

           for(int i = 0; i < 10; i++){
                EXPLOSIONS[i] = ImageIO.read(
                        ResourceManager.class.getResource("/resources/images/Explosions/explosion_1_0"+(i+1)+".png")
                );
            }
           PLAYER_LEFT = new Image[2];
           PLAYER_RIGHT = new Image[2];

            for (int i = 0; i < 2; i++) {
                PLAYER_LEFT[i] = ImageIO.read(
                        ResourceManager.class.getResource("/resources/images/Player/player_b_l"+(i+1)+".png")
                );
                PLAYER_RIGHT[i] = ImageIO.read(
                        ResourceManager.class.getResource("/resources/images/Player/player_b_r"+(i+1)+".png")
                );
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}