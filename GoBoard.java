package cligo.GoBoard;
import java.util.ArrayList;
//next time I need you to start with making this file into being able to be read by the runtime.java and integrating the two. then integrate them, error fix them for as long as you can, and either you have a working program or one that has less bugs.
public class goBoard{
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
/*
    public ArrayList<int[]> identifyLiberties(ArrayList<int[]> theString)
    {
        
    }


    //print a list of coordinates with this
    //this isn't that nessary right?
    //
    public void printcoordlist(ArrayList<ArrayList<int[]>> coordlist)
    {
        int presentx;
        int presenty;
    for(int i = 0 ; i<coordlist.size() ; i++)
    {
        presentx = coordlist.get(i)[0];
        presenty = coordlist.get(i)[1];
        System.out.println(presentx+","+presenty);
    }
    return;
}
*/
public ArrayList<ArrayList<int[]>> identifyStrings(ArrayList<int[]> input-list){
    ArrayList<int[]> stoneList = input-list;
    ArrayList<GoString> stringList = new ArrayList<GoString>();


        //identify adjecent stones and merge them
        while(pieceList.size()>0){
            int[] stoneCoord = pieceList.get(0);
            GoString buildingString = new GoString(stoneCoord);
            
            //check if liberties of string intersect other pieces and add those pieces to the string if they do.
            //remove string liberties that run up against

            //ArrayList<int[]> buildingString = new ArrayList<>();
            //ArrayList<int[]> libertiesOfBuildingString = goString.returnAdjecentSquares(stoneCoord);
            //buildingString.add(stoneCoord);

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
        //printCoordList(stringList);
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
                    //boardPrint+= emptySpace +Integer.toString(theBoard[y][x])+ emptySpace;
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


}//end of goboard() class

//single string of stones
class GoString
{
    private ArrayList<int[]> theString;   
    private ArrayList<int[]> libertyList;

    public goString(int[] firstCoord)
    {
        this.addStone(firstCoord);
    }
    public goString()
    {

    }

    public ArrayList<int[]> returnString()
    {
        return this.theString;
    }
    public ArrayList<int[]> returnLiberties()
    {
        return this.libertyList;
    }

    public void addStone(int[] coord)
    {
        this.theString.add(coord);
        this.updateValues();
        return;
    }
    public void addStone(goString addedString)
    {
        ArrayList<int[]> strList = addedString.returnString();
        this.addStone(strList);
    }
    private void updateValues()
    {
        for(int i = 0; i<theString.size() ; i++)
        {   //adds all adjacent squares regardless
            ArrayList<int[]> allAdjecentSquares = new ArrayList<int[]>;
            allAdjecentSquares.add(this.returnAdjecentSquares(i));
       //     ArrayList<int[]> allAdjecentSquares(theString.get(i));
            //removes "self" liberties
            for(int g = 0 ; g<allAdjecentSquares.size() ; g++)
            {
                if(theString.contains(allAdjecentSquares.get(g))
                {
                    allAdjecentSquares.remove(g);
                }
            }
            libertyList.add(allAdjecentSquares);
        }
        return;
    }

    public static ArrayList<int[]> returnAdjecentSquares(int[] stoneCoord)
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

}//string class ends
/*
    private ArrayList<int[]> calculateOuterEdge()
    {
        //calculate all possible liberties into libertyList
        ArrayList<int[]> libertyList;
        for(int i = 0; i<theString.length; i++){
           libertyList.add(this.returnAdjecentSquares(theString.get(i)));
        }
        //remove pieces already filled in with this string
        for(int i = 0; i<theString.length; i++)
        {
            libertyList.remove(theString.get(i));
        }
        //remove duplicates
        Set<int[]> rmDupe = new hashSet<int[]>(libertyList);
        libertyList = new ArrayList<int[]>(rmDupe);
        return libertyList;
 k  }


/*
//list of all the strings of one color
class stringList
{
    private ArrayList<goString> theStringList;    

    public stringList(goString firstString)
    {
        this.theStringList.add(firstString);
    }
    //add every board move as its own string.
    public void addString(goString newString)
    {
       this.theStringList.add(newString);
    }

    public ArrayList<int[]> returnAllLiberties()
    {
        ArrayList<int[]> edgeLibertyList;
        for(int i = 0; i<theStringList.length; i++)
        {
            edgeLibertyList.add(theStringList.get(i).calculateOuterEdge());
        }
        //there should be no pieces with the liberties if all the strings were properly merged and only strings of pieces that actually aren't adjacent to eachother then you don't need to account for the pieces themselves. but if I get errors later this is what it could be. (you are welcome future cameron)
        //removes duplicates within that color's pieces
        set<int[]> rmDupe = new hashSet<int[]>(edgeLibertyList);
        libertyList = new ArrayList<int[]>(rmDupe);
        
    }

}//stringlist ends
*/

