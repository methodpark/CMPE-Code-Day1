package com.methodpark.cmpe.code.isp_refactored;

import java.util.HashMap;

public class EnglishToGermanTranslator implements ITranslator 
{    
    HashMap<String,String> dictionary = new HashMap<String, String>();
    
    public EnglishToGermanTranslator()
    {
        fillDictionary();
    }

    @Override
    public String translate(String foreignWord) {
      String translatedWord = dictionary.get(foreignWord);
      if (translatedWord == null) {
          translatedWord = "";
      }
      return translatedWord;
    }
    
    @Override
    public void ShowSupportedWords() {
        String supportedWords = "";
        for ( String word : dictionary.keySet() ) {
            supportedWords += word + " ";
        }
        // TODO: replace last , with .
        System.out.println("Supported words so far: \n" + supportedWords);
    }

    private void fillDictionary()
    {
        dictionary.put("cat", "Katze");
        dictionary.put("dog", "Hund");
        dictionary.put("house", "Haus");
        dictionary.put("duck", "Ente");
    }
}
