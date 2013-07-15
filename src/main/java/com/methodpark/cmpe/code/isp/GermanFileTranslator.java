package com.methodpark.cmpe.code.isp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

// this class is forced to implement the loadFile method, although it really does not 'need' it.
// it should only implement something like  ITranslator.
public class GermanFileTranslator implements IFileTranslator {
    
    HashMap<String,String> dict = new HashMap<String, String>();
    
    public GermanFileTranslator()
    {
        dict.put("cat", "Katze");
        dict.put("dog", "Hund");
        dict.put("house", "Haus");
        dict.put("duck", "Ente");
    }

    public String translate(String text) {
      String ret = dict.get(text);
      if (ret != null)
          return ret;
      else
          return text;
    }

    public String loadFile(String filename) {
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(filename));

            String ret = "";
            String line = null;
            while ((line = reader.readLine()) != null) {
                ret += line;
            }
            reader.close();
            return ret;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "";
    }
}
