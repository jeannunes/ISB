from sympy import *
from IPython.display import display

x = Symbol('x')

def f(x):
    return x**3

def derQuad(n):
    return der(x**n)

def der(n):
    return diff(n)

def derN(n = None):
    if n == None:
        return "f'(n) = n*n**(n-1)"
    else:
        return "f'(x) = {}*x**{}".format(n, n-1)

ordem = [ der(sin(y)) for y in range(0,10,1) ]

"""
    a)  y = x²
        y = x³
        y^n = ?

        R = n*x**(n-1)

    b) y = sin(x), y' = cos(x)

    c) Escreva um programa em Python que retorne a derivada de ordem n da
        função sin(x)
"""

# f(x) = (x**3/3) + (x**2/2) - 2*x

def f2(n):
    return (n**3/3) + (n**2/2) - 2*n
def g2(n):
    return n**2 + n - 2
def der2(n):
    return diff(n)

order = [ (y, g(y)) for y in range(-10,10) ]
         
    # Ponto Crítico em X - 1
    # Crescente em X != 0 & x != -1
    # Decrescente em 0 e 1
