package com.methodpark.cmpe.code.srp_refactored;

import java.net.URI;
import java.util.List;

// this is still not optimal, as the class does more than just *read* csv files.
// we expect usage like 
// csvFileReader =  new CsvFileReader( someUri )
// csvFileReader.getHeader();
// but getting the header of file*Reader* intuitively does not make sense.
// on the other hand, the records have to go somewhere!
// so the reader class has to be a container for the read records
//   and to do so, it must parse them... 
// all we can do is move functionality out of the class
//   (which would be useful if we want to handle other type of file formats, but YAGNI...)

public class CsvFileReader
{
    private FileReader fileReader;
    private String[] header;
    private List<String[]> records;

    public CsvFileReader(URI filename)
    {
        this.fileReader = new FileReader( filename );
        parseFile();
    }

    public String[] getHeader()
    {
        return header;
    }

    public List<String[]> getRecords()
    {
        return records;
    }

    private void parseFile()
    {
        List<String> lines = fileReader.readAllLinesOfFile();
        extractHeader( lines );
        extractRecords( lines );
    }    

    private void extractRecords(List<String> lines)
    {
        records = CsvParser.parseRecords( lines );
    }

    private void extractHeader(List<String> lines)
    {
        // we do have a first line - FileReader takes care of that
        String firstLine = lines.get(0);
        header = CsvParser.parseAsHeader( firstLine );
        
    }
}
