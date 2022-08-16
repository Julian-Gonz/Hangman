
import java.util.Random;
public class Hangman {
    private String secretWord;
    private String userGuess;

    public Hangman(){
        Random myRan = new Random();
        int num = myRan.nextInt(1,6);  //Randomly selects secret word for user to guess
        // Each number is given a specific word
        if(num == 1) {
            this.secretWord = "jaguar";
        }
        else if(num == 2){
            this.secretWord = "elephant";
        }
        else if(num == 3){
            this.secretWord = "eagle";
        }
        else if(num == 4){
            this.secretWord = "dolphin";
        }
        else if(num == 5){
            this.secretWord = "whale";
        }
        //Displays the "_" for the user to see the amount of letters in the word
        int numLetters = secretWord.length();
        userGuess = "";
        for(int i = 0; i < numLetters; i++){
            userGuess += "_";
        }
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    public String getSecretWord(){
        return secretWord;
    }

    public void setUserGuess(String userGuess){
        this.userGuess = userGuess;
    }

    public String getUserGuess(){
        return userGuess;
    }

    public String toString(){
        return "Secret word- " + secretWord + "\nUser guess- " + userGuess;
    }
}

