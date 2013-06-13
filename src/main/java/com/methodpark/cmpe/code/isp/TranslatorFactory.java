package com.methodpark.cmpe.code.isp;

public class TranslatorFactory
{
    public static IFileTranslator createTranslator(Language lang) {
        switch (lang) {
        case de:  return new GermanFileTranslator();
        default:  return null;
        }
      }
}
