using System;

namespace Isp
{
    public interface IFileTranslator
    {
        String Translate(String text);
        String LoadFile(String filename);
    }
}