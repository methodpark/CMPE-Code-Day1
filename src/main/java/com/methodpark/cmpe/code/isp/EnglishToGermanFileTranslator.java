package com.methodpark.cmpe.code.isp;

import java.io.File;

public class EnglishToGermanFileTranslator
{

    public static void main(String[] args)
    {
    	String filename;
        if(args.length == 1)
        {
        	filename = args[0];
        }
        else
        {
        	filename = new File("./testData/englishText.txt").getAbsolutePath();
        }
        
        IFileTranslator deTranslator = TranslatorFactory.createTranslator(Language.de);
        
        String content = deTranslator.loadFile(filename);
        String[] words = content.split("\\s+");
        
        for (String word : words) 
        {
        	String translatedWord = deTranslator.translate(word);
			System.out.print(translatedWord + " ");
		}
    }
}
