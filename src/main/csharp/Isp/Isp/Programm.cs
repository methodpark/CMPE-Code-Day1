using System;

namespace Isp
{
    public class Programm
    {
        public static void Main(String[] args)
        {
            var deTranslator = TranslatorFactory.CreateTranslator(Language.De);

            Console.WriteLine("Translating english to german.");
            Console.WriteLine("Supported words so far: \n" +
                              "dog, cat, house, duck.");
            Console.WriteLine("Please enter text to translate - line by line:");

            while (true)
            {
                var line = Console.ReadLine();
                if (string.IsNullOrEmpty(line))
                    break;
                Console.WriteLine("Translation: \n" + deTranslator.Translate(line));
            }
        }
    }
}