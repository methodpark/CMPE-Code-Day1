package com.methodpark.cmpe.code.dip;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApacheLog
{
    private URI filename;

    public ApacheLog(URI filename)
    {
        this.filename = filename;
    }

    public List<LogEntry> loadLogEntries()
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
        String logEntryPattern = "^\\[(.+)\\] \\[(.+)\\] \\[(.+)\\] (.+)";
        Pattern p = Pattern.compile(logEntryPattern);
        Matcher matcher = p.matcher(line);
        
        if (matcher.matches())
        {
            message = matcher.group(4);
            if (matcher.group(2).equals("error"))
            {
                logType = LogType.Error;
            }
        }
        
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
