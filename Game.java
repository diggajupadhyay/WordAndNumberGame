import java.util.*;

/**
 * Game class is responsible for the game loop and the logic of the game.
 * Here the dictionary is created using the anagrams word.
 * The game loop is also implemented with different levels.
 * It also contains the main method.
 *
 * @author Diggaj Upadhyay
 * @version 10.04.2022
 */
public class Game
{
    // instance variables - creating a dictionary of anagram words
    static HashMap<String, ArrayList<String>> AnagramDictionary = new HashMap<String, ArrayList<String>>();
     
    // start method - initializing the game
    public void StartGame()
    {
        // create a dictionary of anagram words
        CreateAnagramDictionary(AnagramDictionary);
        
        // clear the screen in the start of the game
        clearScreen();
        // start the game loop
        FirstLevel.StartLevel(AnagramDictionary);
        // if level is passed, start the second level
        if(FirstLevel.levelPassed)
        {
            SecondLevel.StartLevel(AnagramDictionary);
        }
        // if level is passed, start the third level
        if(SecondLevel.levelPassed)
        {
            ThirdLevel.StartLevel(AnagramDictionary);
        }
    }
    
    // create dictionary method with given anagrams
    static void CreateAnagramDictionary(HashMap<String, ArrayList<String>> anagramDictionary)
    {
        ArrayList<String> lateList = new ArrayList<String>();
        lateList.add("tale");
        lateList.add("teal");
        anagramDictionary.put("late", lateList);
        
        ArrayList<String> pateList = new ArrayList<String>();
        pateList.add("peat");
        pateList.add("tape");
        anagramDictionary.put("pate", pateList);
        
        ArrayList<String> pareList = new ArrayList<String>();
        pareList.add("pear");
        pareList.add("reap");
        anagramDictionary.put("pare", pareList);
        
        ArrayList<String> parseList = new ArrayList<String>();
        parseList.add("asper");
        parseList.add("pares");
        parseList.add("pears");
        parseList.add("prase");
        anagramDictionary.put("parse", parseList);
        
        ArrayList<String> rateList = new ArrayList<String>();
        rateList.add("tare");
        rateList.add("tear");
        anagramDictionary.put("rate", rateList);
        
        ArrayList<String> talesList = new ArrayList<String>();
        talesList.add("stale");
        talesList.add("slate");
        talesList.add("tesla");
        talesList.add("steal");
        talesList.add("least");
        anagramDictionary.put("tales", talesList);
        
        ArrayList<String> eastList = new ArrayList<String>();
        eastList.add("eats");
        eastList.add("sate");
        eastList.add("seat");
        eastList.add("seta");
        eastList.add("teas");
        anagramDictionary.put("east", eastList);
        
        ArrayList<String> alertsList = new ArrayList<String>();
        alertsList.add("alters");
        alertsList.add("artels");
        alertsList.add("estral");
        alertsList.add("laster");
        alertsList.add("ratels");
        alertsList.add("salter");
        alertsList.add("slater");
        alertsList.add("staler");
        anagramDictionary.put("alerts", alertsList);
        
        ArrayList<String> postList = new ArrayList<String>();
        postList.add("pots");
        postList.add("spot");
        postList.add("stop");
        postList.add("tops");
        anagramDictionary.put("post", postList);
        
        ArrayList<String> alertingList = new ArrayList<String>();
        alertingList.add("altering");
        alertingList.add("integral");
        alertingList.add("relating");
        alertingList.add("triangle");
        anagramDictionary.put("alerting", alertingList);
        
        ArrayList<String> steakList = new ArrayList<String>();
        steakList.add("skate");
        steakList.add("stake");
        steakList.add("takes");
        anagramDictionary.put("steak", steakList);
        
        ArrayList<String> liveList = new ArrayList<String>();
        liveList.add("evil");
        liveList.add("veil");
        liveList.add("vile");
        anagramDictionary.put("live", liveList);
        
        ArrayList<String> meatList = new ArrayList<String>();
        meatList.add("mate");
        meatList.add("team");
        meatList.add("tame");
        anagramDictionary.put("meat", meatList);
        
        ArrayList<String> insertList = new ArrayList<String>();
        insertList.add("estrin");
        insertList.add("inerts");
        insertList.add("inters");
        insertList.add("niters");
        insertList.add("nitres");
        insertList.add("sinter");
        insertList.add("triens");
        insertList.add("trines");
        anagramDictionary.put("insert", insertList);
        
        ArrayList<String> laserList = new ArrayList<String>();
        laserList.add("earls");
        laserList.add("reals");
        laserList.add("rales");
        laserList.add("lares");
        anagramDictionary.put("laser", laserList);
        
        ArrayList<String> lapseList = new ArrayList<String>();
        lapseList.add("peals");
        lapseList.add("pleas");
        lapseList.add("pales");
        lapseList.add("sepal");
        anagramDictionary.put("lapse", lapseList);
        
        ArrayList<String> angleList = new ArrayList<String>();
        angleList.add("angel");
        angleList.add("glean");
        angleList.add("genal");
        anagramDictionary.put("angle", angleList);
        
        ArrayList<String> superList = new ArrayList<String>();
        superList.add("purse");
        superList.add("sprue");
        anagramDictionary.put("super", superList);
        
        ArrayList<String> scrapeList = new ArrayList<String>();
        scrapeList.add("capers");
        scrapeList.add("crapes");
        scrapeList.add("spacer");
        scrapeList.add("pacers");
        anagramDictionary.put("scrape", scrapeList);
        
        ArrayList<String> retainsList = new ArrayList<String>();
        retainsList.add("stainer");
        retainsList.add("starnie");
        retainsList.add("resiant");
        retainsList.add("nastier");
        retainsList.add("retinas");
        anagramDictionary.put("retains", retainsList);
    }
    // method to clear the screen
    private static void clearScreen()
    {
      System.out.print('\u000C');
    }
}
