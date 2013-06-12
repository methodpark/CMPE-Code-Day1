package com.methodpark.cmpe.code.srp;

import java.io.*;
import java.net.URI;
import java.util.*;

public class CsvReader
{
    private URI filename;

    private String[] header;

    private List<String[]> records = new ArrayList<String[]>();

    public CsvReader(URI filename)
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

    private void parseFile()
    {
        for (String line : readAllLinesOfFile())
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
    }

    private List<String> readAllLinesOfFile()
    {
        List<String> lines = new ArrayList<String>();
        BufferedReader bufferedReader = null;
        File file = new File(filename);
        try
        {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                lines.add(line);
            }
        }
        catch (Exception e)
        {
        }
        finally
        {
            try
            {
                bufferedReader.close();
            }
            catch (IOException e)
            {
            }
        }
        return lines;
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
