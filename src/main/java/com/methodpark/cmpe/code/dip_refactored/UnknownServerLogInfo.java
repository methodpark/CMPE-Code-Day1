package com.methodpark.cmpe.code.dip_refactored;

import java.net.URI;

public class UnknownServerLogInfo implements IServerLogInfo
{
    @Override
    public ServerType getServerType(URI filename)
    {
        // TODO Auto-generated method stub
        return ServerType.Unknown;
    }

    @Override
    public LogEntry createLogEntry(String line)
    {
        String message = "<no message>";
        LogType logType = LogType.Unknown;    
        return new LogEntry(logType, message);
    }

}
