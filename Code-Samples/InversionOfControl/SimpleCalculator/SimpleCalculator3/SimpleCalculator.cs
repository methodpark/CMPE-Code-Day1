using System;
using System.Collections.Generic;
using System.ComponentModel.Composition;
using System.Linq;
using Contracts;

namespace SimpleCalculator3
{
    [Export(typeof (ICalculator))]
    internal class SimpleCalculator : ICalculator
    {
        [ImportMany] private IEnumerable<Lazy<IOperation, IOperationData>> operations;

        public String Calculate(String input)
        {
            int left;
            int right;
            var digitIndex = FindFirstNonDigit(input); //finds the operator
            if (digitIndex < 0) return "Could not parse command.";

            try
            {
                //separate out the operands
                left = int.Parse(input.Substring(0, digitIndex));
                right = int.Parse(input.Substring(digitIndex + 1));
            }
            catch
            {
                return "Could not parse command.";
            }

            var operation = input[digitIndex];

            foreach (var i in operations.Where(i => i.Metadata.Symbol.Equals(operation)))
            {
                return i.Value.Operate(left, right).ToString();
            }
            return "Operation Not Found!";
        }

        private int FindFirstNonDigit(String s)
        {
            for (int i = 0; i < s.Length; i++)
            {
                if (!(Char.IsDigit(s[i]))) return i;
            }
            return -1;
        }
    }
}