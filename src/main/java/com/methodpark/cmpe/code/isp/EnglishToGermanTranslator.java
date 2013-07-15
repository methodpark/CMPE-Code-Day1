package com.methodpark.cmpe.code.isp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnglishToGermanTranslator
{

    public static void main(String[] args)
    {
        IFileTranslator deTranslator = TranslatorFactory.createTranslator(Language.de);

        // all of the following should be at least moved to e.g. translator.promptForInput()
        //  or at least into a method in this class
        System.out.println("Translating english to german.");
        // btw this is very bad! we should ask the translator which words it can translate,
        //   not statically print that!
        System.out.println("Supported words so far: \n" +
        		"dog, cat, house, duck.");
        System.out.println("Please enter text to translate - line by line:");
        
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String line = in.readLine();
                if (line == null || line.isEmpty()) 
                    break;
                System.out.println("Translation: \n" + deTranslator.translate(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
