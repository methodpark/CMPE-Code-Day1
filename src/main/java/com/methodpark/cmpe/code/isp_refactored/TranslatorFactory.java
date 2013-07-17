package com.methodpark.cmpe.code.isp_refactored;

public class TranslatorFactory
{
    public static ITranslator createTranslator(Language lang) {
        switch (lang) {
        case de:  return new EnglishToGermanTranslator();
        default:  return null;
        }
      }
}
