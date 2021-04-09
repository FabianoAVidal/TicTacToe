import java.util.Scanner;

public class Main {
    public static void showGame(int[] plays){
        for(int play = 1;play <= 9;play++){
            System.out.print(" " + (plays[play-1] == 0 ? " " : (plays[play-1] == 4 ? "X" : "O")) + " |");
            System.out.print(play % 3 == 0 ? "\n" : "");
        }
    }
    public static boolean test(int[] plays, int value){
        //Check horizontal
        for(int x = 0;x < 9;x+=3){
            if(plays[x]+plays[x+1]+plays[x+2] == value*3){
                return true;
            }
        }
        //Check vertical
        for(int x = 0;x < 3;x++){
            if(plays[x]+plays[x+3]+plays[x+6] == value*3){
                return true;
            }
        }
        return(plays[0] + plays[4] + plays[8]) == value * 3 || (plays[2] + plays[4] + plays[6]) == value * 3;
    }
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int[] plays = new int[9];
        int currentPlay, player;
        for(int x = 0;x < 9;x++){
            player = x % 2 == 0 ? 4 : 5;
            System.out.print(x % 2 == 0 ? "\nX: " : "\nO: ");
            currentPlay = read.nextInt();
            while(plays[currentPlay-1] != 0 || currentPlay < 1 || currentPlay > 9){
                System.out.print("Inválid cell, try again: ");
                currentPlay = read.nextInt();
            }
            plays[currentPlay-1] = player;
            showGame(plays);
            if(test(plays, player) && x > 3){
                System.out.println((player == 4 ? "X" : "O") + " win!");
                break;
            }
            if(!test(plays, player) && x == 8){
                System.out.println("A tie!");
            }
        }
    }
}