package com.methodpark.cmpe.code.dip;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

public class ServerLogFileParserTest
{
    @Test
    public void parseApacheLog_ValidFile_CorrectErrorCount()
    {
        ApacheLog apacheLog = createApacheLog();
        ServerLogFileParser parser = new ServerLogFileParser(apacheLog);

        List<String> errors = parser.getErrors();
        Assert.assertEquals(4, errors.size());
        Assert.assertThat(errors.get(3),
                JUnitMatchers.containsString("authentication failure"));
    }

    private ApacheLog createApacheLog()
    {
        ApacheLog apacheLog = null;
        try
        {
            URI logFile = ServerLogFileParserTest.class
			     .getResource("error_log").toURI();
            apacheLog = new ApacheLog(logFile);
        }
        catch (URISyntaxException e)
        {
        }
        return apacheLog;
    }
}
