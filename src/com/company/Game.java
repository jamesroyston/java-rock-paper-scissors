package com.company;
import java.util.Scanner;

public class Game {
    // do these work the same way they would in a constructor?

    static int playerScore = 0;
    static int compScore = 0;
    static int roundCount = 0;

    public void sameChoiceString() {
        System.out.println("Both player's choices match. No winner");
    }

    public void showScore() {
         System.out.println("computer score: " + compScore + ".");
         System.out.println("player score: " + playerScore + ".");
    }

    public void playGame() {
        String playerChoice;

        String rock = "rock";
        String paper = "paper";
        String scissors = "scissors";

        // grab user response in console
        System.out.println("-----------");
        System.out.println("Rock, paper, or scissors?");
        Scanner keyboardInput = new Scanner(System.in);
        playerChoice = keyboardInput.nextLine();
        playerChoice = playerChoice.toLowerCase();

        if (!playerChoice.equals(rock) || !playerChoice.equals(paper) || !playerChoice.equals(scissors)) {
            System.out.println("Player, you failed to enter a valid option-- skipping this round");
        }

        String computerChoice = "";
        String[] choices =  { rock, paper, scissors };

        // generate random number between 0 and 2
        // use number to randomly select value in choices array to set computerChoice
        int randomInt = (int)(3 * Math.random());
        computerChoice = choices[randomInt];

        // display and then increment the round
        System.out.println("Round " + roundCount);

        // compare playerChoice and computerChoice, determine winner
        if(playerChoice.equals(rock)) {

                if (computerChoice.equals(rock)) {
                    sameChoiceString();
                } else if (computerChoice.equals(paper)) {
                    System.out.println(computerChoice+"(c)" + " beats " + playerChoice+"(p)" + ".");
                    compScore++;
                } else if (computerChoice.equals(scissors)) {
                    System.out.println(playerChoice+"(p)" + " beats " + computerChoice+"(c)" + ".");
                    playerScore++;
                }
                showScore();
        }
        if(playerChoice.equals(paper)) {

                if (computerChoice.equals(rock)) {
                    System.out.println(playerChoice+"(p)" + " beats " + computerChoice+"(c)" + ".");
                    playerScore++;
                } else if (computerChoice.equals(paper)) {
                    sameChoiceString();
                } else if (computerChoice.equals(scissors)) {
                    System.out.println(computerChoice+"(c)" + " beats " + playerChoice+"(p)" + ".");
                    compScore++;
                }
                showScore();
        }
        if (playerChoice.equals(scissors)) {

                if (computerChoice.equals(rock)) {
                    System.out.println(computerChoice+"(c)" + " beats " + playerChoice+"(p)" + ".");
                    compScore++;
                } else if (computerChoice.equals(paper)) {
                    System.out.println(playerChoice+"(p)" + " beats " + computerChoice+"(c)" + ".");
                    playerScore++;
                } else if (computerChoice.equals(scissors)) {
                    sameChoiceString();
                }
                showScore();
        }

    }

    public static void main(String[] args) {
        // run game
        Game game = new Game();
        while (compScore != 5 && playerScore != 5) {
            game.playGame();
            roundCount++;
        }
        if (compScore == 5) {
            System.out.println("Computer wins");
            return;
        }
        if (playerScore == 5) {
            System.out.println("Player wins");
            return;
        }

    }
}
