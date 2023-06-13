import java.util.Scanner;

class main{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        goBoard goBoard = new goBoard(9);


        print("Hello and welcome to cligo!");
        print("play with defaults? (Y/N)");
       

 
        boolean gameInProgress = false; 
        boolean isInSetup = false;


        String firstInput = input.nextLine(); 

        if(firstInput.equals("y") || firstInput.equals("Y") || firstInput.equals("\n")){
            gameInProgress = true; 
            print("game started");
            goBoard.printBoard();
            print("type the coordinates of your next move");
        }
        else if(firstInput.equals("s")){
           isInSetup = true; 
        }


        boolean passRequest = false;
        int currentPlayersTurn = 1;

        while(gameInProgress){
            String move = input.nextLine(); 
            //if player passes
            if(move.equals("pass")){
                if(passRequest==true){
                    print("game ended upon agreement");
                    print("and I am too lazy to  build in the scoring, score it yourself");
                    break;
                } 
                passRequest = true;
                print("player "+currentPlayersTurn+ " passes");
                if(currentPlayersTurn ==1){currentPlayersTurn = 2;}
                else if(currentPlayersTurn==2){currentPlayersTurn = 1;}
                continue;
            }
            
            //if player moves
            else{
                int minusIndex = 0;
                for(int i=0 ; i<move.length() ; i++){
                    if(move.substring(i,i+1).equals('-')){
                        System.out.println(move.substring(0,minusIndex));
                        minusIndex = i;
                        return; 
                    }
                }


                int ycoord = Integer.parseInt(move.substring(0,minusIndex-1));
                int xcoord = Integer.parseInt(move.substring(minusIndex,move.length()));
                boolean moveSuccess = goBoard.makeMove(ycoord,xcoord,currentPlayersTurn);
                if(moveSuccess){
                    goBoard.printBoard();
                    print("input your next move"); 
                    if(currentPlayersTurn ==1){currentPlayersTurn = 2;}
                    else if(currentPlayersTurn==2){currentPlayersTurn = 1;}
                    passRequest = false;
                    continue;
                } 
                else{
                    goBoard.printBoard();
                    print("illegal or improper move, try again");
                    continue;
                }
            } 
        }

        if(isInSetup){
            print("it should be in setup mode now");

        }


    }
    
    public static void print(String text){
        System.out.println(text);
    }
 
}






class goBoard{
    private int[][] theBoard;
    private int boardSize;

    public goBoard(int boardSizee){
        theBoard = new int[boardSizee][boardSizee];
        boardSize = boardSizee;
    }

    public int[][] getBoard(){
        return theBoard;
    }
    
    public boolean makeMove(int currentPlayersTurn, int yCoord, int xCoord){
        
        //returns true if move was made, returns false if it is an illegal move

        if(yCoord-1 >=1 && xCoord-1 >=1 && yCoord-1 <= boardSize && xCoord-1 <= boardSize && theBoard[yCoord-1][xCoord-1] ==0)
        {
            theBoard[yCoord][xCoord] = currentPlayersTurn;
            return true;
        }
        else{
            System.out.println(yCoord+xCoord);
            return false; 
        }
    }
//board printers*****************************************************************************************************
    public void printBasicBoard(){
         String boardPrint = "\n";

         for (int y = 0; y<boardSize; y++){
            for(int x = 0; x<boardSize; x++){
                boardPrint+=" "+Integer.toString(theBoard[y][x])+" ";
            }
            boardPrint+="\n";
        }
        System.out.println(boardPrint);

    }

    public void printBoard(){
        String emptySpace = " ";
        String noPieceFiller = "+";
        String p1Piece = "1";
        String p2Piece = "2";
        String boardPrint = "\n";
        for (int y = -1; y<boardSize; y++){
            //rows
            if(y==-1){//prints empty top left corner
                boardPrint+= emptySpace + emptySpace + emptySpace;
            } 
            if(y >= 0){ //prints left reference nums
                boardPrint+= emptySpace + (y+1) + emptySpace;
            }
            for(int x = 0; x<boardSize; x++){
                //columns
                if(y!=-1){
                    if(theBoard[y][x]==0){ //if no piece is there
                        boardPrint += emptySpace + noPieceFiller + emptySpace;
                    }
                    else if(theBoard[y][x]==1){ //if p1 has a piece there
                        boardPrint += emptySpace + p1Piece + emptySpace;
                    }
                    else if(theBoard[y][x]==2){ //if p2 has a piece there
                        boardPrint += emptySpace + p2Piece + emptySpace;
                    }
//                    boardPrint+= emptySpace +Integer.toString(theBoard[y][x])+ emptySpace;
                }
                else{
                    //prints top reference nums 
                    boardPrint+= emptySpace + (x+1) + emptySpace;
                }

            }
             
            boardPrint+="\n";
        }
        System.out.println(boardPrint);
    }





}
