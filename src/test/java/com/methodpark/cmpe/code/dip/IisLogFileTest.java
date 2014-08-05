package com.methodpark.cmpe.code.dip;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class IisLogFileTest 
{
    @Test
    public void readLogEntires_ValidFile_ReturnsCorrectEntires()
    {
        IisLog iisLog = createIisLog();

        List<LogEntry> logEntries = iisLog.readLogEntries();
        Assert.assertEquals(4, logEntries.size());
    }
	
    private IisLog createIisLog()
    {
        IisLog iisLog = null;
        try 
        {
            URI logFile = ServerLogFileParserTest.class
                .getResource("HTTPERR").toURI();
            iisLog = new IisLog(logFile);
        } 
        catch (URISyntaxException e) 
        {
        }
        return iisLog;
     }
}
