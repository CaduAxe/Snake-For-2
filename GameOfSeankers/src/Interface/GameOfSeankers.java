/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Classes.Mapa.Mapa;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author carlo
 */
public class GameOfSeankers extends JPanel
{

    private static GameOfSeankers gameOfSeankers;
    Mapa mapa = new Mapa();

    public static void main(String[] args)
    {
        getInstance().setFrame();
    }

    private GameOfSeankers()
    {
        setBackground(new Color(47, 79, 79));

    }

    public static GameOfSeankers getInstance()
    {
        if (gameOfSeankers == null)
        {
            gameOfSeankers = new GameOfSeankers();
        }
        return gameOfSeankers;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.

        printMapa(g);

        printCobraAzul(g);
        printCobraVermelha(g);
        
        
        printComida(g);


    }

    private void setFrame()
    {
        JFrame a = new JFrame();
        a.setContentPane(GameOfSeankers.getInstance());
        a.setSize(460, 480);
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent ke)
            {
                mapa.getCobraAzul().alterDirecao(ke.getKeyCode());
                mapa.getCobraVermelha().alterDirecao(ke.getKeyCode());
            }

        }
        );
    }

    private void printMapa(Graphics g)
    {
        g.setColor(new Color(46, 139, 87));
        for (int i = 0; i < 20; i++)
        {
            for (int j = 0; j < 20; j++)
            {
                g.fillRect(i * 21 + 10, j * 21 + 10, 20, 20);
            }
        }
    }

    private void printCobraAzul(Graphics g)
    {
        g.setColor(mapa.getCobraAzul().getCor());

        for (int i = 0; i < mapa.getCobraAzul().getLocais().size(); i++)
        {
            if (i == 0 || i == mapa.getCobraAzul().getLocais().size() - 1)
            {
                if (i == 0)
                {
                    mapa.getCobraAzul().getCabecaLocal().printCabeca(g, mapa.getCobraAzul().getDirecao(), mapa.getCobraAzul().getLocais().get(1));
                }else {
                    mapa.getCobraAzul().getLocais().get(i).printRabo(g, mapa.getCobraAzul().getLocais().get(i-1));
                }

            } else
            {
                mapa.getCobraAzul().getLocais().get(i).setForma(mapa.getCobraAzul().getLocais().get(i - 1), mapa.getCobraAzul().getLocais().get(i + 1));
                mapa.getCobraAzul().getLocais().get(i).printForma(g);
            }
        }

    }

    private void printCobraVermelha(Graphics g)
    {
            g.setColor(mapa.getCobraVermelha().getCor());

        for (int i = 0; i < mapa.getCobraVermelha().getLocais().size(); i++)
        {
            if (i == 0 || i == mapa.getCobraVermelha().getLocais().size() - 1)
            {
                if (i == 0)
                {
                         mapa.getCobraVermelha().getCabecaLocal().printCabeca(g, mapa.getCobraVermelha().getDirecao(), mapa.getCobraVermelha().getLocais().get(1));
           }else {
                    mapa.getCobraVermelha().getLocais().get(i).printRabo(g, mapa.getCobraVermelha().getLocais().get(i-1));
                }

            } else
            {
                mapa.getCobraVermelha().getLocais().get(i).setForma(mapa.getCobraVermelha().getLocais().get(i - 1), mapa.getCobraVermelha().getLocais().get(i + 1));
                mapa.getCobraVermelha().getLocais().get(i).printForma(g);
            }
        }}

    private void printComida(Graphics g)
    {
        g.setColor(Color.WHITE);
        if (mapa.getComida() != null)
        {
            g.fillOval(mapa.getComida().x * 21 + 15, mapa.getComida().y * 21 + 15, 10, 10);
        }
    }

}
