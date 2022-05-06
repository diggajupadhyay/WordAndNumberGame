import java.util.*;
import java.util.Arrays;

/**
 * SecondLevel class will notify users about the second level of the game and the task the user needs to complete.
 * The program will display sequence of five random words from the anagram dictionary stored in game class with the letters of each word scrambled.
 * Users must validate atleast 3 words correctly to pass the level.
 * If passed, users will go to next level if not they will be notified that the level is failed.
 *
 * @author Diggaj Upadhyay
 * @version 10.04.2022
 */

public class SecondLevel extends Game
{
    // instance variables
    static Boolean levelPassed = false;
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> currentWords = new ArrayList<String>();
    
    // start level method - initializing the level
    public static void StartLevel(HashMap<String, ArrayList<String>> anagramDictionary)
    {
        // notify the user about the level - print method
        System.out.println("LEVEL 2: Scrambled Words");
        System.out.println("At this level, you are given a set of scrambled words.");
        System.out.println("Your task is to input a non-scrambled version of the words that you can come up with, separated by spaces.");
        System.out.println("You win if there are at least three correct words.");
        System.out.println("***");
        System.out.print("Your scrambled words: ");
        ArrayList<String> scrambledWords = PrintAndReturnScrambledWords(anagramDictionary);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Please give your input: ");
        String userInput = sc.nextLine();
        
        List<String> wrongInputs = new ArrayList<String>();

        // verify the user input - if correct, go to next level
        Boolean correctInput = VerifyInput(userInput, currentWords, wrongInputs, anagramDictionary);

        if(correctInput)
        {
            System.out.println("Congratulations! You completed level 2 successfully");
            levelPassed = true;
            return;
        }
        // if incorrect, ask for the second chance if not notify the user for failed attempt
        else
        {
            System.out.println("Fail! at least three inputted words must be valid");
            System.out.print("Your words ");
            // checking for the wrong inputs
            for(String wrongWord : wrongInputs)
            {
                System.out.print(wrongWord + ", ");
            }
            System.out.println("are invalid.");
            System.out.println("***");

            System.out.println("Please give your input (second chance): ");
            String userInput2 = sc.nextLine();
        
            List<String> wrongInputs2 = new ArrayList<String>();
            
            // check the input again - if correct, go to next level
            Boolean correctInput2 = VerifyInput(userInput2, currentWords, wrongInputs2, anagramDictionary);
            
            if(correctInput2)
            {
                System.out.println("Congratulations! You completed level 2 successfully");
                levelPassed = true;
                return;
            }
            else
            {
                System.out.println("You failed your second chance!");
                System.out.print("Your words ");
                for(String wrongWord : wrongInputs2)
                {
                    System.out.print(wrongWord + ", ");
                }
                System.out.println("are invalid.");
                System.out.println("Game over");
                return;
            }
        }
    }
    // print the scrambled words and return the arraylist of scrambled words
    private static ArrayList<String> PrintAndReturnScrambledWords(HashMap<String, ArrayList<String>> anagramDictionary)
    {
        ArrayList<String> scrambledWords = new ArrayList<String>();
        // get the random words from the dictionary
        ArrayList keys = GetKeys(anagramDictionary);
        currentWords = Get5RandomWords(keys);
        // print the scrambled words
        scrambledWords = ScrambleWords(currentWords);
        
        for(String scrambledWord : scrambledWords)
        {
            System.out.print(scrambledWord + " ");
        }
        
        return scrambledWords;        
    }
    // get the keys from the dictionary
    private static ArrayList<String> Get5RandomWords(ArrayList<String> keys)
    {
        ArrayList<String> listOfRandomWords = new ArrayList<String>();
        // get 5 random words from the dictionary
        Random rand = new Random();
        int i;
        for(i = 0 ; i < 5; i ++)
        {
            int a = rand.nextInt(keys.size()-1);
            // add the random word to the list
            listOfRandomWords.add(keys.get(a));
            keys.remove(a);
        }
        
        return listOfRandomWords;
    }
    
    // generate a random word from the dictionary and return its anagrams as an arraylist
    private static ArrayList<String> ScrambleWords(ArrayList<String> words)
    {
        ArrayList<String> scrambledWords = new ArrayList<String>();
        // scramble the words
        for(String word : words)
        {
            char[] charArray = new char[word.length()];
            charArray = word.toCharArray();
            // scramble the letters
            int i;
            for(i = 0; i < charArray.length-1; i ++)
            {
                char c = charArray[i];
                charArray[i] = charArray[i+1];
                charArray[i+1] = c;
            }
            // add the scrambled word to the arraylist
            String scrambledWord = new String();
            int j = charArray.length - 1;
            while(j > -1)
            {
                // add the scrambled letters to the string
                scrambledWord = scrambledWord + charArray[j];
                j --;
            }
            // add the scrambled word to the arraylist
            scrambledWords.add(scrambledWord);
        }
        // return the arraylist of scrambled words
        return scrambledWords;
    }
    
    // check how many words are correct
    private static Boolean VerifyInput(String input, ArrayList<String> initialWords, List<String> wrongWords, HashMap<String, ArrayList<String>> anagramDictionary)
    {
        // split the input into words
        List<String> inputList = new ArrayList<String>(Arrays.asList(input.split(" ")));
        int noOfCorrectWords = 0;
        // check if the input is correct
        int i;
        // check if the input is correct
        for(i = 0; i < 5; i ++)
        {

            String correctCurrentWord = initialWords.get(i);
            String inputCurrentWord = inputList.get(i);
            if(correctCurrentWord.equals(inputCurrentWord) || anagramDictionary.get(correctCurrentWord).contains(inputCurrentWord))
            {
                noOfCorrectWords ++;
            }
            else
            {
                wrongWords.add(inputCurrentWord);
            }
        }
        // if there are at least three correct words, return true
        if(noOfCorrectWords >= 3)
        {
            return true;
        }
        return false;
    }
    
    // check if the input anagram in the dictionary and two or more words are correct
    private static ArrayList<String> GetKeys(HashMap<String, ArrayList<String>> anagramDictionary)
    {
        ArrayList<String> keys = new ArrayList<String>();
        // get the keys from the dictionary
        for(String key : anagramDictionary.keySet())
        {
            keys.add(key);
        }

        return keys;
    }
}
