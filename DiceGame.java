

package com.mycompany.dicegame;

/**
 *
 * @author 88019
 */
import java.util.Scanner;
import java.util.Random;

public class DiceGame {
    static TwoDice twoDice = new TwoDice();
    static int playerScore = 0;
    static int compScore = 0;
    static Random rand = new Random();

    public static void main(String[] args) {
        showInitialMessages();
             
        while (true){
            playerTurn();
            if (playerScore >= 60){
                winningMessage(0); /*putting 0 as the integer in method 
                winnerMessage would generate a winning text with 'you'*/
                break;
            }
            computerTurn();
            if (compScore >= 60){
                winningMessage(1);
                break;
            }
        }
       
    }
    public static void showInitialMessages(){
        System.out.println("===================================");
        System.out.println("        The Dice Game              ");
        System.out.println("  How Much Can You Afford to Lose?  ");
        System.out.println("Roll the dice, accumulating the total to add to"
                + " your score.");
        System.out.println("Hit 60 before the computer and you win!");
        System.out.println("If you roll doubles, you get double the value! And "
                + "you must roll again.");
        System.out.println("If you roll a one - you are done,\n"
                + "            unless it's snake eyes!");
        twoDice.printDisplay();
        System.out.println("");
        System.out.println("Here we go...");
    }
    
    /*This method is for the player turn and updating the score accordingly,
    for each type of combination of the dicenumber
    */
    public static void playerTurn(){
        int roundScore = 0;
        System.out.println("--------------------------------------");
        System.out.println("Your turn");
        boolean shouldRoll = true;
        while(shouldRoll){
            System.out.println("Rolling...");
            twoDice.roll();
            twoDice.printDisplay();
            //if doubles are rolled, score doubles and gets to roll back
            if (twoDice.getValue1() == twoDice.getValue2()){
                System.out.println("Doubles! Roll again!");
                roundScore+=(twoDice.getValue1()+twoDice.getValue2())*2;
            }
            /*if one of the value is 1, shouldroll is false, no roll. While
            loop is false. Score becomes 0 again.*/
            
            else if (twoDice.getValue1() == 1 || twoDice.getValue2() == 1){
                shouldRoll = false;
                System.out.println("OH NO...You lost it all!\n" +
                "You lost: "+ roundScore);
                roundScore = 0;
                printScore();
            }
            /*Otherwise, they have 2 different values of dice. Depending on the 
            user if he wants to play further
            */
            else{
                roundScore += twoDice.getValue1()+twoDice.getValue2();
                while(true){
                    System.out.println("Roll Again? (current score is: "+ 
                            roundScore+" Enter 'y' for yes 'n' for no:");
                    Scanner input = new Scanner(System.in);
                    String answer = input.nextLine();
                    if (answer.startsWith("y")|| //roll if first letter y
                            answer.startsWith("Y")){
                            break;  
                            
                        }
                    else if (answer.startsWith("n")|| 
                            answer.startsWith("N")){
                        System.out.println("Staying");
                        playerScore+=roundScore;
                        printScore();
                        shouldRoll = false; //first letter is n, hence no roll
                        break;
                    }
                    else{
                        System.out.println("Sorry did not recognize your resp"
                                + "onse"); 
                        
                    }
                }
            }
        }
        
    }
    /*This method prints the score message everytime*/
    public static void printScore(){
        System.out.println("Score: Player "+ playerScore+"; Computer "+ 
                compScore);
    }
    /*This method prints the computer turn and updates score according to the
    combination of the 2 values of dice received.
    */
    public static void computerTurn(){
        int roundScoreComp = 0;
        System.out.println("--------------------------------------");
        System.out.println("Computer's turn");
        boolean shouldRoll = true;
        while(shouldRoll){
            System.out.println("Rolling...");
            twoDice.roll();
            twoDice.printDisplay();
            if (twoDice.getValue1() == twoDice.getValue2()){
                roundScoreComp += (twoDice.getValue1()+twoDice.getValue2())*2;
            }
            else if (twoDice.getValue1() == 1 || twoDice.getValue2() == 1){
                shouldRoll = false;
                printScore();
                roundScoreComp = 0;
            }
            else{
                /*Randomly generating 3 numbers, 1 for no roll and 2,3 for roll,
                 making the chance for roll 2/3 */
                roundScoreComp += twoDice.getValue1()+twoDice.getValue2();
                int turn = rand.nextInt(3);
                if(turn == 1){
                    shouldRoll = false;
                    System.out.println("Staying\n");
                    compScore += roundScoreComp;
                    printScore();
                }
                else{
                    shouldRoll = true;
                }
                    
            }
    }
}    //*This method prints the winning message
    public static void winningMessage(int winner){
        String name;
        if (winner == 0){ //To call the function to announce the winner
            name = "You";
        }
        else {
            name = "Computer";
        }
        System.out.println("TaTaTah Drum rollllllll\n" +
            "The winner is:  "+ name);
    }
}
