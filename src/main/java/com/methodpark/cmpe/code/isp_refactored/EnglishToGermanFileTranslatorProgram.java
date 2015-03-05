package com.methodpark.cmpe.code.isp_refactored;

import java.io.File;

public class EnglishToGermanFileTranslatorProgram
{ 
    static ITranslator englishToGermanTranslator = TranslatorFactory.createTranslator(Language.de);  
    static ITextFromFileLoader textFromFileLoader = new TextFromFileLoader();

    public static void main(String[] args)
    {
        String file = determineFileToTranslate(args);
        String[] words = parseAllWordsInFile(file);
        translateAndPrintWords(words);
    }

	private static String determineFileToTranslate(String[] args) 
    {
        if(args.length == 1)
        {
        	return args[0];
        }
    	return new File("./testData/englishText.txt").getAbsolutePath();
	}

    private static String[] parseAllWordsInFile(String filename) 
    {
    	 String content = textFromFileLoader.loadFile(filename);
         return content.split("\\s+");
	}

	private static void translateAndPrintWords(String[] words) 
	{
		for (String word : words) 
        {
			translateAndPrintWord(word);
		}
	}
    
    private static void translateAndPrintWord(String word)
    {
        String translatedWord = englishToGermanTranslator.translate(word);
        
        if ( translatedWord != "" )
        {
            System.out.print(translatedWord);            
        }
        else 
        {
        	System.out.print(word); 
        }
        System.out.print(" "); 
    }
}
