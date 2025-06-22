//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        Board brd = new Board();

        //------------------------------------------------------------------------------//
        //Buchstaben von test ändern für die Verschiedenen Aufgaben:

        char test = 'a';
        //'a' -> AUFGABE 1+2    [Joshua]
        //'b' -> AUFGABE 3+4    [Marlon]
        //Last Update: 22.6.2025 19:40
        //------------------------------------------------------------------------------//



        if (test == 'a')
        {
            brd.setBoard(3,4,2); //zu überprüfende position
            brd.setBoard(3,2,2);
            brd.setBoard(0,4,2);
            brd.setBoard(1,2,2);
            brd.setBoard(1,6,2);
            brd.setBoard(5,2,2);


            brd.printBoard(); //prints Board Matrix
            System.out.println("Hits: " + checkTarget(3,4,brd)); //Prints how often the given Target is being targeted
        }
        else if (test == 'b')
        {
            // AUFGABE 3 & 4
            solveQueens(brd, 0);
        }




    }

    //checks how often a specific Position on the Board is targeted by a Queen
    public static int checkTarget(int r, int c, Board brd){ // r-row, c-column, b-board
        int hitnumber = 0;

        //--rowcheck
        for (int i = 0; i < brd.getBoard()[r].length; i++) {
            if (brd.getBoard()[r][i] == 2 && i != c) {
                hitnumber++;
            }
        }


        //--columncheck
        for (int i = 0; i < brd.getBoard().length; i++) {
            if (brd.getBoard()[i][c] == 2 && i != r) {
                hitnumber++;
            }
        }


        //--diagonalcheck
        //downwards
        int offset = 0;
        for(int i = r; i<brd.getBoard()[r].length; i++)
        {

            if(c+offset < brd.getBoard()[r].length) //prevents out-of-bounds exception
            {
                if (brd.getBoard()[i][c + offset] == 2 && i != r) {
                    hitnumber++;
                }
            }
            if(c-offset > -1) //prevents out-of-bounds exception
            {
                if (brd.getBoard()[i][c - offset] == 2 && i != r) {
                    hitnumber++;
                }
            }

            offset++;
        }

        //upwards
        offset = 0;
        for (int i = r; i >= 0; i--)
        {
            if(c-offset > -1) //prevents out-of-bounds exception
            {
                if (brd.getBoard()[i][c-offset] == 2 && i != r) {
                    hitnumber++;
                }
            }
            if(c+offset < brd.getBoard()[r].length) //prevents out-of-bounds exception
            {
                if (brd.getBoard()[i][c + offset] == 2 && i != r) {
                    hitnumber++;
                }
            }
            offset++;
        }


        return hitnumber;
    }

    // versucht eine Dame pro Reihe zu setzen
    public static void solveQueens(Board board, int row) {
        if (row == 8) {
            System.out.println("Gefundene Lösung:");
            board.printBoard();
            System.out.println();
            return;
        }

        for (int col = 0; col < 8; col++) {
            if (checkTarget(row, col, board) == 0) {
                board.setBoard(row, col, 2); // Dame setzen
                solveQueens(board, row + 1); // zur nächsten Zeile
                board.setBoard(row, col, 0); // zurücksetzen (Backtracking)
            }
        }
    }



}