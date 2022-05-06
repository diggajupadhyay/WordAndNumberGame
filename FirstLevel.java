import java.util.*;

/**
 * FirstLevel Class will notify users about the first level of the game and the task the user needs to complete.
 * The program will then generate letters randomly from the word for each play and attempt.
 * The user needs to guess the word correctly to pass the level. If incorrect the user will be given second chance.
 * But, if the user fails to guess the word within the second attempt, the user will be notified that the level is failed.
 *
 * @author Diggaj Upadhyay
 * @version 10.04.2022
 */
public class FirstLevel extends Game
{
    // instance variables
    static Boolean levelPassed = false;
    static Scanner sc = new Scanner(System.in); 
    static String currentWord;
    
    // start level method - initializing the level
    public static void StartLevel(HashMap<String, ArrayList<String>> anagramDictionary)
    {
        // notify the user about the level - print method
        System.out.println("Welcome to The Word And Number Game.");
        System.out.println("LEVEL1: Anagram");
        System.out.println("At this level, you are given a set of letters.");
        System.out.println("Your task is to input all valid words that you can come up from the letters separated by spaces.");
        System.out.println("Note that each word must use all letters.");
        System.out.println("You win if there are at least two correct words.");
        System.out.println("***");
        
        // generate a random word from the dictionary
        System.out.print("Your letters: ");
        ArrayList<String> anagrams = PrintRandomWordAndReturnItsAnagrams(anagramDictionary);
        
        // generate a random word from the dictionary
        System.out.println();
        System.out.println("Please give your input: ");
        String userInput = sc.nextLine();
        
        List<String> wrongInputs = new ArrayList<String>();
        
        // verify the user input
        Boolean correctInput = VerifyInputs(currentWord, userInput, anagrams, wrongInputs);
        
        if(correctInput)
        {
            System.out.println("Congratulations! You completed level 1 successfully");
            levelPassed = true;
            return;
        }
        else
        {
            // if incorrect, ask for the second chance if not notify the user for failed attempt
            System.out.println("Fail! at least two inputted words must be valid");
            System.out.print("Your words ");
            for(String wrongWord : wrongInputs)
            {
                System.out.print(wrongWord + ", ");
            }
            System.out.println("are wrong.");
            System.out.println("***");

            System.out.print("Your letters: ");
            ArrayList<String> anagrams2 = PrintRandomWordAndReturnItsAnagrams(anagramDictionary);
        
            System.out.println("Please give your input (second chance): ");
            String userInput2 = sc.nextLine();
        
            List<String> wrongInputs2 = new ArrayList<String>();
            // check the input again - if correct, go to next level
            Boolean correctInput2 = VerifyInputs(currentWord, userInput2, anagrams2, wrongInputs2);
            
            if(correctInput2)
            {
                System.out.println("Congratulations! You completed level 1 successfully");
                levelPassed = true;
                return;
            }
            else
            {
                System.out.println("You failed your second chance! Game over.");
                return;
            }
        }
    }
    
    // generate a random word from the dictionary and return its anagrams as an arraylist
    private static ArrayList<String> PrintRandomWordAndReturnItsAnagrams(HashMap<String, ArrayList<String>> anagramDictionary)
    {
        // generate a random word from the dictionary
        Random rand = new Random();
        int a = rand.nextInt(19);
        int i;
        
        // get the length of the word inputed by the user
        List<String> words = new ArrayList<String>(anagramDictionary.keySet());
        currentWord = words.get(a);
        // print the word
        for(i = 0; i < currentWord.length(); i++)
        {
            System.out.print(currentWord.charAt(i) + " ");
        }
        // print the anagrams
        System.out.println();
        return anagramDictionary.get(currentWord);
    }
    // check how many words are correct
    private static Boolean VerifyInputs(String initialWord, String input, ArrayList<String> anagramsList, List<String> wrongInputs)
    {
        List<String> inputList = new ArrayList<String>(Arrays.asList(input.split(" ")));
        int noOfCorrectWords = 0;
        
        // check if the input anagram in the dictionary and two or more words are correct
        for(String inputWord : inputList)
        {
            // check if the input word is in the dictionary
            if(anagramsList.contains(inputWord))
            {
                noOfCorrectWords ++;
            }
            else
            {
                wrongInputs.add(inputWord);
            }
        }
        // if two or more words are correct, return true
        if(noOfCorrectWords >= 2)
        {
            return true;
        }
        return false;
    }
}
