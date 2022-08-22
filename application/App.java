package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.JogoDaVelha;
import entities.JogoDaVelhaException;
import enums.Jogador;

public class App {
    public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
        
        int l,c, count = 1;
        String M[][] = new String[3][3];
        
        System.out.println();
        for(int i=0; i<3;i++){
            for(int j=0;j<3;j++){
                M[i][j] = "_";
            }
        }

        JogoDaVelha jdv = new JogoDaVelha();
        
        while(count > 0 && jdv.corteVitoria(M) == false){
            try{
                for(int i=0; i<3;i++){
                    for(int j=0;j<3;j++){
                        if(j<2)System.out.print(M[i][j] + " ");
                        else System.out.println(M[i][j] + " ");
                        if(M[i][j].equals("_")) count++;
                    }
                }
                
                System.out.println("\nTurno " + jdv.getTurno());
                System.out.println("Esperando " + jdv.getJogadorAtual() + ":");
                System.out.print("\nlinha: ");
                l = sc.nextInt();
                System.out.print("coluna: ");
                c = sc.nextInt();
                
                if(l<0 || l>2 || c<0 || c>2) throw new JogoDaVelhaException("Escolha uma posição de 0 a 2!");
                else if(M[l][c] != "_") throw new JogoDaVelhaException ("Escolha outra posição!");
                else M[l][c] = (jdv.getJogadorAtual() == Jogador.Jogador_1) ?  "X": "O";

                System.out.println();
                
                count = 0;
                for(int i=0; i<3;i++){
                    for(int j=0;j<3;j++){
                        if(M[i][j].equals("_")) count++;
                    }
                }
                
                if(jdv.corteVitoria(M) == false)
                jdv.nextTurno();
                /*clearScreen();*/
                
            }
            catch(InputMismatchException e){
                System.out.println("\nInforme um número inteiro de 0 a 2!\n");
                sc.next();
            }
            catch(JogoDaVelhaException e){
                System.out.println("\n" + e.getMessage() + "\n");
                sc.nextLine();
            }
            catch(RuntimeException exception){
                System.out.println("\nErro inesperado!!\n");
                sc.nextLine();
            }
            
        }
        if(count==0) System.out.println("\nVelha!!\n");
        if(jdv.corteVitoria(M)) System.out.println(jdv.getJogadorAtual() + " venceu!\n");
        sc.close();
    }
    
    public static void clearScreen() { 
		System.out.print("\033[H\033[2J"); 
		System.out.flush(); 
    }
    
}
