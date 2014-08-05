package com.methodpark.cmpe.code.isp;

public interface IFileTranslator
{
    public abstract String translate(String text);
    public abstract String loadFile(String filename);
}
