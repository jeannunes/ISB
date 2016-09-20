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
