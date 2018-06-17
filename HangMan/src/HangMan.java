import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

public class HangMan {
    private String hiddenWord;
    private String[] gameArray;

//    public HangMan(String word){
//        this.hiddenWord = word;
//    }

    public HangMan(){
        String wordBank[] = {"wolf", "cheetah", "pig", "goat"};
        Random rand = new Random();

        int  n = rand.nextInt(wordBank.length - 1) + 1;

        this.hiddenWord = wordBank[n];

        this.gameArray = Arrays.copyOf(this.dashArr(), this.dashArr().length);
    }

   public String getWord(){
       return this.hiddenWord;
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

//   public String[] checkGuess (String letter){
//        System.out.println("Letter to check " + letter);
//       String[] tempDashes = Arrays.copyOf(this.dashArr(), this.dashArr().length);
//       String[] referenceArray = this.splitWord();
//
//
//
//       for(int i = 0; i < referenceArray.length; i++){
//           if(referenceArray[i].equals(letter)){
//               System.out.println("it worked!");
//               tempDashes[i] = letter;
//           }
//
//
//       }
//
//
//       return tempDashes;
//
//   }

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


   public void replaceLetter(int index, String letter){
        this.gameArray[index] = letter;
   }

}


