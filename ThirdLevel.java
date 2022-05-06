import java.util.*;
import java.util.Arrays;

/**
 * ThirdLevel class will notify users about the third level of the game and the task the user needs to complete.
 * It will generate random sequence of five words. The users will be asked to decode the hashcode and input the original series of words.
 * It will also show an example of the hashcode and the original words.
 * When the users input the correct words, they will be notified that they have completed the game sucessfully.
 * If not, they will be notified that they have failed the level.
 *
 * @author Diggaj Upadhyay
 * @version 10.04.2022
 */
public class ThirdLevel extends Game
{
    // instance variables
    static Boolean levelPassed = false;
    static Scanner sc = new Scanner(System.in);
    private static ArrayList<String> currentWords;
    private static ArrayList<String> encodingLetters = new ArrayList<String>();
    private static ArrayList<String> encodingSymbols = new ArrayList<String>();
    
    public static void StartLevel(HashMap<String, ArrayList<String>> anagramDictionary)
    {
        // notify the user about the level - print method
        System.out.println("LEVEL 3: Encoded words");
        System.out.println("At this level, you are given a set of encoded words.");
        System.out.println("Your task is to input the decoded version of the words that you can come up with.");
        System.out.println("You win if all words are correctly decoded.");
        System.out.println("Sample for you: 8*,18@0#22!,0%,3@14&6^ is the decoded as “i saw a dog”");
        System.out.println("***");
        // generate the random sequence of words
        CreateEncodingArrays(encodingLetters, encodingSymbols);
        // print the encoding
        System.out.print("Your encoded words: ");
        ArrayList<String> encodedWords = PrintAndReturnEncodedWords(anagramDictionary);
        System.out.println("");
        System.out.println(" ");
        // print the example of the hashcode
        System.out.println("Please give your input: ");
        String userInput = sc.nextLine();
        // verify the user input - if correct, go to next level
        List<String> wrongInputs = new ArrayList<String>();
        
        Boolean correctInput = VerifyInput(userInput, currentWords, wrongInputs);
        
        if(correctInput)
        {
            System.out.println("Congratulations! You won the game");
            levelPassed = true;
            return;
        }
        else
        {
            System.out.println("Fail! all inputted words must be valid");
            System.out.print("Your words ");
            for(String wrongWord : wrongInputs)
            {
                System.out.print(wrongWord + ", ");
            }
            System.out.println("are invalid.");
            System.out.println("***");

            System.out.println("Please give your input (second chance): ");
            String userInput2 = sc.nextLine();
        
            List<String> wrongInputs2 = new ArrayList<String>();
        
            Boolean correctInput2 = VerifyInput(userInput2, currentWords, wrongInputs2);
            
            if(correctInput2)
            {
                System.out.println("Congratulations! You won the game");
                levelPassed = true;
                return;
            }
            else
            {
                System.out.println("You failed your second chance!");
                System.out.println("Game over");
                return;
            }
        } 
        
    }
    // method to create the encoding arrays
    private static Boolean VerifyInput(String input, ArrayList<String> correctWords, List<String> wrongInput)
    {
        // split the input into words and store them in an array list of strings
        List<String> inputList = new ArrayList<String>(Arrays.asList(input.split(" ")));
        int noOfCorrectWords = 0;
        /** loop through the input list and check if the words are correct or not - 
        * if correct, increment the counter by 1 and add the word to the correct words list
        */
        int i;
        for(i = 0; i < 5; i ++)
        {
            String correctCurrentWord = correctWords.get(i);
            String inputCurrentWord = inputList.get(i);
            
            if(correctCurrentWord.equals(inputCurrentWord))
            {
                noOfCorrectWords ++;
            }
            else
            {
                wrongInput.add(inputCurrentWord);
            }
        }
        // if all words are correct, return true else return false
        if(noOfCorrectWords == 5)
        {
            return true;
        }
        
        return false;
    }
    // method to create the encoding arrays - generate the random sequence of words and store them in the encoding arrays 
    private static ArrayList<String> PrintAndReturnEncodedWords(HashMap<String, ArrayList<String>> anagramDictionary)
    {
        ArrayList<String> encodedWords = new ArrayList<String>();
        // generate the random sequence of words
        ArrayList keys = GetKeys(anagramDictionary);
        currentWords = Get5RandomWords(keys);
        encodedWords = EncodeWords(currentWords);
        for(String encodedWord : encodedWords)
        {
            System.out.print(encodedWord + ",");
        }
        return encodedWords;        
    }
    // method to get the keys from the hashmap - used to generate the random sequence of words
    private static ArrayList<String> EncodeWords(ArrayList<String> currentWords)
    {
        ArrayList<String> encodedWordsList = new ArrayList<String>();
        Random rand = new Random();
        // loop through the current words and encode them
        for(String word : currentWords)
        {
            String encodedWord = new String();
            // loop through the letters of the word and encode them
            char[] wordList = word.toCharArray(); 
            
            for(char ch : wordList)
            {
                String chString = String.valueOf(ch);
                int a = encodingLetters.indexOf(chString);
                
                String character = Integer.toString(a);
                
                encodedWord = encodedWord.concat(character);
                encodedWord = encodedWord.concat(encodingSymbols.get(rand.nextInt(6)));
            }
            // add the encoded word to the list
            encodedWordsList.add(encodedWord);
        }
        // return the list of encoded words
        return encodedWordsList;
    }
    // method to get the keys from the hashmap - used to generate the random sequence of words
    private static ArrayList<String> Get5RandomWords(ArrayList<String> keys)
    {
        ArrayList<String> listOfRandomWords = new ArrayList<String>();
        
        Random rand = new Random();
        int i;
        for(i = 0 ; i < 5; i ++)
        {
            int a = rand.nextInt(keys.size()-1);
            
            listOfRandomWords.add(keys.get(a));
            keys.remove(a);
        }
        
        return listOfRandomWords;
    }
    // method to get the keys from the hashmap - used to generate the random sequence of words
    private static ArrayList<String> GetKeys(HashMap<String, ArrayList<String>> anagramDictionary)
    {
        ArrayList<String> keys = new ArrayList<String>();
        
        for(String key : anagramDictionary.keySet())
        {
            keys.add(key);
        }

        return keys;
    }
    // method to create the encoding arrays - generate the random sequence of words and store them in the encoding arrays
    private static void CreateEncodingArrays(ArrayList<String> encodingLetters, ArrayList<String> encodingSymbols)
    {
        // create the encoding arrays - letters and symbols - from the alphabet and the symbols array list 
        int i = 97;
        for(i = 97; i <= 122; i ++)
        {
            char ch = (char)i;
            String letter = String.valueOf(ch);
            // add the letter to the encoding letters array
            encodingLetters.add(letter);
        }
        
        encodingSymbols.add("!");
        encodingSymbols.add("@");
        encodingSymbols.add("#");
        encodingSymbols.add("$");
        encodingSymbols.add("%");
        encodingSymbols.add("&");
        encodingSymbols.add("*");
    }
    
}

