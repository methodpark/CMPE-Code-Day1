package com.methodpark.cmpe.code.dip;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class IisLog
{
    private URI filename;

    public IisLog(URI filename)
    {
        this.filename = filename;
    }

    public List<LogEntry> readLogEntries()
    {
        List<LogEntry> logEntries = new ArrayList<LogEntry>();
        for (String line : readAllLinesOfFile())
        {
            logEntries.add(createLogEntry(line));
        }
        return logEntries;
    }

    private LogEntry createLogEntry(String line)
    {
    	String message = null;
        LogType logType = LogType.Unknown;
        String[] parts = line.split(",");
        
        if (parts[10].trim().equals("500"))
        {
            logType = LogType.Error;
        }
        message = parts[14].trim();
        
        return new LogEntry(logType, message);
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
}
