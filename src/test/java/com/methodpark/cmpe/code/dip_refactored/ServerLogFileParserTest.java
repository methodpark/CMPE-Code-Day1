package com.methodpark.cmpe.code.dip_refactored;

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
        ServerLogFileParser parser = createLogFileParser(ServerType.Apache);

        List<String> errors = parser.getErrors();
        Assert.assertEquals(4, errors.size());
        Assert.assertThat(errors.get(3),
                JUnitMatchers.containsString("authentication failure"));
    }

    @Test
    public void parseIISLog_ValidFile_CorrectErrorCount()
    {
        ServerLogFileParser parser = createLogFileParser(ServerType.IIS);

        List<String> errors = parser.getErrors();
        Assert.assertEquals(2, errors.size());
        Assert.assertEquals("Bad URI request", errors.get(1));
    }

    private ServerLogFileParser createLogFileParser(ServerType serverType)
    {
        URI logFile = null;
        try
        {
            if (serverType == ServerType.Apache)
            {
                logFile = ServerLogFileParserTest.class
                        .getResource("error_log").toURI();
            }
            else if (serverType == ServerType.IIS)
            {
                logFile = ServerLogFileParserTest.class.getResource("HTTPERR")
                        .toURI();
            }
        }
        catch (URISyntaxException e)
        {
        }
        return new ServerLogFileParser(logFile);
    }

}
