/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Cobra.DirecaoCobra;

import java.awt.event.KeyEvent;

/**
 *
 * @author carlo
 */
public enum Direcao
{
    Cima(0, -1, KeyEvent.VK_W, KeyEvent.VK_UP), Baixo(0, 1, KeyEvent.VK_S, KeyEvent.VK_DOWN),
    Esquerda(-1, 0, KeyEvent.VK_A, KeyEvent.VK_LEFT), Direita(1, 0, KeyEvent.VK_D, KeyEvent.VK_RIGHT);

    private final int x;
    private final int y;
    private final int code;
    private final int code2;

    private Direcao(int x, int y, int code, int code2)
    {
        this.x = x;
        this.y = y;
        this.code = code;
        this.code2 = code2;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getCode(boolean cod)
    {
        if (cod)
        {
            return code;
        } else
        {
            return code2;
        }
    }

}
