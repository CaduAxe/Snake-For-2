package Classes.Cobra;

import Classes.Cobra.LocalCobra.Point;
import Classes.Cobra.DirecaoCobra.Direcao;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Cobra
{

    private Color cor;

    private Direcao direcao = Direcao.Direita;
    private final ArrayList<Point> locais = new ArrayList<>();

    private boolean comeu = false;
    private Point novoRabo = null;

    private boolean dead = false;
    private boolean virar = false;

    private boolean um;

    public Cobra(Color cor, boolean um)
    {
        if (um)
        {
            locais.add(new Point(1, 3));
            locais.add(new Point(0, 3));
        } else
        {
            locais.add(new Point(1, 17));
            locais.add(new Point(0, 17));

        }
        this.cor = cor;
        this.um = um;
    }

    public void move()
    {

        //     locais.forEach((local) -> local.translate(getDirecao().getX(), getDirecao().getY()));
        if (locais.size() >= 1)
        {
            for (int i = locais.size() - 1; i > 0; i--)
            {
                locais.set(i, (Point) locais.get(i - 1).clone());
            }
            getCabecaLocal().translate(getDirecao().getX(), getDirecao().getY());

            if (comeu)
            {
                if (novoRabo == null)
                {
                    novoRabo = ((Point) locais.get(locais.size() - 1).clone());
                } else
                {
                    locais.add((Point) novoRabo.clone());
                    novoRabo = null;

                    comeu = false;
                }
            }
        }
    }

    public Direcao getDirecao()
    {
        return direcao;
    }

    public void alterDirecao(int tecla)
    {
        if (!virar && tecla != direcao.getCode(um))
        {
            virar = true;
            if (um)
            {
                switch (tecla)
                {
                    case KeyEvent.VK_W:
                        if (direcao != Direcao.Baixo)
                        {
                            direcao = Direcao.Cima;
                        }
                        break;
                    case KeyEvent.VK_A:
                        if (direcao != Direcao.Direita)
                        {
                            direcao = Direcao.Esquerda;
                        }
                        break;
                    case KeyEvent.VK_S:
                        if (direcao != Direcao.Cima)
                        {
                            direcao = Direcao.Baixo;
                        }
                        break;
                    case KeyEvent.VK_D:
                        if (direcao != Direcao.Esquerda)
                        {
                            direcao = Direcao.Direita;
                        }
                        break;
                    default:
                        virar = false;
                }
            } else
            {
                switch (tecla)
                {
                    case KeyEvent.VK_UP:
                        if (direcao != Direcao.Baixo)
                        {
                            direcao = Direcao.Cima;
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (direcao != Direcao.Direita)
                        {
                            direcao = Direcao.Esquerda;
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (direcao != Direcao.Cima)
                        {
                            direcao = Direcao.Baixo;
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (direcao != Direcao.Esquerda)
                        {
                            direcao = Direcao.Direita;
                        }
                        break;
                    default:
                        virar = false;
                }

            }
        }
    }

    public void NoMapa(Cobra adversario)
    {
        Point simulation = (Point) getCabecaLocal().clone();
        simulation.translate(getDirecao().getX(), getDirecao().getY());
        if (!new Rectangle(0, 0, 20, 20).contains(simulation)
                || getLocais().subList(1, getLocais().size() - 1).contains(simulation)
                || adversario.getLocais().subList(1, adversario.getLocais().size() - 1).contains(simulation))
        {
            dead();

        } else if (simulation.equals(adversario.getCabecaLocal()))
        {
            if (adversario.getLocais().size() >= getLocais().size())
            {
                System.out.println("asd");
                dead();
                if(adversario.getLocais().size() == getLocais().size()){
                    adversario.dead();
                }
            }
        } else
        {
            move();

        }
    }

    public Point getCabecaLocal()
    {
        return locais.get(0);
    }

    void dead()
    {
        dead = true;
        cor = new Color(255,0,0);
    }

    public boolean isDead()
    {
        return dead;
    }

    public ArrayList<Point> getLocais()
    {
        return locais;
    }

    public boolean isComeu()
    {
        return comeu;
    }

    public void comer()
    {
        this.comeu = true;
    }

    public void refreshVirar()
    {
        virar = false;
    }

    public boolean isVirar()
    {
        return virar;
    }

    public Color getCor()
    {
        return cor;
    }

}
