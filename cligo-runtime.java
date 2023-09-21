//this is the second version, where I rework it and copy from the older version, (this is attempt number 2 where I borrow much from the original and maybe have different files that do different things ) (one would have the backend calculations and the other would handle the frontend runtime)
import java.util.Scanner;

//untested since creation.

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
                int[] moveCoord = helper.parseInput(move);
                boolean moveSuccess = goBoard.makeMove(moveCoord,currentPlayersTurn);
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
                //print(goBoard.identifyStrings(goBoard.listPlayerPieces(currentPlayersTurn)));
            } 
        }

        if(isInSetup){
            print("it should be in setup mode now");

        }


    }
    /*
    public static void print(String text){
        System.out.println(text);
    }
    */


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

    private int[] parseInput(String input){
        int minusIndex = 0;
        for(int i=0 ;i<input.length(); i++){
            if(input.charAt(i) == '-'){
                minusIndex = i;
                break; 
            }
        }
        String sycoord = input.substring(0,minusIndex); 
        String sxcoord = input.substring(minusIndex+1);
        int ycoord = Integer.parseInt(sycoord);
        int xcoord = Integer.parseInt(sxcoord);
        int[] coordinates = {ycoord,xcoord};
        return coordinates;
    }


}//end of main()
/*
class helper{
    public static int[] parseInput(String input){
        int minusIndex = 0;
        for(int i=0 ;i<input.length(); i++){
            if(input.charAt(i) == '-'){
                minusIndex = i;
                break; 
            }
        }
        String sycoord = input.substring(0,minusIndex); 
        String sxcoord = input.substring(minusIndex+1);
        int ycoord = Integer.parseInt(sycoord);
        int xcoord = Integer.parseInt(sxcoord);
        int[] coordinates = {ycoord,xcoord};
        return coordinates;
    }


}
*/

