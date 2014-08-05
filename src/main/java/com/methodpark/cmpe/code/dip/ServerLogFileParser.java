package com.methodpark.cmpe.code.dip;

import java.util.ArrayList;
import java.util.List;

public class ServerLogFileParser
{
    private ApacheLog apacheLog;

    public ServerLogFileParser(ApacheLog apacheLog)
    {
        this.apacheLog = apacheLog;
    }

    public List<String> getErrors()
    {
        List<String> errors = new ArrayList<String>();
        List<LogEntry> logEntries = apacheLog.loadLogEntries();
        for (LogEntry logEntry : logEntries)
        {
            if (logEntry.getLogType() == LogType.Error)
            {
                errors.add(logEntry.getMessage());
            }
        }
        return errors;
    }
}
