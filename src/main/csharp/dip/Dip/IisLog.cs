using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace Dip
{
    public class IisLog
    {
        private readonly string filename;

        public IisLog(string filename)
        {
            this.filename = filename;
        }

        public IEnumerable<LogEntry> ReadLogEntries()
        {
            var logEntries = new List<LogEntry>();
            foreach (var line in ReadAllLinesOfFile())
            {
                logEntries.Add(CreateLogEntry(line));
            }
            return logEntries;
        }

        private static LogEntry CreateLogEntry(string line)
        {
            var logType = LogType.Unknown;

            var parts = line.Split(',');
            if (parts[10].Trim().Equals("500"))
            {
                logType = LogType.Error;
            }
            var message = parts[14].Trim();

            return new LogEntry(logType, message);
        }

        private IEnumerable<string> ReadAllLinesOfFile()
        {
            return File.ReadAllLines(filename).ToList();
        }
    }
}