package com.N0vaGrid.spacerage.controller;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class InputController implements KeyListener {

    public boolean left;
    public boolean right;
    public boolean up;
    public boolean down;
    public boolean shoot;

    @Override
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode()){

            case KeyEvent.VK_LEFT:
                left = true;
                break;

            case KeyEvent.VK_RIGHT:
                right = true;
                break;

            case KeyEvent.VK_UP:
                up = true;
                break;

            case KeyEvent.VK_DOWN:
                down = true;
                break;

            case KeyEvent.VK_SPACE:
                shoot = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch(e.getKeyCode()){

            case KeyEvent.VK_LEFT:
                left = false;
                break;

            case KeyEvent.VK_RIGHT:
                right = false;
                break;

            case KeyEvent.VK_UP:
                up = false;
                break;

            case KeyEvent.VK_DOWN:
                down = false;
                break;

            case KeyEvent.VK_SPACE:
                shoot = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

}