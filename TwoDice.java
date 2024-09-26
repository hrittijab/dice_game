
package com.mycompany.dicegame;

import java.util.Random;

/**
 *
 * @author 88019
 */
public class TwoDice {
    private int value1;
    private int value2;
    private char[][] display1=null;
    private char[][] display2=null;
    Random rand = new Random();
    
    
    
    public TwoDice() {
        value1 = 1;
        value2 = 1;
        display1 = createDisplay(value1);
        display2 = createDisplay(value2);
    }
    /*This method generates 2 numbers randomly for the 2 values, and puts them
    in the createdisplay method to print the dices*/
    public void roll(){
        value1 = rand.nextInt(6)+1;
        value2 = rand.nextInt(6)+1;
        display1 = createDisplay(value1);
        display2 = createDisplay(value2);
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }
    /*This method creates the display using the array and the switch
    */
    
    public char[][] createDisplay(int diceNumber){
        
            char[][] myArray = {{' ','-','-','-','-','-','-','-',' '},
                                {'|',' ',' ',' ',' ',' ',' ',' ','|'},
                                {'|',' ',' ',' ',' ',' ',' ',' ','|'},
                                {'|',' ',' ',' ',' ',' ',' ',' ','|'},
                                {' ','-','-','-','-','-','-','-',' '}};
       
        
        switch (diceNumber) {  //switch according to the dicenumber
            case 1:
                myArray[2][4]='o';
                break;
            case 2:
                myArray[1][2]='o';
                myArray[3][6]='o';
                break;
            case 3:
                myArray[1][2]='o';
                myArray[2][4]='o';
                myArray[3][6]='o';
                break;
            case 4:
                myArray[1][2]='o';
                myArray[3][6]='o';
                myArray[3][2]='o';
                myArray[1][6]='o';
                break;
            case 5:
                myArray[1][2]='o';
                myArray[3][6]='o';
                myArray[3][2]='o';
                myArray[1][6]='o';
                myArray[2][4]='o';
                break;
               
            case 6:
                myArray[1][6]='o';
                myArray[3][2]='o';
                myArray[3][6]='o';
                myArray[1][2]='o';
                myArray[2][2]='o';
                myArray[2][6]='o';
                break;
        }
        return myArray;

        }
    //*This method prints the dices beside each other
    
    public void printDisplay(){
        for(int i = 0; i < display1.length; i++){
            for(int j=0;j<display1[i].length;j++){
                System.out.print(display1[i][j]);
            }
            System.out.print("         "); //Spaces between the 2 dices
            for(int j = 0; j < display2[i].length; j++){
                System.out.print(display2[i][j]);
            }
            System.out.println("");
        }
    }
    
}