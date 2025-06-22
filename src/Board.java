public class Board {

    //Figures Represented by Numbers
    // King 1, Queen 2, Rook 3, Bishop 4, Knight 5, Pawn 6
    private int[][] board ={
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0}
    };

    //prints Board Matrix in the Console
    public void printBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int n = 0; n < board[i].length - 1; n++) {
                System.out.print(board[i][n] + " ");
            }
            System.out.println(board[i][board[i].length - 1] + " ");
        }

    }

    //changes Value of one Specific position on the board
    public void setBoard(int r, int c, int f) // r-row, c-column, f-figure
    {
        board[r][c] = f;

    }

    //returns Board Array
    public int[][] getBoard()
    {
        return board;
    }

}