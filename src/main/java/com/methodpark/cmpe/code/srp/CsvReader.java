package com.methodpark.cmpe.code.srp;

import java.io.*;
import java.net.URI;
import java.util.*;

public class CsvReader
{
    private URI filename;

    private String[] header;

    private List<String[]> records = new ArrayList<String[]>();

    public CsvReader(URI filename) throws Exception
    {
        this.filename = filename;

        parseFile();
    }

    public String[] getHeader()
    {
        
        return header;
    }

    public List<String[]> getRecords()
    {
        return records;
    }

    private void parseFile() throws Exception
    {
        try
        {
            BufferedReader bufferedReader = createBufferedReader();

            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                if (header == null)
                {
                    parseHeader(line);
                }
                else
                {
                    String[] record = parseRecord(line);
                    records.add(record);
                }
            }
            bufferedReader.close();
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    private BufferedReader createBufferedReader() throws FileNotFoundException
    {
        File file = new File(filename);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }

    private void parseHeader(String line)
    {
        header = parseRecord(line);
    }

    private String[] parseRecord(String line)
    {
        return line.split(",");
    }
}
