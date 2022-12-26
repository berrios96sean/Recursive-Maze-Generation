import java.util.Random;

/**
 * This projects creates a random maze using recursive division.
 * 
 * CompletionTime: 24 hours
 * 
 * @author Sean Berrios
 * @version 19 May 2021
 *
 *
 */

public class BerriosMazeGen {

	
	 //standard console size in characters.
    private static final int LEVEL_HEIGHT = 25;
    private static final int LEVEL_WIDTH = 80;       
    
    private static final char ICON_WALL = '#';           
    private static final char ICON_BLANK = ' ';

    static int count = 1;
    /**
     * Returns a 2D array containing a statically created maze with dimentions 80x24.
     * 
     * @return     2D array containing a maze 
     */
    
    
    private static char[][] makeMazeStatic()
    {
        //the following maze was generated with the recursive division method and then modified by hand.
        
        char level[][] =     
        {{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}, 
        {'#', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'}, 
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}, 
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'}, 
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', '#', ' ', '#', '#', '#'}, 
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', '#', '#', '#', '#', ' ', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#'}, 
        {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', ' ', '#', ' ', ' ', '#', ' ', '#'}, 
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', '#'}, 
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#'}, 
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', '#', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#'}, 
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'}, 
        {'#', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#'}, 
        {'#', ' ', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', '#', ' ', '#', '#'}, 
        {'#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#', '#', '#', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'}, 
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}, 
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', '#', ' ', '#', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'}, 
        {'#', '#', '#', ' ', '#', ' ', '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'}, 
        {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#'}, 
        {'#', ' ', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'}, 
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'}, 
        {'#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}, 
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'}, 
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'}, 
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},         
        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}};
    
        return level;
    }
    
    /**
     * Creates a random maze in a 2D array.
     * 
     * @see <a href="http://en.wikipedia.org/wiki/Maze_generation_algorithm#Recursive_division_method">Recursive_division_method</a>
     * @return 2D array containing a maze
     */
    private static char[][] makeMaze()
    {
        char level[][] = createBlankLevel();
        
      
        
        makeMazeRecursive(level, 1, 1, LEVEL_WIDTH-2, LEVEL_HEIGHT-2, count); //TODO: may need to change but probably not.
        
        return level;
    }

    /**
     * Creates an empty level of standard level height and width. Level will be
     * blank but bordered with wall characters.
     * 
     * @return  2D array containing a maze
     */
    private static char[][] createBlankLevel()
    {   
        char level[][] = new char[LEVEL_HEIGHT][LEVEL_WIDTH];
        
        //reset level to be entirely blank
        for (int y = 0; y < LEVEL_HEIGHT; y++) 
            for (int x = 0; x < LEVEL_WIDTH; x++)
                level[y][x] = ' ';
    
        //top barrier   
        for (int x = 0; x < LEVEL_WIDTH; x++)
            level[0][x] = ICON_WALL;
    
        //bottom barrier
        for (int x = 0; x < LEVEL_WIDTH; x++)
            level[LEVEL_HEIGHT-1][x] = ICON_WALL;
    
        //left barrier
        for (int y = 0; y < LEVEL_HEIGHT; y++)
            level[y][0] = ICON_WALL;
    
        //left barrier
        for (int y = 0; y < LEVEL_HEIGHT; y++)
            level[y][LEVEL_WIDTH-1] = ICON_WALL;
            
        return level;
    }

    private static int randBetween(int max, int min) {
    	
    	Random rand = new Random();
    	int randomInt = rand.nextInt(max - min + min)+ 1;
    	
    	return randomInt;
    }
    
    //TODO: complete method.
    
    /**
     * Uses a recursive algorithm to generate a random maze 
     * @param level
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     */
    private static void makeMazeRecursive(char[][]level, int startX, int startY, int endX, int endY, int count)
    {

    	// Need two conditions to check, 1. If there is another sub area to split 2. if that sub area is larger than 3x3 
    	//int count = 0;
    	
     	if (endX > 1 && endY > 1 && count <= 4) {
    		//System.out.println("Test\n");
     		
     		//create a terminating condition via count to see what is the most optimal amount of recursive calls 
     		
     		
    		if (endX - startX > 3 && endY - startY > 3 && count <= 4) 
    		{  															/* NOTE
    																	 *	confirm the area is larger than 3 X 3 so I can add more sub areas after walls are built 
    																	 *	System.out.println("Test\n");
    																	 *	Rows = Y Rand = X ----- Columns = X Rand = Y, 
    																       NOTE  */
    			
    			
    		 //*********** LINE CREATION *********************
    			int row = randBetween(endY, startY);
    			int column = randBetween(endX, startX);
    			
    			for (int i = startX; i <= endX; i++) 
    			{   													// This Creates a horizontal wall or row  
    					level[row][i] = '#';
    																	//System.out.println("Test\n");
    			}
    			
    				for (int j = startY; j <= endY; j++) {
    					level[j][column] = '#';								// this creates a vertical Wall or Column 
    				}
    		 //*********** LINE CREATION *********************		
    																		/* NOTE 
    																		 * Need to make two openings on each wall. Using the opposite wall as a reference. 
    																		 * Using a random variable. Row = Y (horizontal) use column as reference. 1: Max = column Min= startY 2: Max = endY Min = column 
    																		 * Using a random variable. Column = X (Vertical) use row as reference. 1: Max = row Min= startX 2: Max = endX Min = row 
    																		 * 
    																		   NOTE  */
    			
    				
														    				/*****************TEST*******TEST**************************************
														    				System.out.println("startx = " + startX + "\n");
														    				System.out.println("starty = " + startY + "\n");
														    				System.out.println("endx = " +endX + "\n");
														    				System.out.println("endy = " +endY + "\n");
														    				System.out.println("row = " +row + "\n");
														    				System.out.println("column = " +column + "\n");
														    				***************************TEST**************************************/
    				
    				
    			//***************** DOOR CREATION **************************************************************	
    				if (column == 1) {
    					level[row][randBetween(endX, column)] = ' ';
    				}
    				
    				if (column != 1) {
    				    level[row][randBetween(column, startX)] = ' '; //test with only 2 lines work 
    				   	level[row][randBetween(endX, column)] = ' ';         //test with only 2 lines work 
    				}
    		   
    				if (row == 1) {
    					level[randBetween(endY, row)][column] = ' ';
    				}
    				
    				if (row != 1) {
    					level[randBetween(row, startY)][column] = ' ';									//test with only 2 lines work
    					level[randBetween(endY, row)][column] = ' ';					//throws error: needed to make if statements otherwise when row or column = 1 you will sometimes get 0 
    				}
    		    //***************** DOOR CREATION **************************************************************
    				
														    			
    				
    				
    				
    				
    																		/* 	NOTE 
														    				 * After two walls are made need to create four sub areas using column and row values as reference 
														    				 * Sub area 1: startX: 1  startY: 1  endX: column - 1   endY: row - 1
														    				 * Sub area 2: startX: column + 1  startY: 1  endX: endX   endY: row - 1
														    				 * Sub area 3: startX: 1  startY: row + 1  endX: column - 1  endY: endY
														    				 * Sub area 4: startX: column + 1  startY: row + 1  endX: endX  endY: endY
														    				 * 
														    				    NOTE    */
    				
    				
																    		/*******************************TEST*******************
    																			System.out.println("**************************");
																    			System.out.println("startx = " + startX + "\n");
																				System.out.println("starty = " + startY + "\n");
																				System.out.println("endx = " +endX + "\n");
																				System.out.println("endy = " +endY + "\n");
																				System.out.println("row = " +row + "\n");
																				System.out.println("column = " +column + "\n");
																				System.out.println("**************************");
																			*************************TEST**************************/
    				
    									/*  NOTE
    									 * All of these work individually but dont seem to really go well together. 
    									 * Sub Area 4 seems to give the best maze of the group 
    									 * 
    									    NOTE */
    				
    		
    				
    			
    		//********************************** SUB AREAS *************************************************************************************************************************************************	
    				/*
    				 * I added a counter to the function to be able to run all four of these at the same time and get at least 4 recursive calls at once.
    				 * it will sometimes loop through twice but it is still more of a distinguishable maze than if i tried to run these without a counter
    				 * 
    				 */
    				
    				if (count <= 1) {
    			//	count++;
    				makeMazeRecursive(level, 1, 1, (column - 1), (row - 1), count++); //Sub area 1
    				System.out.println(count);
    				
    			
    			if (count <= 2) {
    			//	count++;
    				makeMazeRecursive(level, (column + 1), 1, endX, (row - 1), count++); //Sub area 2
    				System.out.println(count);
    				
    			
    			if (count <= 3) {
    			//	count++;
    				makeMazeRecursive(level, 1, (row + 1), (column - 1), endY, count++); //Sub area 3
    				System.out.println(count);
    				
    			
    			if (count <= 4) {
    			//	count++;
    				makeMazeRecursive(level, (column + 1), (row + 1), endX, endY, count++); //Sub area 4
    				System.out.println(count);
    				
    		
    							}
    			
    						}	
    					}
    			
    				}
    			
    			//	makeMazeRecursive(level, (column + 1), 1, endX, (row - 1)); //Sub area 2: this one is only working when Column Value = 1 
    		    //    makeMazeRecursive(level, 1, (row + 1), (column - 1), endY); //Sub area 3: works with sub area 1 periodically have not diagnosed the error: Fixed by adding min to outer loop or randoms
    		    //  	makeMazeRecursive(level, (column + 1), (row + 1), endX, endY); //Sub area 4: need to revist this one 
    			
    		//********************************** SUB AREAS *************************************************************************************************************************************************	
    				
    																	    		
    		        
    		        
    		        
    		        
    		        
    		        														/********************************TEST*******************	
    		      																System.out.println("**************************");
																    			System.out.println("startx = " + startX + "\n");
																    			System.out.println("starty = " + startY + "\n");
																    			System.out.println("endx = " +endX + "\n");
																    			System.out.println("endy = " +endY + "\n");
																   				System.out.println("row = " +row + "\n");
																   				System.out.println("column = " +column + "\n");
																   				System.out.println("**************************");
																    		*************************TEST***********************/
    		}
    		
    	}
    	
    	
    }
    
    /**
     * Displays a level in the console.
     * 
     * @param level  2D array containing a maze
     */
    private static void drawLevel(char[][] level)
    {
        int y, x;
    
        for (y = 0; y < LEVEL_HEIGHT; y++) 
        {
            for (x = 0; x < LEVEL_WIDTH; x++)
                System.out.print(level[y][x]);
            System.out.println();
        }
    }

    /**
     * Entry point.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {       
        //show static maze (uncomment for sample output)
       // drawLevel(makeMazeStatic());
        //show recursive maze
        drawLevel(makeMaze());
    }
}
