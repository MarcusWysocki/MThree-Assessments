import java.util.Locale;
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    final static int MAX_ROUNDS = 10;
    final static int MIN_ROUNDS = 1;

    public static void main(String args[]) {

        boolean playAgain = false;

        do {
            playAgain = playGame();
        }
        while (playAgain);

        System.out.println("Thanks for playing!");
    }

    public static boolean playGame() {

        Scanner in = new Scanner(System.in);
        int rounds = 0;

        System.out.println("How many rounds to play? (Min 1, Max 10)");
        try {
            rounds = in.nextInt();
        } catch (Exception e) {
            System.exit(0);
        }

        if (rounds > MAX_ROUNDS || rounds < MIN_ROUNDS) {
            System.out.println("Outside of range, Goodbye");
            System.exit(0);
        }


        int wins = 0;
        int ties = 0;
        int losses = 0;

        for (int i = 0; i < rounds; i++) {
            System.out.println("========== ROUND " + (i+1) + " ==========");
            char result = playRound();

            switch (result) {
                case 'w':
                    wins++;
                    break;
                case 't':
                    ties++;
                    break;
                case 'l':
                    losses++;
                    break;
            }
        }

        System.out.println("Stats: ");
        System.out.println("Wins: " + wins + " Ties: " + ties + " Losses: " +losses);

        return playAgain();
    }

    /**
     * Takes in player choice then rolls computer choice. Then the outcome is determined.
     * @return a Char representing the outcome of the round 'w' for Win, 't' for Tie, 'l' for Loss.
     */
    public static char playRound() {

        String playerChoice = playerChoice();
        System.out.println("You chose: " + playerChoice);

        Random rand = new Random();
        int compRand = rand.nextInt(3);
        String compChoice = new String();

        switch (compRand) {
            case 0:
                compChoice = "rock";
                break;
            case 1:
                compChoice = "paper";
                break;
            case 2:
                compChoice = "scissors";
                break;
        }

        char result = 'l';
        String resAnoun = "Player loses!";

        System.out.println("Player choice: " + playerChoice + " VS Computer Choice: " + compChoice);

        if (playerChoice.equals(compChoice)) {
            result = 't';
            resAnoun = "Draw!";
        } else if (playerChoice.equals("rock")) {
            if (compChoice.equals("scissors")) {
                result = 'w';
                resAnoun = "Player wins!";
            }
        } else if (playerChoice.equals("paper")) {
            if (compChoice.equals("rock")) {
                result = 'w';
                resAnoun = "Player wins!";
            }
        }  else if (playerChoice.equals("scissors")) {
            if (compChoice.equals("paper")) {
                result = 'w';
                resAnoun = "Player wins!";
            }
        }
        System.out.println(resAnoun);

        return result;
    }


    /**
     *
     * @return The players choice. Recursively gets the player to pick something else if their choice is invalid.
     */
    public static String playerChoice() {

        Scanner in = new Scanner(System.in);
        System.out.println("Choose 'rock', 'paper', or 'scissors'...");
        String playerChoice = in.nextLine().toLowerCase();

        if (playerChoice.equals("rock") || playerChoice.equals("paper") || playerChoice.equals("scissors")) {
            return playerChoice;
        }

        System.out.println("Input not accepted");
        return playerChoice();
    }

    /**
     *
     * @return boolean of whether the game is played again. Recursively checks if the input is valid.
     */
    public static boolean playAgain() {
        Scanner in = new Scanner(System.in);

        System.out.println("Play again? 'Yes' or 'No'");
        String pa = in.nextLine().toLowerCase();

        if (pa.equals("yes")) {
            return true;
        } else if (pa.equals("no")) {
           return false;
        } else {
            return playAgain();
        }
    }
}
