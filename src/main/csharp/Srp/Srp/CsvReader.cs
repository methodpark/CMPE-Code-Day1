using System.Collections.Generic;
using System.IO;

namespace Srp
{
    public class CsvReader
    {
        private readonly string filename;

        public string[] Header { get; private set; }

        public List<string[]> Records
        {
            get { return records; }
        }

        private readonly List<string[]> records = new List<string[]>();

        public CsvReader(string filename)
        {
            this.filename = filename;

            ParseFile();
        }

        private void ParseFile()
        {
            foreach (var line in ReadAllLinesOfFile())
            {
                if (Header == null)
                {
                    ParseHeader(line);
                }
                else
                {
                    var record = ParseRecord(line);
                    records.Add(record);
                }
            }
        }

        private IEnumerable<string> ReadAllLinesOfFile()
        {
            return File.ReadAllLines(filename);
        }

        private void ParseHeader(string line)
        {
            Header = ParseRecord(line);
        }

        private static string[] ParseRecord(string line)
        {
            return line.Split(',');
        }
    }
}