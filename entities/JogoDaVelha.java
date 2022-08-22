package entities;

import enums.Jogador;

public class JogoDaVelha {
    private int turno;
    private Jogador jogadorAtual;
    
    public JogoDaVelha() {
        turno = 1;
        jogadorAtual = Jogador.Jogador_1;
    }

    public int getTurno() {
        return turno;
    }

    public Jogador getJogadorAtual() {
        return jogadorAtual;
    }

    public void nextTurno() {
		turno++; 
		jogadorAtual = (jogadorAtual == Jogador.Jogador_1) ? Jogador.Jogador_2 : Jogador.Jogador_1;
	}

    public boolean corteVitoria(String M[][]){
        if(M[0][0].equals(M[0][1]) && M[0][0].equals(M[0][2]) && M[0][0] != "_")  return true;
        else if(M[1][0].equals(M[1][1]) && M[1][0].equals(M[1][2]) && M[1][0] != "_") return true;
        else if(M[2][0].equals(M[2][1]) && M[2][0].equals(M[2][2]) && M[2][1] != "_") return true;
        else if(M[0][0].equals(M[1][0]) && M[0][0].equals(M[2][0]) && M[0][0] != "_") return true;
        else if(M[0][1].equals(M[1][1]) && M[0][1].equals(M[2][1]) && M[0][1] != "_") return true;
        else if(M[0][2].equals(M[1][2]) && M[0][2].equals(M[2][2]) && M[0][2] != "_") return true;
        else if(M[0][0].equals(M[1][1]) && M[0][0].equals(M[2][2]) && M[0][0] != "_") return true;
        else if(M[0][2].equals(M[1][1]) && M[0][2].equals(M[2][0]) && M[0][2] != "_") return true;
        
        return false;
    }
}
