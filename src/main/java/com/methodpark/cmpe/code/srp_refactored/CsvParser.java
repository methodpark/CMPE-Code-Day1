package com.methodpark.cmpe.code.srp_refactored;

import java.util.ArrayList;
import java.util.List;

public class CsvParser
{

    public static String[] parseAsHeader(String line)
    {
        return line.split(",");
    }

    public static List<String[]> parseRecords(List<String> lines)
    {
        List<String[]> records = new ArrayList<String[]>();
        
        if ( lines.size() < 2 )
        {
            return null;
        }
        
        lines.remove(0);
        for (String line : lines )
        {
            String[] record = parseRecord(line);
            records.add(record);
        }
        return records;
    }
    
    private static String[] parseRecord(String line)
    {
        return line.split(",");
    }
}
