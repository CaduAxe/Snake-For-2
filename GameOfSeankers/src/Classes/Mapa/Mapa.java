/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Mapa;

import Classes.Cobra.Cobra;
import Classes.Cobra.KeyMov;
import Classes.Cobra.Player;
import Interface.GameOfSeankers;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import javax.swing.Timer;

/**
 *
 * @author carlo
 */
public class Mapa
{

    ArrayList<Point> points = new ArrayList<>();

    private final Cobra cobraAzul = new Player(KeyMov.WASD, new Color(135, 206, 250), true);
    private final Cobra cobraVermelha = new Player(KeyMov.Arrays, new Color(255, 160, 122), false);

    private final boolean repintar = true;

    private Point comida;

    public Mapa()
    {
        for (int i = 0; i < 20; i++)
        {
            for (int j = 0; j < 20; j++)
            {
                points.add(new Point(i, j));
            }
        }
        timerMov.start();
        timerCom.start();
    }

    public boolean InMapAzul()
    {
        cobraAzul.NoMapa(cobraVermelha);

        if (comida != null)
        {
            if (cobraAzul.getCabecaLocal().distance(comida) == 0d)
            {
                cobraAzul.comer();
                comida = null;
                timerCom.restart();
            }

        }
        return !cobraAzul.isDead();
    }

    public boolean InMapVermelho()
    {
        cobraVermelha.NoMapa(cobraAzul);

        if (comida != null)
        {
            if (cobraVermelha.getCabecaLocal().distance(comida) == 0d)
            {
                cobraVermelha.comer();
                comida = null;
                timerCom.restart();
            }
        }

        return !cobraVermelha.isDead();
    }

    boolean test = true;

    public ArrayList<Point> getVoidPoints()
    {
        ArrayList<Point> vazios = new ArrayList<>(
                points.stream().filter((t)
                        ->
                {
                    test = true;
                    cobraAzul.getLocais().forEach((Point r)
                            ->
                    {
                        if (t.getLocation().equals(r.getLocation()))
                        {

                            test = false;
                        }
                    });

                    cobraVermelha.getLocais().forEach((Point r)
                            ->
                    {
                        if (t.getLocation().equals(r.getLocation()))
                        {

                            test = false;
                        }
                    });

                    return test; //To change body of generated lambdas, choose Tools | Templates.
                }).collect(Collectors.toList()));
        return vazios;
    }

    public void gerarComida()
    {
        comida = getVoidPoints().get(new Random().nextInt(getVoidPoints().size()));
    }

    Timer timerMov = new Timer(150, new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            InMapVermelho();
            InMapAzul();
            if (cobraAzul.isDead() || cobraVermelha.isDead())
            {
                timerMov.stop();
                timerCom.stop();

            }
            cobraAzul.refreshVirar();
            cobraVermelha.refreshVirar();
            GameOfSeankers.getInstance().repaint();
        }
    });

    Timer timerCom = new Timer(3000, new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            gerarComida();
            timerCom.stop();
            GameOfSeankers.getInstance().repaint();
        }
    });

    public Cobra getCobraAzul()
    {
        return cobraAzul;
    }

    public Point getComida()
    {
        return comida;
    }

    public Cobra getCobraVermelha()
    {
        return cobraVermelha;
    }

}
