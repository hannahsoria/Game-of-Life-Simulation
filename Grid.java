/**
 * Author: Hannah Soria
 * Date: 2/18/2022
 * File: Grid.java
 * Section lab C, Lecture A
 * Lab: 2D Arrays
 * CS231 Spring 2022
**/
public class Grid {
    
    public static void main(String[]args){// Merefith Green worked with me to finish this lab
        for (int i = 0 ; i < args.length; i ++){ 
            System.out.println(Integer.parseInt(args[i]));//changes a string to an int
        if (args.length < 1){
            System.out.println("Usages: java Grid *command line arguments*");//if there are no command line arguments this error is thrown
        }}
        int yogi;
        int booboo;
        yogi = Integer.parseInt(args[0]);
        booboo = Integer.parseInt(args[1]);

        String[][] ranger;
        ranger = new String[yogi][booboo];
        for(int i=0;i<yogi;i++) {
            for(int j=0;j<booboo;j++) {
                ranger[i][j] = new String("hannah");
                
            }
        for( i=0;i<yogi;i++) {
            for(int j=0;j<booboo;j++) {
                System.out.println(ranger[i][j]);
            }
        }
    }
}
}
