package com.methodpark.cmpe.code.dip_refactored;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

// this class now only depends on the ServerLogInfo (the abstraction)
public class ServerLogFileParser
{
    private IServerLogInfo serverLogInfo;
    private URI filename;

    public ServerLogFileParser(URI filename)
    {
        this.filename = filename;
        this.serverLogInfo = ServerLogInfoFactory.createServerLogInfo(filename);
    }

    public List<String> getErrors()
    {
        List<LogEntry> logEntries = loadLogEntries();        
        List<String> errors = extractErrors(logEntries);
        return errors;
    }

    private List<String> extractErrors(List<LogEntry> logEntries)
    {
        List<String> errors = new ArrayList<String>();
        for (LogEntry logEntry : logEntries)
        {
            if (logEntry.getLogType() == LogType.Error)
            {
                errors.add(logEntry.getMessage());
            }
        }
        return errors;
    }

    private List<LogEntry> loadLogEntries()
    {
        List<LogEntry> logEntries = new ArrayList<LogEntry>();
        LogEntry logEntry;
        for (String line : readAllLinesOfFile())
        {
            logEntry = serverLogInfo.createLogEntry(line);
            logEntries.add(logEntry);
        }
        return logEntries;
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
