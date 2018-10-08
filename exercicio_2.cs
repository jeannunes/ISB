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

            float w, h, imc;

            Console.WriteLine("Digite seu peso:");
            w = Convert.ToSingle(Console.ReadLine());

            Console.WriteLine("Digite sua altura:");
            h = Convert.ToSingle(Console.ReadLine());

            imc = w / (h * h);

            Console.WriteLine("Seu IMC é:");
            Console.WriteLine(imc.ToString());

            if (imc >= 40)
            {
                Console.WriteLine("Obesidade III (morbida)");
            }
            else if (imc >= 35 && imc < 40)
            {
                Console.WriteLine("Obseidade II (Severa)");
            }
            else if (imc >= 30 && imc < 35)
            {
                Console.WriteLine("Obesidade I");
            }
            else if (imc >= 25 && imc < 30)
            {
                Console.WriteLine("Acima do peso");
            }
            else if (imc >= 18.5 && imc < 28)
            {
                Console.WriteLine("Peso normal");
            }
            else if (imc >= 17 && imc < 19)
            {
                Console.WriteLine("Abaixo do peso");
            }
            else {
                Console.WriteLine("Muito abaixo do peso");
            }

            Console.ReadLine();

        }
    }
}
