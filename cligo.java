import java.util.Scanner;

class main{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int boardSize = 9; 
        int[][] goBoard9 = new int[boardSize+1][boardSize];


        print("Hello and welcome to cligo!");
        print("play with defaults? (Y/N)");
       

 
        boolean gameInProgress = false; 
        boolean isInSetup = false;


        String firstInput = input.nextLine(); 

        if(firstInput.equals("y") || firstInput.equals("Y") || firstInput.equals("\n")){
            gameInProgress = true; 
            print("game started");
            printBoard(goBoard9,boardSize);
            print("type the coordinates of your next move");
        }
        else if(firstInput.equals("s")){
           isInSetup = true; 
        }


        boolean passRequest = false;
        int currentPlayersTurn = 1;

        while(gameInProgress){
            String p1move = input.nextLine(); 
            //if player passes
            if(p1move.equals("pass")){
                if(passRequest==true){
                    print("game ended upon agreement");
                    break;
                } 
                passRequest = true;
                print("p1 passes");
            }
            
            //if player moves
            else{
                int ycoord = Integer.parseInt(p1move.substring(0,1));
                int xcoord = Integer.parseInt(p1move.substring(1));
                if(ycoord-1 >=1 && xcoord-1 >=1 && ycoord-1 <= boardSize && xcoord-1 <= boardSize && goBoard9[ycoord-1][xcoord-1] ==0)
                {
                    goBoard9[ycoord-1][xcoord-1] = currentPlayersTurn;
                }
                else{
                    print("illegal move try again");
                    if(currentPlayersTurn ==1){currentPlayersTurn = 2;}
                    else if(currentPlayersTurn==2){currentPlayersTurn = 1;}
 
                }
            } 
            //after a player finishes 
            printBoard(goBoard9,boardSize);
            print("input your next move"); 
            if(currentPlayersTurn ==1){currentPlayersTurn = 2;}
            else if(currentPlayersTurn==2){currentPlayersTurn = 1;}
        }

        if(isInSetup){
            print("it should be in setup mode now");

        }


    }
/*
    public static String doTurn(boolean passRequest){
        string p1move = input.nextline(); 
        if(p1move.equals("pass")){
            if(passrequest==true){
                return "game finished by passing";
            } 
            passrequest = true;
            print("p1 passes");
            return "p1 passes"; 
        }
        else{
            int ycoord = integer.parseint(p1move.substring(0,1));
            int xcoord = integer.parseint(p1move.substring(1));
            goboard9[ycoord][xcoord] = 1; 
        } 
            
        printboard(goboard9,boardsize);
        print("input your next move"); 
        return "p1 turn complete";
    }
*/
    public static void printBasicBoard(int[][] theBoard,int boardSize){
         String boardPrint = "\n";

         for (int y = 0; y<boardSize; y++){
            for(int x = 0; x<boardSize; x++){
                boardPrint+=" "+Integer.toString(theBoard[y][x])+" ";
            }
            boardPrint+="\n";
        }
        print(boardPrint);

    }
    public static void printBoard(int[][] theBoard, int boardSize){
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
        print(boardPrint);
    }
    public static void print(String text){
        System.out.println(text);
    }
 
}
