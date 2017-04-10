using System.Linq;
using Dip;
using FluentAssertions;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace DipTests
{
    [TestClass]
    public class IisLogFileTests
    {
        [TestMethod]
        public void ReadLogEntires_ValidFile_ReturnsCorrectEntires()
        {
            var logFile = TestUtils.ExtractResourceToFile("DipTests.Resources.HTTPERR");
            var iisLog = new IisLog(logFile);

            iisLog.ReadLogEntries().Should().HaveCount(4);
            iisLog.ReadLogEntries().Where(l => l.Type == LogType.Error).Should().HaveCount(2);
        }
    }
}