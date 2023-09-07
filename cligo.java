import java.util.ArrayList;


/*
class goString{
    //this class is to take the board, spit it into strings, check if the strings have liberties, and return what stones to remove. 
    //I will likely just do all of this in the goboard class with just another method. 
    //stone coord
    //list of stone coord that make up the string
    private ArrayList<int[]> libertyCoordinateList = new ArrayList<int[]>();
    private int[][] goBoard;



    public goString(int[][] theBoard, ArrayList<int[]> stoneCoordList){
        stoneCoordinateList = stoneCoordList;
        goBoard = theBoard;
    }
    public void addStoneToString(int[] coordinates){
        stoneCoordinateList.add(coordinates);
    }
    
}
*/
class goString
{
    ArrayList<int[]> theString;   
    public goString{int[] firstCoord}
    {
        addStone(firstCoord);
    }     
    public ArrayList<int[]> returnString()
    }
    return theString;
    }


    public void addStone(int[] coord)
    {
        theString.add(coord);
    }

    public void addStone(goString addedString)
    {
        ArrayList<int[]> strList = addedString.returnString();
        theString.add(strList)
    }

    public ArrayList<int[]> returnAdjecentSquares(int[] stoneCoord)
    {
        int stoney = stoneCoord[0];
        int stonex = stoneCoord[1];
             
        int[] l1 = {stoney-1,stonex};
        int[] l2 = {stoney, stonex+1};
        int[] l3 = {stoney+1,stonex};
        int[] l4 = {stoney, stonex-1};
 
        ArrayList<int[]> adjacentSquares;
        adjacentSquares.add(l1);
        adjacentSquares.add(l2);
        adjacentSquares.add(l3);
        adjacentSquares.add(l4);

        return adjacentSquares;

    }

    private ArrayList<int[]> calculateOuterEdge()
    {
        //calculate all possible liberties into libertyList
        ArrayList<int[]> libertyList;
        for(i = 0, i<theString.length, i++){
           libertyList.add(this.returnAdjecentSquares(theString.get(i)));
        }
        //remove pieces already filled in with this string
        for(i = 0, i<theString.length, i++)
        {
            libertyList.remove(theString.get(i));
        }
        //remove duplicates
        Set<int[]> rmDupe = new hashSet<int[]>(libertyList);
        libertyList = new ArrayList<int[]>(rmDupe);
        return libertyList;
    }
}
class stringList
{
    private ArrayList<goString> theStringList;    

    public stringList(goString firstString)
    {
        theStringList.add(firstString);
    }
    //add every board move as its own string.
    public void addString(goString newString)
    {
       theStringList.add(newString);
    }

    public ArrayList<int[]> returnAllLiberties()
    {
        ArrayList<int[]> edgeLibertyList;
        for(int i = 0, i<theStringList.length, i++)
        {
            edgeLibertyList.add(theStringList.get(i).calculateOuterEdge();
        }
        //there should be no pieces with the liberties if all the strings were properly merged and only strings of pieces that actually aren't adjacent to eachother then you don't need to account for the pieces themselves. but if I get errors later this is what it could be. (you are welcome future cameron)
        //removes duplicates within that color's pieces
        set<int[]> rmDupe = new hashSet<int[]>(edgeLibertyList);
        libertyList = new ArrayList<int[]>(rmDupe);
        
    }
/*
    //list liberties of everything in the stringlist
    private ArrayList<int[]> identifyLiberties(ArrayList<int[]> theString)
    {

        ArrayList<int[]> libertyList = new ArrayList<>();
        for(int i = 0 ; i<theString.size(); i++){

            int[] stoneCoord = theString.get(i);
            int stoney = stoneCoord[0];
            int stonex = stoneCoord[1];

            int[] l1 = {stoney-1,stonex};
            int[] l2 = {stoney, stonex+1};
            int[] l3 = {stoney+1,stonex};
            int[] l4 = {stoney, stonex-1};
            if(!libertyList.contains(l1)&&!theString.contains(l1)){
                libertyList.add(l1);
            }
            if(!libertyList.contains(l2)&&!theString.contains(l2)){
                libertyList.add(l2);
            }
            if(!libertyList.contains(l3)&&!theString.contains(l3)){
                libertyList.add(l3);
            }
            if(!libertyList.contains(l4)&&!theString.contains(l4)){
                libertyList.add(l4);
            }
        }
        return libertyList;

    }
*/
}

class goBoard{
    private int[][] theBoard;
    private int boardSize;


    private stringList p1Strings;
    private stringList p2Stirngs;
 
    public goBoard(int boardSizee){
        theBoard = new int[boardSizee][boardSizee];
        boardSize = boardSizee;
    }

    public int[][] getBoard(){
        return theBoard;
    }

    //list player peices
    public ArrayList<int[]> listPlayerPieces(int player){
        ArrayList<int[]> pieceList = new ArrayList<>(); 
        for (int y = 0; y<boardSize; y++){
            for(int x = 0; x<boardSize; x++){
                if(theBoard[y][x]==player){
                    int[] coordinates = {y,x};
                    pieceList.add(coordinates);
                }
            }
        }
        return pieceList;
    }



    //checks if illegal move    
    
    public boolean makeMove(int[] moveCoords, int currentPlayersTurn){
        int yCoord = moveCoords[0]-1;
        int xCoord = moveCoords[1]-1; 
        //returns true if move was made, returns false if it is an illegal move

        if(yCoord >=0 && xCoord >=0 && yCoord <= boardSize && xCoord <= boardSize && theBoard[yCoord][xCoord] ==0)
        {
            theBoard[yCoord][xCoord] = currentPlayersTurn;
            return true;
        }
        else{
            return false; 
        }
    }
//start here when you finish, I need to figure out what to do next in terms of what needs to be in this goboard class to be used in the other file. just work on the other file and use the funcitons I made until I need another one and then make that one
    public ArrayList<int[]> identifyLiberties(ArrayList<int[]> theString)
    {
        
    }



//print a list of coordinates with this
    public void printcoordlist(arraylist<arraylist<int[]>> coordlist)
    {
        int presentx;
        int presenty;
        for(int i = 0 ; i<coordlist.size() ; i++)
        {
            presentx = coordlist.get(i)[0];
            presenty = coordlist.get(i)[1];
            system.out.println(presentx+","+presenty);
        }
        return;
    }

//the working one






    public ArrayList<ArrayList<int[]>> identifyStrings(ArrayList<int[]> pieceList){

        ArrayList<ArrayList<int[]>> stringList = new ArrayList<>();


        //identify adjecent stones and merge them
        while(pieceList.size()>0){
            int[] stoneCoord = pieceList.get(0);
            
            ArrayList<int[]> buildingString = new ArrayList<>();
            buildingString.add(stoneCoord);
            
            returnAdjecentSquares(stoneCoord);

            for(int i = 0 ; i<libertiesOfBuildingString.size() ; i++){
                int[] currentLibertyCoord = libertiesOfBuildingString.get(i);
                
                if(pieceList.contains(currentLibertyCoord)){
                    //if an adjacent piece is found
                    buildingString.add(currentLibertyCoord);
                    while(pieceList.contains(currentLibertyCoord)){pieceList.remove(currentLibertyCoord);}
                    libertiesOfBuildingString = identifyLiberties(buildingString);
                    i = -1;
                }
            }
            stringList.add(buildingString);

        }
        printCoordList(stringList);
        return stringList;

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
