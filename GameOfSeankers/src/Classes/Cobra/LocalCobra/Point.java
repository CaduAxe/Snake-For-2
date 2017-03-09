package Classes.Cobra.LocalCobra;

import Classes.Cobra.DirecaoCobra.Direcao;
import java.awt.Graphics;
import sun.tools.jar.CommandLine;

public class Point extends java.awt.Point
{

    Forma forma;

    public Point(int i, int i1)
    {
        super(i, i1);
    }

    public void printCabeca(Graphics g, Direcao direcao, Point antes)
    {
        if (direcao == Direcao.Baixo || direcao == Direcao.Cima)
        {
            g.fillRect(x * 21 + 15, y * 21 + 10, 10, 20);
        } else
        {
            g.fillRect(x * 21 + 10, y * 21 + 15, 20, 10);
        }

    }

    public void printRabo(Graphics g, Point antes)
    {
        if (distancia(antes).x == 0)
        {
            g.fillRect(x * 21 + 17, y * 21 + 10, 6, 20);
        } else
        {
            g.fillRect(x * 21 + 10, y * 21 + 17, 20, 6);
        }
    }

    public void printForma(Graphics g)
    {

        switch (forma)
        {
            case CimaBaixo:
                g.fillRect(x * 21 + 17, y * 21 + 10, 6, 20);
                break;

            case EsquerdaDireita:
                g.fillRect(x * 21 + 10, y * 21 + 17, 20, 6);
                break;

            case BaixoDireita:
                g.fillRect(x * 21 + 10 + 7, y * 21 + 20, 6, 10);//Baixo
                g.fillRect(x * 21 + 10, y * 21 + 17, 10, 6);//Direita
                break;

            case BaixoEsquerda:
                g.fillRect(x * 21 + 10 + 7, y * 21 + 20, 6, 10);//Baixo
                g.fillRect(x * 21 + 10 + 14, y * 21 + 17, 10, 6);//Esquerda
                break;

            case CimaDireita:
                g.fillRect(x * 21 + 17, y * 21 + 10, 6, 10);//Cima
                g.fillRect(x * 21 + 10, y * 21 + 17, 10, 6);//Direita
                break;

            case CimaEsquerda:
                g.fillRect(x * 21 + 17, y * 21 + 10, 6, 10);//Cima
                g.fillRect(x * 21 + 10 + 14, y * 21 + 17, 10, 6);//Esquerda
                break;

            case Cabeca:
                g.fillRect(x * 21 + 15, y * 21 + 10, 5, 20);
                break;
        }

    }

    public void setForma(Point antes, Point depois)
    {
        if (distancia(antes).x == 0 && distancia(depois).x == 0)
        {
            forma = Forma.CimaBaixo;
        } else if (distancia(antes).y == 0 && distancia(depois).y == 0)
        {
            forma = Forma.EsquerdaDireita;
        } else
        {
            if (distancia(antes).x < 0)
            {
                if (distancia(depois).y < 0)
                {
                    forma = Forma.BaixoEsquerda;
                }

                if (distancia(depois).y > 0)
                {
                    forma = Forma.CimaEsquerda;
                }

            }
            if (distancia(depois).x < 0)
            {
                if (distancia(antes).y < 0)
                {
                    forma = Forma.BaixoEsquerda;
                }

                if (distancia(antes).y > 0)
                {
                    forma = Forma.CimaEsquerda;
                }

            }

            if (distancia(antes).x > 0)
            {
                if (distancia(depois).y < 0)
                {
                    forma = Forma.BaixoDireita;
                }

                if (distancia(depois).y > 0)
                {
                    forma = Forma.CimaDireita;
                }

            }
            if (distancia(depois).x > 0)
            {
                if (distancia(antes).y < 0)
                {
                    forma = Forma.BaixoDireita;
                }

                if (distancia(antes).y > 0)
                {
                    forma = Forma.CimaDireita;
                }

            }

        }

    }

    private Point distancia(Point p)
    {
        return new Point(x - p.x, y - p.y);
    }
}
