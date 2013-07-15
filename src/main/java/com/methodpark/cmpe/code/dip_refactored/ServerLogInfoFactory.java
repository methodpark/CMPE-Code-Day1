package com.methodpark.cmpe.code.dip_refactored;

import java.net.URI;

public class ServerLogInfoFactory
{    
    public static IServerLogInfo createServerLogInfo( URI filename )
    {
        IServerLogInfo serverLogFileInfo;
        if (filename.toString().contains("error_log"))
        {
            serverLogFileInfo = new ApacheLogInfo();
        }
        else if (filename.toString().contains("HTTPERR"))
        {
            serverLogFileInfo = new IisLogInfo();
        }
        else
        {
            serverLogFileInfo = new UnknownServerLogInfo();
        }
        return serverLogFileInfo; 
    }
}
