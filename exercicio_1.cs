using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Atividades
{
    class exercicios
    {
        static void Main(string[] args)
        {

            
            // Exercício 1
            // Intervalo entre dois numeros

            int x, y, i;

            Console.WriteLine("Digite o primeiro número:");
            x = Convert.ToInt32(Console.ReadLine());

            do
            {

                Console.WriteLine("Digite o segundo número:");
                y = Convert.ToInt32(Console.ReadLine());
                if (y < x)
                {
                    Console.WriteLine("O número deve ser menor do que " + x.ToString());
                }

            } while (y < x);

            Console.WriteLine("Entre os números " + x.ToString() + " e " + y.ToString() + " existem os números:");
            for (i = x + 1; i < y; i++)
            {
                Console.WriteLine(i.ToString());
            }

            Console.ReadLine();

        }
    }
}
