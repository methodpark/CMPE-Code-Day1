using System.IO;
using Dip;
using FluentAssertions;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace DipTests
{
    [TestClass]
    public class ServerLogFileParserTest
    {
        private string logFile;

        [TestMethod]
        public void ParseApacheLog_ValidFile_CorrectErrorCount()
        {
            var apacheLog = CreateApacheLog();
            var parser = new ServerLogFileParser(apacheLog);

            var errors = parser.GetErrors();
            errors.Count.Should().Be(4);
            errors[3].Should().Contain("authentication failure");
        }

        [TestCleanup]
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