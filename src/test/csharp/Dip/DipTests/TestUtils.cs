using System.IO;

namespace DipTests
{
    public class TestUtils
    {
        public static string ExtractResourceToFile(string resource)
        {
            var assembly = typeof (TestUtils).Assembly;
            var stream = assembly.GetManifestResourceStream(resource);
            var logFile = Path.Combine(Path.GetTempPath(), resource);
            File.WriteAllText(logFile, new StreamReader(stream).ReadToEnd());
            return logFile;
        }
    }
}