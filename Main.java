import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static char [][] mat = new char[3][3];
    public static int raw,col;
    public static Scanner sc = new Scanner(System.in);


    public static void fill (){
        for (int i = 0 ; i<3 ; i++){
            for (int j = 0 ; j<3 ; j++){
                mat [i][j] = '-' ;
            }
        }
    }

    public static void display (){
        for (int i = 0 ; i<3 ; i++){
            for (int j = 0 ; j<3 ; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static boolean isValid(){
        if (raw>2 || col>2 || raw <0 || col<0) return false ;
        else if (mat[raw][col]== '-') return true;
        else return false;
    }
    public static void play( char turn){
        System.out.println("player "+turn+" please enter raw");
        raw = sc.nextInt() - 1;
        System.out.println("player  "+turn+" please enter col");
        col = sc.nextInt() - 1;
        if (isValid())
            mat[raw][col] = turn;
        else {
            System.out.println("error please enter a valid move !");
            play(turn);
        }


    }
    public static boolean isWinner (){
        if (mat[0][0] == mat[0][1] && mat[0][1] == mat[0][2]&& mat[0][2]!='-')return true;
        else if  (mat[0][0] == mat[1][0] && mat[1][0] == mat[2][0] && mat[2][0]!='-')return true;
        else if  (mat[0][2] == mat[1][2] && mat[1][2] == mat[2][2]&& mat[2][2]!='-')return true;
        else if  (mat[2][0] == mat[2][1] && mat[2][1] == mat[2][2]&& mat[2][2]!='-')return true;
        else if  (mat[0][0] == mat[1][1] && mat[1][1] == mat[2][2]&& mat[2][2]!='-')return true;
        else if  (mat[0][2] == mat[1][1] && mat[1][1] == mat[2][0]&& mat[2][0]!='-')return true;
        else if  (mat[0][1] == mat[1][1] && mat[1][1] == mat[2][1]&& mat[2][1]!='-')return true;
        else if  (mat[1][0] == mat[1][1] && mat[1][1] == mat[1][2]&& mat[1][2]!='-')return true;
        else return false;

    }
    public static void main(String[] args) {
        fill();
        display();
        char turn = 'x';



        for (int i =0 ; i<9 ;i++) {
            play(turn);
            display();
            if (isWinner()){
                System.out.println("cograts player "+ turn + " won");
                break ;}


            if (turn =='x') turn= 'o';
            else turn ='x';

        }

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

       }
}