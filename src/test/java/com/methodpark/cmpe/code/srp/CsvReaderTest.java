package com.methodpark.cmpe.code.srp;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class CsvReaderTest
{

    @Test
    public void getHeader_ValidFile_CorrectHeaderCount()
    {
        CsvReader reader = createCsvReader();

        String[] header = reader.getHeader();
        Assert.assertNotNull(header);
        Assert.assertEquals(5, header.length);
        Assert.assertEquals("Record1", header[0]);
    }

    @Test
    public void getRecords_ValidFile_CorrectRecordCount()
    {
        CsvReader reader = createCsvReader();

        List<String[]> records = reader.getRecords();

        Assert.assertNotNull(records);
        Assert.assertEquals(3, records.size());

        String[] firstRecord = records.get(0);

        Assert.assertEquals(5, firstRecord.length);
        Assert.assertEquals("1", firstRecord[0]);
    }

    private CsvReader createCsvReader()
    {
        CsvReader reader = new CsvReader(getTestFile());
        return reader;
    }

    private URI getTestFile()
    {
        try
        {
            return CsvReaderTest.class.getResource("TestFile.csv").toURI();
        }
        catch (URISyntaxException e)
        {
            return null;
        }
    }

}
