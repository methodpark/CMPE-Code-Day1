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

public class ServerLogFileParser
{
    private ServerType serverType;

    private URI filename;

    public ServerLogFileParser(URI filename)
    {
        this.filename = filename;

        serverType = DetermineLogType();
    }

    public List<String> getErrors()
    {
        List<String> errors = new ArrayList<String>();
        List<LogEntry> logEntries = loadLogEntries();
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

        if (serverType == ServerType.Apache)
        {
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
        }
        else if (serverType == ServerType.IIS)
        {
            String[] parts = line.split(",");
            if (parts[10].trim().equals("500"))
            {
                logType = LogType.Error;
            }
            message = parts[14].trim();
        }
        else if (serverType == ServerType.IIS)
        {

        }
        return new LogEntry(logType, message);
    }

    private ServerType DetermineLogType()
    {
        ServerType type = ServerType.Unknown;
        if (filename.toString().contains("error_log"))
        {
            type = ServerType.Apache;
        }
        else if (filename.toString().contains("HTTPERR"))
        {
            type = ServerType.IIS;
        }
        return type;
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
