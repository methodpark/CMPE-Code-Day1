package com.methodpark.cmpe.code.dip;

// this class does not depend on the server type
// thus, we have to handle that externally
public class LogEntry
{
    private LogType logType;
    private String message;

    public LogEntry(LogType logType, String message)
    {
        this.logType=logType;
        this.message=message;
    }

    public LogType getLogType()
    {
        return logType;
    }

    public String getMessage()
    {
        return message;
    }
}
