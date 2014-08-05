using System.Collections.Generic;

namespace Dip
{
    public class ServerLogFileParser
    {
        private readonly ApacheLog apacheLog;

        public ServerLogFileParser(ApacheLog apacheLog)
        {
            this.apacheLog = apacheLog;
        }

        public List<string> GetErrors()
        {
            var errors = new List<string>();
            foreach (var logEntry in apacheLog.LoadLogEntries())
            {
                if (logEntry.Type == LogType.Error)
                {
                    errors.Add(logEntry.Message);
                }
            }
            return errors;
        }
    }
}