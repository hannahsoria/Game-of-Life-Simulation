/**
 * Author: Hannah Soria
 * Date: 2/28/2022
 * File: LandScape.java
 * Section lab C, Lecture A
 * Project: 2 Game of Life
 * CS231 Spring 2022
**/
import java.util.ArrayList;
import java.awt.Graphics;

public class Landscape {
    private Cell[][] grid;
    private int rows;
    private int cols;

    public Landscape ( int rows, int cols ){ //sets the number of rows and columns to the specific values and allocates the grid of cell references. then allocae a cell for each location in grid
        this.rows = 20;
        this.cols = 20;
        this.grid = new Cell[rows][cols];
            for (int i = 0; i < rows ; i++){
                for (int j = 0; j < cols ; j++){
                    this.grid[i][j] = new Cell();
                }
            }
    }

    public void reset(){ //calls the reset method for each cell
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                grid[i][j].reset();
            }
        }
    }

    public int getRows(){ // returns the number of rows in the Landscape.
        return grid.length;
    }

    public int getCols(){ // returns the number of columns in the landscape
        return grid[0].length;
    }

    public Cell getCell ( int row, int col ){ // returns a reference to the Cell located at position (row,col)
        return grid[row][col];
    }

    public String toString(){ //converts the Landscape into a text based string representation
        String gridString = "";
            for (int i = 0; i < rows - 1; i++){
                for (int j = 0; j < cols - 1; j++){
                    if (grid[i][j].getAlive() == false){
                        gridString += "x";
                    }
                    else{
                        gridString += "y";
                    }    
                }
                gridString += "\n";
            }
            return gridString;
    }

    public ArrayList <Cell> getNeighbors ( int row, int col){// returns the neighbors surroung the cell
        ArrayList <Cell> arr = new ArrayList <Cell> ();// credit goes to gretchen for explaining code to me and
        // helping me with code that she worked through with wolfe

        for (int i = row - 1; i < row + 2; i++){
            for (int j = col - 1; j < col + 2; j++){
                if (i > -1 && i < rows && j > -1 && j < cols && !(i == row && j == col)){
                    arr.add(grid[i][j]);
                }
            }
        }
        return arr;
    }

    public void draw(Graphics g, int gridScale){// loop through the cells in Grid, calling their draw() 
        //methods at positions calculated from their positions in the grid
        for (int i = 0; i < cols; i++){
            for (int j = 0; j < rows; j++){
                grid[i][j].draw(g, i * gridScale, j * gridScale, gridScale);
            }
        }
    }

    public void advance(){//move all Cells forward one generation. I get help for this part from a TA Nick I believe
        Cell[][] copy = new Cell[this.rows][this.cols];
        for (int i = 0; i < cols; i++){
            for (int j = 0; j < rows; j++){
                Cell temp = new Cell(grid[i][j].getAlive());
                copy[i][j] = temp;
            }
        }
        for (int i = 0; i < cols; i++){
            for (int j = 0; j < rows; j++){
                copy[i][j].updateState(getNeighbors(i, j));
            }
        }
        grid = copy;
    }

        public static void main(String[]args){// this main method tests the functions written above
            Landscape landscape = new Landscape(20,20);
            //landscape.reset();
            System.out.println(landscape.getRows());
            System.out.println(landscape.getCols());
            System.out.println(landscape.getCell(2,5));
            System.out.println(landscape.toString());
            System.out.println(landscape.getNeighbors(2, 5));
        }


}

