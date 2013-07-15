package com.methodpark.cmpe.code.dip_refactored;

import java.net.URI;

public interface IServerLogInfo
{

    public ServerType getServerType(URI filename);

    public LogEntry createLogEntry(String line);

}