//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        Board brd = new Board();
        brd.setBoard(3,4,9); //zu überprüfende position mit 9 markiert
        brd.setBoard(3,2,2);
        brd.setBoard(1,4,2);
        brd.setBoard(1,2,2);





        brd.printBoard(); //prints Board Matrix in the Console
        System.out.println(checkTarget(3,4,brd));
    }

    //checks how often a specific Position on the Board is targeted by a Queen
    public static int checkTarget(int r, int c, Board brd){ // r-row, c-column, b-board
        int hitnumber = 0;

        //rowcheck
        for (int i = 0; i < brd.getBoard()[r].length; i++) {
            if (brd.getBoard()[r][i] == 2 && i != c) {
                hitnumber++;
            }
        }

        //columncheck
        for (int i = 0; i < brd.getBoard().length; i++) {
            if (brd.getBoard()[i][c] == 2 && i != r) {
                hitnumber++;
            }
        }

        //diagonalcheck





        return hitnumber;
    }


}