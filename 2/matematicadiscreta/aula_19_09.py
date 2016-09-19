from sympy import *
from IPython.display import display
#import numpy as n
#import matplotlib.pyplot as p

x = Symbol('x')

# Criação de listas automáticas
lista = [ (x, f(x)) for x in range(20) ]

# Retorna a função geral das derivadas de acordo com a ordem
def derivadaGeral(n): # N é a ordem da derivada f**n(x)
    resto = n%4
    if resto == 0:
        return sin(x)
    elif resto == 1:
        return cos(x)
    elif resto == 2:
        return -sin(x)
    else:
        return -cos(x)
        
def f(n):
    return n

def v(d, t):
    return d/t
