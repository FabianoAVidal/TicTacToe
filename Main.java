import java.util.Scanner;
public class Main {
    public static boolean testa(String[] valores){
        //Verifica as diagonais
        if((valores[0].equals("X") && valores[4].equals("X") && valores[8].equals("X")) || (valores[0].equals("0") && valores[4].equals("0") && valores[8].equals("0"))){
            System.out.print(valores[0] + " ganhou");
            return true;
        }
        if((valores[2].equals("X") &&  valores[4].equals("X") && valores[6].equals("X")) || (valores[2].equals("0") && valores[4].equals("0") && valores[6].equals("0"))){
            System.out.print(valores[2] + " ganhou");
            return true;
        }
        //Verifica as verticais
        for(int x = 0;x < 9;x+=3){
            if((valores[0+x].equals("X") && valores[1+x].equals("X") && valores[2+x].equals("X")) || (valores[0+x].equals("0") && valores[1+x].equals("0") && valores[2+x].equals("0"))){
                System.out.print(valores[0+x] + " ganhou");
                return true;
            }
        }
        //Verifica as horizontais
        for(int x = 0;x < 3;x++){
            if((valores[0+x].equals("X") && valores[3+x].equals("X") && valores[6+x].equals("X")) || (valores[0+x].equals("0") && valores[3+x].equals("0") && valores[6+x].equals("0"))){
                System.out.print(valores[0+x] + " ganhou");
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String[] jogo = {" ", " ", " ", " ", " ", " ", " ", " ", " ",};
        String[] players = {"X", "0"};
        for(int x = 0;x < 9;x++){
            System.out.print(players[x%2] + ": ");
            int jogadaAtual = read.nextInt();
            while(jogadaAtual < 1 || jogadaAtual > 9 || jogo[jogadaAtual-1] != " "){
                System.out.print("Inválido, digite novamente: ");
                jogadaAtual = read.nextInt();
            }
            if(x % 2 == 0){
                jogo[jogadaAtual-1]  = "X";
            }
            else{
                jogo[jogadaAtual-1] = "0";
            }
            System.out.printf("%s | %s | %s\n%s | %s | %s\n%s | %s | %s\n", jogo[0], jogo[1], jogo[2], jogo[3], jogo[4], jogo[5], jogo[6], jogo[7], jogo[8]);
            if(testa(jogo)){
                break;
            }
            if(!testa(jogo) && x == 8){
                System.out.print("Empatou");
            }
        }
    }
}
