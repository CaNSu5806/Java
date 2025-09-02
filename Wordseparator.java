import java.util.Scanner;
import java.util.ArrayList;

public class Wordseparator{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = scan.nextLine().toLowerCase();

        String vowels = "aeiou";
        String consonants = "bcdfghjklmnpqrstvwxyz";

        int vowel_counter = 0;
        int consonant_counter = 0;
        int space_counter = 0;

    // --- Counting vowels, consonants, spaces ---

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (vowels.indexOf(ch) != -1){
                vowel_counter ++;
            }else if (consonants.indexOf(ch) != -1){
                consonant_counter ++;
            }else if (ch == ' '){
                space_counter ++;
            }
        }
        System.out.println("Vowels:  " + vowel_counter);
        System.out.println("Consonants: " + consonant_counter);
        System.out.println("Space: " + space_counter);

    // --- Most frequent letter ---

        int[] counts  = new int[26];

        for(int i = 0; i < text.length(); i++){

            char ch = text.charAt(i);
            if(ch >= 'a' && ch <= 'z') {
                counts[ch - 'a']++; //convert index to letter
            }
        }
        int maxLetterCount = 0;
        char mostFreqLetter = ' ';

        for(int i = 0; i < 26; i++){
            if(counts[i] > maxLetterCount) {
                maxLetterCount = counts[i];
                mostFreqLetter = (char) (i+'a'); //convert index to letter

            }
        }    
        
    // --- Most frequent words using ArrayList ----

        String[] words = text.split("\\s+");
        ArrayList<String> mostFreqWords = new ArrayList<>();
        int maxWordCount = 0; 

        for(int i = 0; i< words.length; i++) {
            int wordCount = 0;
            for(int j = 0; j<words.length ; j++){
                if (words[i].equals(words[j])) // same words?
                wordCount++;

            }
            if (wordCount > maxWordCount) {
                maxWordCount = wordCount;
                mostFreqWords.clear(); //Clear previous words
                mostFreqWords.add(words[i]); //Add new word
            }else if (wordCount == maxWordCount){
                if(!mostFreqWords.contains(words[i])){
                     mostFreqWords.add(words[i]);
                }
            }

        }
        if (maxLetterCount > 0) {
            System.out.print("\nThe letter \"" + mostFreqLetter + "\" is the most frequently used letter and ");
            System.out.print("appears in the text " + maxLetterCount + " times");
        } else {
            System.out.println("\nEach letter repeats an equal number of times");
        }

        if (maxWordCount > 0) {
            System.out.print("\nThe word(s) " + mostFreqWords + " is/are the most frequently used word(s) and ");
            System.out.print("appear(s) in the text " + maxWordCount + " times");
        } else {
            System.out.println("\nEach word repeats an equal number of times");
        }

        scan.close();
    }
}

