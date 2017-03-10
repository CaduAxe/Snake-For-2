package Classes.Cobra;

import Classes.Cobra.DirecaoCobra.Direcao;
import java.awt.Color;

public class Player extends Cobra
{

    final int UP, DOWN, LEFT, RIGHT; //Buttons

    public Player(KeyMov keyMov, Color cor, boolean um)
    {
        super(cor, um);
        this.UP = keyMov.getUP();
        this.DOWN = keyMov.getDOWN();
        this.LEFT = keyMov.getLEFT();
        this.RIGHT = keyMov.getRIGHT();
    }

    @Override
    public void alterDirecao(int tecla)
    {
        super.alterDirecao(tecla);
        if (!virar)
        {
            virar = true;

            if (direcao != Direcao.Baixo && tecla == UP)
            {
                direcao = Direcao.Cima;
            } else if (direcao != Direcao.Direita && tecla == LEFT)
            {
                direcao = Direcao.Esquerda;
            } else if (direcao != Direcao.Cima && tecla == DOWN)
            {
                direcao = Direcao.Baixo;
            } else if (direcao != Direcao.Esquerda && tecla == RIGHT)
            {
                direcao = Direcao.Direita;
            } else
            {
                virar = false;
            }
        }

    }
}
