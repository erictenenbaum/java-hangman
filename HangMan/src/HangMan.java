import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

public class HangMan {
    private String hiddenWord;
    private String[] gameArray;
    private ArrayList<String> previouslyGuessedLetters;
    private int remainingGuesses;

    public HangMan(){
        String wordBank[] = {"wolf", "cheetah", "pig", "goat"};
        Random rand = new Random();

        int  n = rand.nextInt(wordBank.length - 1) + 1;

        this.hiddenWord = wordBank[n];

        this.gameArray = Arrays.copyOf(this.dashArr(), this.dashArr().length);
        this.remainingGuesses = 9;
        this.previouslyGuessedLetters = new ArrayList<String>();
    }

   public String getWord(){
       return this.hiddenWord;
   }

   public ArrayList<String> getPreviouslyGuessedLetters(){
        return this.previouslyGuessedLetters;
   }

   public int getRemainingGuesses(){
        return  this.remainingGuesses;
   }

   public String[] getGameArray() {return  this.gameArray;}

   public void addPreviouslyGuessedLetter(String letter){
        this.previouslyGuessedLetters.add(letter);
   }

   public void takeAGuessAway () {
        this.remainingGuesses--;
   }

   public void setWord(String word) {
        this.hiddenWord = word;
   }

   public String[] splitWord(){
        return this.hiddenWord.split("");
   }

   public  String[] dashArr() {
        String dashes[] = new String[this.splitWord().length];

        Arrays.fill(dashes, "_");

        return dashes;
   }

//    need to switch this to an ArrayList and push the matched indexes
   public ArrayList<Integer> checkGuess(String letter){
        String[] referenceArray = Arrays.copyOf(this.splitWord(), this.splitWord().length);
        ArrayList<Integer> indexArr = new ArrayList<>();


        for(int i = 0; i < this.splitWord().length; i++){
            if(referenceArray[i].equals(letter)){
                indexArr.add(i);
            }
        }

        return indexArr;


   }


   public void replaceLetter(ArrayList<Integer> indecies, String letter){

        for(int i = 0; i < indecies.size(); i++){
//            this.gameArray[index] = letter;

//            System.out.println(indecies.get(i));

            this.gameArray[indecies.get(i)] = letter;
        }

   }

   public boolean handleGuesss(String letter){
        if(this.checkGuess(letter).size() == 0){
            this.takeAGuessAway();
            System.out.println("Sorry that letter is not in the word!");
            this.addPreviouslyGuessedLetter(letter);

//            checking if win has occurred otherwise return false

            if(this.getRemainingGuesses() > 0){
                return false;
            }else{
                return true;
            }

        }
        else {
            this.replaceLetter(this.checkGuess(letter), letter);

            if(Arrays.equals(this.gameArray, this.splitWord())){
                return true;
            }else {
                return false;
            }

        }
   }


    public  String askForLetter(String[] gameArray, ArrayList<String> previouslyGuessedLetters, int remainingGuesses){
        Scanner input = new Scanner(System.in);
        System.out.println(Arrays.toString(gameArray));
        System.out.println("Previously guessed letters: " +  previouslyGuessedLetters);
        System.out.println("Remaining Guesses: " + remainingGuesses);

        System.out.println("Please guess a letter");

        String guessedLetter = input.nextLine();

        System.out.println("You guessed " + guessedLetter);

        return guessedLetter;
    }


    public void continueFunction (boolean conditional){
        if(conditional){

            if(this.getRemainingGuesses() > 0){
                System.out.println("Congats you won!");
            }
            else{
                System.out.println("You lost!");
            }

        }
        else{
          continueFunction(this.handleGuesss(this.askForLetter(this.getGameArray(), this.getPreviouslyGuessedLetters(), this.getRemainingGuesses())));
        }
    }

    public void startGame(){
        continueFunction(this.handleGuesss(this.askForLetter(this.getGameArray(), this.getPreviouslyGuessedLetters(), this.getRemainingGuesses())));
    }


}


