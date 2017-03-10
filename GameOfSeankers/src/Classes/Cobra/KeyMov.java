/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Cobra;

import java.awt.event.KeyEvent;

/**
 *
 * @author carlo
 */
public enum KeyMov
{
    WASD(KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D),
    Arrays(KeyEvent.VK_UP, KeyEvent.VK_LEFT, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT);

    private final int UP, LEFT, DOWN, RIGHT;

    private KeyMov(int UP, int LEFT, int DOWN, int RIGHT)
    {
        this.UP = UP;
        this.LEFT = LEFT;
        this.DOWN = DOWN;
        this.RIGHT = RIGHT;
    }

    public int getUP()
    {
        return UP;
    }

    public int getLEFT()
    {
        return LEFT;
    }

    public int getDOWN()
    {
        return DOWN;
    }

    public int getRIGHT()
    {
        return RIGHT;
    }

}
