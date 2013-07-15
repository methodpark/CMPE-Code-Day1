package com.methodpark.cmpe.code.dip_refactored;

import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApacheLogInfo implements IServerLogInfo
{
    private String logEntryPattern = "^\\[(.+)\\] \\[(.+)\\] \\[(.+)\\] (.+)";

    @Override
    public ServerType getServerType(URI filename)
    {
        return ServerType.Apache;
    }

    @Override
    public LogEntry createLogEntry(String line)
    {
        String message = null;
        LogType logType = LogType.Unknown;        
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

}
