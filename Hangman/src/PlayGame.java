
import java.util.Scanner;
public class PlayGame {
    public static int gamesWon = 0;
    public static int gamesLost = 0;

    public static void main(String[] args) {
       Scanner keyboard = new Scanner(System.in);
       String reply;
       boolean playAgain;
        do{
            Hangman aGame = new Hangman();
            try{
                processGuesses(aGame);
            }
            catch(Exception e){
                System.out.println("Next time please enter an input before pressing enter.\n");
            }
            determineWinner(aGame);
            System.out.println("Play again? Enter 'Yes' or 'No'");
            reply = keyboard.nextLine();
            playAgain = (reply.equalsIgnoreCase("yes"));    //Able to assign yes to play again
        }
        while(playAgain);
        summarize();
    }

    public static void processGuesses(Hangman aGame) {
        Scanner keyboard = new Scanner(System.in);
        int secretWordLength = aGame.getSecretWord().length();
        int chances = 3 * secretWordLength;
        int usedChances = 0;
        int loc = -1;
        System.out.println("Welcome to Hangman");
        //Makes sure there is a limit to the chances
        while (usedChances < chances && !aGame.getSecretWord().equalsIgnoreCase(aGame.getUserGuess())) {
            usedChances++;
            System.out.println("Enter a letter (lower case)");
            String letter = keyboard.nextLine();
            //Puts the letter in the correct spots
            do {
                loc++;
                loc = aGame.getSecretWord().indexOf(letter, loc);
                if (loc != -1) {
                    String partA = aGame.getUserGuess().substring(0, loc);
                    String partB = aGame.getUserGuess().substring(loc + 1);
                    aGame.setUserGuess(partA + letter + partB);
                }
            }
            while (loc != -1);
            System.out.println(aGame.getUserGuess());
        }
    }

        public static void determineWinner(Hangman aGame){
            Scanner keyboard = new Scanner(System.in);
            //Determines if you are the winner or not
        if(aGame.getUserGuess().equalsIgnoreCase(aGame.getSecretWord())){
        System.out.println("Congratulations! You guessed the word!");
        gamesWon++;
    }
        else{
        System.out.println("You have one more chance to guess the word.\nEnter the word you think it is.");
        String letter = keyboard.nextLine();
        aGame.setUserGuess(letter);
        if(aGame.getUserGuess().equalsIgnoreCase(aGame.getSecretWord())) {
            System.out.println("Congratulations! You guessed the word!");
            gamesWon++;
        }
        else {
            System.out.println("Sorry, you did not guess the word correctly.");
            gamesLost++;
        }
        }
    }

    public static void summarize(){
        System.out.println("Number of games won: " + gamesWon);
        System.out.println("Number of games lost: " + gamesLost);
    }
         }


