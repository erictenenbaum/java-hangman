import java.util.Arrays;
import java.util.Scanner;
public class Game {

    public static  void main (String[] args){
        HangMan varOne = new HangMan();

       System.out.println(varOne.getWord());

       System.out.println(Arrays.toString(varOne.splitWord()));

       System.out.println(Arrays.toString(varOne.dashArr()));

       Scanner input = new Scanner(System.in);

        System.out.println("Please select a letter");
        String guessedLetter = input.nextLine();

        System.out.println("You guessed " + guessedLetter);

        System.out.println(varOne.checkGuess(guessedLetter));






    }
}
