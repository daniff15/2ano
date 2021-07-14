package lab03.ex1;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class JGaloGame implements JGaloInterface{
    private char jogadorAtual;
    private char[][] board;
    private char vencedor = ' ';
    private int jogadas = 0;

    public JGaloGame(char jogadorAtual) {
        this.jogadorAtual = jogadorAtual;
        this.board = new char[3][3];
    }

    @Override
    public char getActualPlayer(){
        return jogadorAtual;
    }

    @Override
	public boolean setJogada(int lin, int col){
        lin--;
        col--;
        if (board[lin][col]=='\u0000') {
            board[lin][col] = jogadorAtual;
            if (jogadorAtual == 'o')
                jogadorAtual = 'x';
            else
                jogadorAtual = 'o';

            jogadas++;
            return true;
        }
        return false;
    }

    @Override
	public boolean isFinished(){
        

        for (int inicio = 0; inicio < 3; inicio++) {
                if(board[inicio][0] == board[inicio][1] && board[inicio][1] == board[inicio][2] && board[inicio][2] !='\u0000'){
                    vencedor = board[inicio][0];
                }
                if(board[0][inicio] == board[1][inicio] && board[1][inicio] == board[2][inicio] && board[2][inicio]!='\u0000')
                    vencedor = board[0][inicio];
        }

        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2]!='\u0000')
            vencedor = board[0][0];

        if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0]!='\u0000')
            vencedor = board[0][2]; 

        if (vencedor != ' ' || jogadas==9){
            return true;
        }
        return false;
    }

	public char checkResult(){
        return vencedor;
    }

}