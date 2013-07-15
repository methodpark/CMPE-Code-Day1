package com.methodpark.cmpe.code.srp_refactored;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileReader
{
    URI fileName;

    public FileReader(URI filename)
    {
        fileName = filename;
    }
    
    public List<String> readAllLinesOfFile()
    {
        List<String> lines = new ArrayList<String>();
        File file = new File(fileName);
        try
        {
            lines.addAll(Files.readAllLines(file.toPath(),
                    Charset.defaultCharset()));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return lines;
    }

}
