
package textprediction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TextPrediction 
{

   
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a word");
        String input = sc.next();
        
        String[] phraseToList = generatePredictedText(input , false);
        
        for(int i=0; i <phraseToList.length;i++)
        {
            System.out.println(phraseToList[i]);
        }
    }
    
    public static String[] generatePredictedText(String userinput, boolean caseSensitive)
    {
        String [] ListOfAllPhrases = getWords("sample.txt");
        
        return generatePhraseList(userinput,ListOfAllPhrases,caseSensitive);
    }
    
    public static String[] generatePhraseList(String userinput, String[] listOfPhrase,boolean caseSensitive)
    {
        ArrayList<String> phrases = new ArrayList();
        
        for(int i=0;i<listOfPhrase.length;i++)
        {
            if(caseSensitive)
            {
                if(listOfPhrase[i].startsWith(userinput))
                {
                    phrases.add(listOfPhrase[i]);
                }
            }
            else
            {
                if(listOfPhrase[i].toUpperCase().startsWith(userinput.toUpperCase()))
                {
                    phrases.add(listOfPhrase[i]);
                }
            }
        }
        
        return phrases.toArray(new String[0]);
    }
    
    public static String[] getWords(String filepath)
    {
        ArrayList<String> phrases = new ArrayList();
        
        try
        {
            FileReader fr = new FileReader(filepath);
            BufferedReader br  = new BufferedReader(fr);
            
            String currentLine;
            
            while((currentLine = br.readLine())!=null)
            {
                phrases.add(currentLine);
            }
            br.close();
            fr.close();
            
            Collections.sort(phrases);
        }
        catch(Exception e)
        {
            phrases.add(e.toString());
        }
        return phrases.toArray(new String[0]);
        
        
    }
    
}
