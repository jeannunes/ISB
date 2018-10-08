using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ListaII
{
    class Program
    {
        static void Main(string[] args)
        {
            Ex10();
        }

        static void Ex8() {

            int i, j;
            for (i = 1, j = 1; i < 101 && j < 12; i++, j++) {
                int a = i, r;
                if (a > 10) {
                    a = i / 10;
                }
                if (j > 10) {
                    j = 1;
                }
                r = a * j;
                Console.WriteLine(a.ToString() + 'x' + j.ToString() + '=' + r.ToString());
            }
            Console.ReadLine();

        }

        static void Ex9() {

            int n = Convert.ToInt32(Console.ReadLine()), o = 1;

            while (o < n) {
                int t = o * (o + 1) * (o + 2);
                if (t == n)
                {
                    Console.WriteLine( o.ToString() + " * " + (o + 1).ToString() + " * " + (o + 2).ToString());
                    break;
                }
                o++;
            }
            if (o == n) {
                Console.WriteLine(n.ToString() + " não é triangular");
            }
            Console.ReadLine();


        }

        static void Ex10() {

            int a, b;

            Console.WriteLine("A:");
            a = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("B:");
            b = Convert.ToInt32(Console.ReadLine());

            if (a.ToString().EndsWith(b.ToString()))
            {
                Console.WriteLine("Encaixa");
            }
            else {
                Console.WriteLine("NEncaixa");
            }
            Console.ReadLine();

        }

        static void Ex11()
        {

            double conta, valorPago, troco;

            conta = 57.35;
            valorPago = 100;
            troco = valorPago - conta;

            double[] unidades = {100, 50, 20, 10, 5, 2, 1, 0.5, 0.25, 0.10, 0.5, 0.1};
            foreach (double unidade in unidades) {
                double qtd = troco / unidade;
                int qtdInt = (int)qtd;
                if (qtdInt > 0) {
                    Console.WriteLine("");
                }
            }

        }
    }
}
