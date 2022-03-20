/**
* The RockPaperScissors program pits a computer vs the user
* It counts the number of wins and losses as wells as ties
*
* @author  Liam Csiffary
* @version 1.0
* @since   2022-03-20 
*/

// import necessary modules
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    // finds and returns the winner if there is one
    public static int WhoWon(int user, int computer) {

        // these two essentially allow the code to loop around a 0-2 range
        // for example if computer is 2 and we add 1 it will be 0
        // this makes the next step shorter
        // this is probably pointless and more complicated for no reason
        // but I wanted to see if it was possible
        int computerWinVar;
        if (computer == 0) {
            computerWinVar = 3;
        } else {
            computerWinVar = computer;
        }
        int userWinVar;
        if (user == 0) {
            userWinVar = 3;
        } else {
            userWinVar = user;
        }

        if (user == computer) { // tie
            return 0;
        } else if (user + 1 == computerWinVar) { // computer wins
            return 1;
        } else if (userWinVar - 1 == computer) { // player wins
            return 2;
        } else { // should never occur
            System.out.println("impossible");
            return 3;
        }
    }

    public static void main(String[] args) {
        // explanation
        System.out.println("This is rock paper scissors, guess one of the three and beat the computer!");

        // creates/gets all manner of vars
        Scanner myScanner = new Scanner(System.in);
        int UPPERBOUND = 3; // I used a constant!
        int userInputAbsolute = 0;
        System.out.println("First to what number of  wins: ");
        String numRoundsString = myScanner.nextLine();
        int numRoundsInt = Integer.parseInt(numRoundsString);
        int userWins = 0;
        int computerWins = 0;
        int ties = 0;

        // enables a loop so the user can play multiple rounds
        // breaks when someone wins the specified number of rounds
        while (numRoundsInt > userWins && numRoundsInt > computerWins) {
            Random rand = new Random(); // creates random class var, kind of like the Scanner class
            int int_random = rand.nextInt(UPPERBOUND);

            // loops until the user inputs a valid input
            boolean invalidGuess = true;
            while (invalidGuess == true) {
                invalidGuess = false;
                // gets users input
                System.out.print("\nRock paper Scissors: ");
                System.out.println("input: 1 2 3, r p s, or rock paper scissors");
                String userInput = myScanner.nextLine();

                // puts the users input to lower case to avoid any accidents
                String userInputLower = userInput.toLowerCase();

                // creates an absolute input depending on which method the user used
                if (userInputLower.equals("r") || userInputLower.equals("1") || userInputLower.equals("rock")) {
                    userInputAbsolute = 0;
                    System.out.println("You guessed Rock");
                } else if (userInputLower.equals("p") || userInputLower.equals("2") || userInputLower.equals("paper")) {
                    userInputAbsolute = 1;
                    System.out.println("You guessed Paper");
                } else if (userInputLower.equals("s") || userInputLower.equals("3")
                        || userInputLower.equals("scissors")) {
                    userInputAbsolute = 2;
                    System.out.println("You guessed Scissors");
                } else {
                    System.out.println("Invalid guess, please try again");
                    invalidGuess = true;
                }
            }

            // tells the user what the computer guessed
            if (int_random == 0) {
                System.out.println("computer guesed rock");
            } else if (int_random == 1) {
                System.out.println("computer guesed paper");
            } else {
                System.out.println("computer guesed scissors");
            }

            // tells the user who won
            int winOrLose = WhoWon(userInputAbsolute, int_random);
            if (winOrLose == 0) {
                System.out.println("You tied");
                ties++;
            } else if (winOrLose == 1) {
                System.out.println("You lost");
                computerWins++;
            } else {
                System.out.println("You won");
                userWins++;
            }
            System.out.println("Current score is " + userWins + "-" + computerWins + "-" + ties);
        }

        // once either side has one prints the total score
        if (userWins > computerWins) {
            System.out.println("Congratulation you won!" + "\nThe score was " + userWins + " - " + computerWins);
        } else {
            System.out.println("The computer won!" + "\nThe score was " + computerWins + " - " + userWins);
        }
        System.out.println("There were " + ties + " ties");
    }
}
