using System.IO;
using FluentAssertions;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Srp;

namespace SrpTests
{
    [TestClass]
    public class CsvReaderTest
    {
        [TestMethod]
        public void GetHeader_ValidFile_CorrectHeaderCount()
        {
            var reader = CreateCsvReader();
            var header = reader.Header;
            header.Should().NotBeNull();
            header.Length.Should().Be(5);
            header[0].Should().Be("Record1");
        }

        [TestMethod]
        public void GetRecords_ValidFile_CorrectRecordCount()
        {
            var reader = CreateCsvReader();

            var records = reader.Records;

            records.Should().NotBeNull();
            records.Count.Should().Be(3);

            var firstRecord = records[0];
            firstRecord.Length.Should().Be(5);
            firstRecord[0].Should().Be("1");
        }

        private CsvReader CreateCsvReader()
        {
            var reader = new CsvReader(GetTestFile());
            return reader;
        }

        private string GetTestFile()
        {
            var stream = GetType().Assembly.GetManifestResourceStream("SrpTests.Resources.TestFile.csv");
            var csvFile = Path.GetTempFileName();
            File.WriteAllText(csvFile, new StreamReader(stream).ReadToEnd());
            return csvFile;
        }
    }
}