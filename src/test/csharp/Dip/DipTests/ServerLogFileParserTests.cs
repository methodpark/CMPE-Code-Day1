using System.IO;
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
            var apacheLog = CreateApacheLog();
            var parser = new ServerLogFileParser(apacheLog);

            var errors = parser.GetErrors();
            errors.Count.Should().Be(4);
            errors[3].Should().Contain("authentication failure");
        }

        [TearDown]
        public void TearDown()
        {
            File.Delete(logFile);
        }

        private ApacheLog CreateApacheLog()
        {
            logFile = TestUtils.ExtractResourceToFile("DipTests.Resources.error_log");
            return new ApacheLog(logFile);
        }
    }
}