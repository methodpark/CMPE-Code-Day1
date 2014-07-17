namespace Isp
{
    public class TranslatorFactory
    {
        public static IFileTranslator CreateTranslator(Language language)
        {
            switch (language)
            {
                case Language.De:
                    return new GermanFileTranslator();
                default:
                    return null;
            }
        }
    }
}