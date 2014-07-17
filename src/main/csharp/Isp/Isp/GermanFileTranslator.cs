using System;
using System.Collections.Generic;
using System.IO;

namespace Isp
{
    public class GermanFileTranslator : IFileTranslator
    {
        private readonly Dictionary<String, String> dict = new Dictionary<String, String>();

        public GermanFileTranslator()
        {
            dict.Add("cat", "Katze");
            dict.Add("dog", "Hund");
            dict.Add("house", "Haus");
            dict.Add("duck", "Ente");
        }

        public String Translate(String text)
        {
            return dict.ContainsKey(text) ? dict[text] : text;
        }

        public String LoadFile(String filename)
        {
            return File.ReadAllText(filename);
        }
    }
}