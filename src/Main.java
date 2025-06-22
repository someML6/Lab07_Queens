//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        Board brd = new Board();
        brd.setBoard(3,4,2); //zu überprüfende position
        brd.setBoard(3,2,2);
        brd.setBoard(0,4,2);
        brd.setBoard(1,2,2);
        brd.setBoard(1,6,2);
        brd.setBoard(5,2,2);

        // AUFGABE 3 & 4 (Kommentarklammer "//" entfernen in Zeile 16, wenn diese Aufgabe betrachtet wird!!!)
        //solveQueens(brd, 0);

        brd.printBoard(); //printet Board Matrix in Console
        // AUFGABE 2 (checkt Hits an der eingegebenen Position)
        System.out.println("Hits: " + checkTarget(3,4,brd));
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