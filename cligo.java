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
                if(goBoard9[ycoord][xcoord] ==0){goBoard9[ycoord][xcoord] = currentPlayersTurn;}
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
    public static void printBoard(int[][] theBoard,int boardSize){
         String boardPrint = "\n";

         for (int y = 0; y<boardSize; y++){
            for(int x = 0; x<boardSize; x++){
                boardPrint+=" "+Integer.toString(theBoard[y][x])+" ";
            } 
            boardPrint+="\n";
        }       
        print(boardPrint);

    }
    public static void print(String text){
        System.out.println(text);
    }
 
}
