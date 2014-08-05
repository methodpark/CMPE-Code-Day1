package com.methodpark.cmpe.code.srp;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

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
        File file = new File(filename);
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

    private void parseHeader(String line)
    {
        header = parseRecord(line);
    }

    private String[] parseRecord(String line)
    {
        return line.split(",");
    }
}
