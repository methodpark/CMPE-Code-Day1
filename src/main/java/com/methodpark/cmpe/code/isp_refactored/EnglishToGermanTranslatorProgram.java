package com.methodpark.cmpe.code.isp_refactored;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// i know the trick was 'only' the segregate the interfaces, but i couldn't help but clean up the code a little ;-)
public class EnglishToGermanTranslatorProgram
{ 
    static ITranslator englishToGermanTranslator = TranslatorFactory.createTranslator(Language.de);  

    public static void main(String[] args)
    {
        System.out.println("Translating english to german.");
        englishToGermanTranslator.ShowSupportedWords();
        
        promptUserForInput();        
        translateWordsFromInputStream();
    }

    private static void promptUserForInput()
    {
        System.out.println("Please enter text to translate - line by line:");
    }

    private static void translateWordsFromInputStream()
    {
        try {
            BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String wordToTranslate = inputStreamReader.readLine();
                
                if ( isEmpty(wordToTranslate) ) {
                    System.out.println("Exiting...");
                    break;                    
                }
                
                translateAndPrintWord( wordToTranslate);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isEmpty(String word)
    {
        return word == null || word.isEmpty();
    }

    private static void translateAndPrintWord(String word)
    {
        String translatedWord = englishToGermanTranslator.translate(word);
        
        if ( translatedWord != "" ) {
            System.out.println("Translation: \n" + translatedWord );            
        }
        else {
            handleNoTranslationFound();
        }
    }

    private static void handleNoTranslationFound()
    {
        System.out.println("No translation available.");
        englishToGermanTranslator.ShowSupportedWords();
        promptUserForInput();
    }
}
