/**
 * Author: Hannah Soria
 * Date: 2/28/2022
 * File: Cell.java
 * Section lab C, Lecture A
 * Project: 2 Game of Life
 * CS231 Spring 2022
**/

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

// Meredith helped me look over this inital class before later methods were added to see if it was running correctly
public class Cell {
    private boolean cell;
    public Cell(){ //constructor. by default the cell is dead
        cell = false;
    }

    public Cell( boolean alive ){ //constructor method that specifies the cell's state. True means alive, false means dead
        cell = alive;
    }

    public boolean getAlive(){// return whether the cell is alive
        return cell;
    }

    public void reset(){ // sets the Cell state to its default value (not alive)
        cell = false;
    }

    public void setAlive( boolean alive){//sets the cell to alive
        cell = alive;// Wolfe pointed out that the cell needed to be alive and not true. before this change my code would not run
    }

    public String toString(){ // returns a string that indicates the alive state of the cell as a one-char string.
        String s = "The cell is: " + cell;
        return s;
    }

    public void draw(Graphics g, int i, int j, int gridScale) {// draws the cell on the Graphics object at location x, y with the size scaled by scale depending on if the cell if alive or not
        if(getAlive()){
            g.drawOval(i * 5, j * 5, gridScale * 2, gridScale * 2);
            g.setColor(Color.darkGray);
            g.fillOval(i * 5, j * 5, gridScale * 2, gridScale * 2);
        }
        else{
            g.setColor(Color.magenta);
            g.drawOval(i * 5, j * 5, gridScale * 2, gridScale * 2);
        }

    }

    public void updateState(ArrayList <Cell>neighbors){//updates whether or not the cell is alive in the next time step, given its neighbors in the current time step.
        //if a live Cell has either two or three live neighbors, then it will remain alive. If a dead Cell has exactly three living neighbors, it will be set to alive. 
        //Otherwise, the Cell will remain dead * one of the TAs helped me with the syntaxing i forgot his name though!
        int count = 0;
        for (int i =0; i < neighbors.size(); i ++){
            if (neighbors.get(i).getAlive()){
                count+= 1;
            }
        }
            if (getAlive()){
                if (count < 2 || count > 3){
                    setAlive(false);
                }
                else{
                    setAlive(true);
            }
        }
            else{
                if(count ==3){
                    setAlive(true);
                }

            }
        }

        
    public static void main(String[]args){//this main methods testss the functions created above
        Cell cell1 = new Cell(true);
        cell1.getAlive();
        cell1.reset();
        System.out.println(cell1.toString());

    }

    
}
