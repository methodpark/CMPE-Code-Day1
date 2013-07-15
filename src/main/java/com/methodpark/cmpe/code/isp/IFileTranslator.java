package com.methodpark.cmpe.code.isp;

// we need two separate interfaces: ITranslator and ITextFromFileReader
// if we really need a class that implements both interfaces, we can do so, but this is not the case in main. 
public interface IFileTranslator
{
    public abstract String translate(String text);
    public abstract String loadFile(String filename);
}
