using System;
using System.ComponentModel.Composition;
using System.ComponentModel.Composition.Hosting;
using Contracts;

namespace SimpleCalculator3
{
    [Export(typeof (IOperation))]
    [ExportMetadata("Symbol", '+')]
    internal class Add : IOperation
    {
        public int Operate(int left, int right)
        {
            return left + right;
        }
    }

    [Export(typeof (IOperation))]
    [ExportMetadata("Symbol", '-')]
    internal class Subtract : IOperation
    {
        public int Operate(int left, int right)
        {
            return left - right;
        }
    }


    internal class Program
    {
        private readonly CompositionContainer _container;

        [Import(typeof (ICalculator))] public ICalculator calculator;

        private Program()
        {
            //An aggregate catalog that combines multiple catalogs
            var catalog = new AggregateCatalog();
            //Adds all the parts found in the same assembly as the Program class
            catalog.Catalogs.Add(new AssemblyCatalog(typeof (Program).Assembly));
            catalog.Catalogs.Add(new DirectoryCatalog(@"..\..\Extensions"));


            //Create the CompositionContainer with the parts in the catalog
            _container = new CompositionContainer(catalog);

            //Fill the imports of this object
            try
            {
                _container.ComposeParts(this);
            }
            catch (CompositionException compositionException)
            {
                Console.WriteLine(compositionException.ToString());
            }
        }


        private static void Main(string[] args)
        {
            var p = new Program(); //Composition is performed in the constructor
            String s;
            Console.WriteLine("Enter Command:");
            while (true)
            {
                s = Console.ReadLine();
                Console.WriteLine(p.calculator.Calculate(s));
            }
        }
    }
}