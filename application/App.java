package application;

import java.util.Scanner;

import entities.JogoDaVelha;
import enums.Jogador;

public class App {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String M[][] = new String[3][3];

        System.out.println();

        for(int i=0; i<3;i++){
            for(int j=0;j<3;j++){
                M[i][j] = "_";
            }
        }

        for(int i=0; i<3;i++){
            for(int j=0;j<3;j++){
                if(j<2)System.out.print(M[i][j] + " ");
                else System.out.println(M[i][j] + " ");
            }
        }
        
        JogoDaVelha jdv = new JogoDaVelha();

        int l,c, count = 0;
        
        do{
            System.out.println("\nTurno " + jdv.getTurno());
            System.out.println("Esperando " + jdv.getJogadorAtual() + ":");
            System.out.print("\nlinha: ");
            l=sc.nextInt();
            System.out.print("coluna: ");
            c=sc.nextInt();
            if(M[l][c] == "_") {
            M[l][c]= (jdv.getJogadorAtual() == Jogador.Jogador_1) ?  "X": "O";
            jdv.nextTurno();
            }
            else System.out.println("\nEscolha outra posição!");
            System.out.println();
            count = 0;
            for(int i=0; i<3;i++){
                for(int j=0;j<3;j++){
                    if(j<2)System.out.print(M[i][j] + " ");
                    else System.out.println(M[i][j] + " ");
                    if(M[i][j].equals("_")) count++;
                }
            }
        }
        while(count>0 && jdv.corteVitoria(M)==false);
        if(count==0) System.out.println("\nVelha!!\n");
        if(jdv.corteVitoria(M)) System.out.println("\n" + jdv.getJogadorAtual() + " venceu!\n");
        sc.close();
    }
    
    /*public static boolean corteVitoria(String M[][]){
        if(M[0][0].equals(M[0][1]) && M[0][0].equals(M[0][2]) && M[0][0] != "_")  return true;
        else if(M[1][0].equals(M[1][1]) && M[1][0].equals(M[1][2]) && M[1][0] != "_") return true;
        else if(M[2][0].equals(M[2][1]) && M[2][0].equals(M[2][2]) && M[2][1] != "_") return true;
        else if(M[0][0].equals(M[1][0]) && M[0][0].equals(M[2][0]) && M[0][0] != "_") return true;
        else if(M[0][1].equals(M[1][1]) && M[0][1].equals(M[2][1]) && M[0][1] != "_") return true;
        else if(M[0][2].equals(M[1][2]) && M[0][2].equals(M[2][2]) && M[0][2] != "_") return true;
        else if(M[0][0].equals(M[1][1]) && M[0][0].equals(M[2][2]) && M[0][0] != "_") return true;
        else if(M[0][2].equals(M[1][1]) && M[0][2].equals(M[2][0]) && M[0][2] != "_") return true;
        
        return false;
    }*/
    
}
