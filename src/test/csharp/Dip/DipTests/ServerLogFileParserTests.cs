using System.IO;
using System.Linq;
using Dip;
using FluentAssertions;
using NUnit.Framework;

namespace DipTests
{
    public class ServerLogFileParserTest
    {
        private string logFile;

        [Test]
        public void ParseApacheLog_ValidFile_CorrectErrorCount()
        {
            var parser = CreateLogFileParser(ServerType.Apache);

            var errors = parser.GetErrors();
            errors.Count.Should().Be(4);
            errors[3].Should().Contain("authentication failure");
        }

        [Test]
        public void ParseIISLog_ValidFile_CorrectErrorCount()
        {
            var parser = CreateLogFileParser(ServerType.IIS);

            var errors = parser.GetErrors();
            errors.Count.Should().Be(2);
            errors.First().Should().Be("Bad URI request");
        }

        private ServerLogFileParser CreateLogFileParser(ServerType serverType)
        {
            var resource = string.Empty;
            var assembly = GetType().Assembly;

            if (serverType == ServerType.Apache)
            {
                resource = "DipTests.Resources.error_log";
            }
            else if (serverType == ServerType.IIS)
            {
                resource = "DipTests.Resources.HTTPERR";
            }

            var stream = assembly.GetManifestResourceStream(resource);
            logFile = Path.Combine(Path.GetTempPath(), resource);
            File.WriteAllText(logFile, new StreamReader(stream).ReadToEnd());
            return new ServerLogFileParser(logFile);
        }
    }
}