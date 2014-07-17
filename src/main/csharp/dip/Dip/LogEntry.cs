namespace Dip
{
    public class LogEntry
    {
        public string Message { get; private set; }

        public LogType Type { get; private set; }

        public LogEntry(LogType logType, string message)
        {
            Type = logType;
            Message = message;
        }
    }
}