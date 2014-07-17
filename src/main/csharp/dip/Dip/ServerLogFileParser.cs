using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text.RegularExpressions;

namespace Dip
{
    public class ServerLogFileParser
    {
        private readonly ServerType serverType;

        private readonly string filename;

        public ServerLogFileParser(string filename)
        {
            this.filename = filename;

            serverType = DetermineLogType();
        }

        public List<string> GetErrors()
        {
            var errors = new List<string>();
            var logEntries = LoadLogEntries();
            foreach (var logEntry in logEntries)
            {
                if (logEntry.Type == LogType.Error)
                {
                    errors.Add(logEntry.Message);
                }
            }
            return errors;
        }

        private IEnumerable<LogEntry> LoadLogEntries()
        {
            var logEntries = new List<LogEntry>();
            foreach (var line in ReadAllLinesOfFile())
            {
                logEntries.Add(CreateLogEntry(line));
            }
            return logEntries;
        }

        private LogEntry CreateLogEntry(string line)
        {
            string message = null;
            var logType = LogType.Unknown;

            if (serverType == ServerType.Apache)
            {
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
            }
            else if (serverType == ServerType.IIS)
            {
                var parts = line.Split(',');
                if (parts[10].Trim().Equals("500"))
                {
                    logType = LogType.Error;
                }
                message = parts[14].Trim();
            }
            else if (serverType == ServerType.IIS)
            {
            }
            return new LogEntry(logType, message);
        }

        private ServerType DetermineLogType()
        {
            var type = ServerType.Unknown;
            if (filename.Contains("error_log"))
            {
                type = ServerType.Apache;
            }
            else if (filename.Contains("HTTPERR"))
            {
                type = ServerType.IIS;
            }
            return type;
        }

        private IEnumerable<string> ReadAllLinesOfFile()
        {
            return File.ReadAllLines(filename).ToList();
        }
    }
}