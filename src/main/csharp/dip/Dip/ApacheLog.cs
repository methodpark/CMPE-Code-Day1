using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text.RegularExpressions;

namespace Dip
{
    public class ApacheLog
    {
        private readonly string filename;

        public ApacheLog(string filename)
        {
            this.filename = filename;
        }

        public IEnumerable<LogEntry> LoadLogEntries()
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
            string message = null;
            var logType = LogType.Unknown;

            const string logEntryPattern = "^\\[(.+)\\] \\[(.+)\\] \\[(.+)\\] (.+)";
            var regex = new Regex(logEntryPattern);
            var match = regex.Match(line);
            if (match.Success)
            {
                message = match.Groups[4].Value;
                if (match.Groups[2].Value.Equals("error"))
                {
                    logType = LogType.Error;
                }
            }
            return new LogEntry(logType, message);
        }

        private IEnumerable<string> ReadAllLinesOfFile()
        {
            return File.ReadAllLines(filename).ToList();
        }
    }
}