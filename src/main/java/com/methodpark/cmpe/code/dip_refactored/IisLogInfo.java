package com.methodpark.cmpe.code.dip_refactored;

import java.net.URI;

public class IisLogInfo implements IServerLogInfo
{
    @Override
    public ServerType getServerType(URI filename)
    {
        return ServerType.IIS;
    }

    @Override
    public LogEntry createLogEntry(String line)
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

}
