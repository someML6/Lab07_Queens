//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
         Board brd = new Board();
         brd.setBoard(4,4,2);




            brd.printBoard();

            /*
            for (int i = 0; i < brd.getBoard().length; i++) {
                for (int n = 0; n < brd.getBoard()[i].length - 1; n++) {
                    System.out.print(brd.getBoard()[i][n] + " ");
                }
                System.out.println(brd.getBoard()[i][brd.getBoard()[i].length - 1] + " ");
            }*/
    }


}