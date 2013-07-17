package com.methodpark.cmpe.code.isp_refactored;

import java.io.BufferedReader;
import java.io.FileReader;

// not used.
public class TextFromFileLoader implements ITextFromFileLoader
{

    @Override
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
