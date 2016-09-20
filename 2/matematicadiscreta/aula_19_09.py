from sympy import *
from IPython.display import display
#import numpy as n
#import matplotlib.pyplot as p

x = Symbol('x')

# Criação de listas automáticas
lista = [ (x, f(x)) for x in range(20) ]

# Retorna a função geral das derivadas de acordo com a ordem
def derGer(n): # N é a ordem da derivada f**n(x)
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

#==============================================================================
# A derivada mede a taxa de variação de fenômenos contúnios, como a velocidade.
# A derivada não mede o quanto você andou, ou quanto tempo, ela mede o quanto a
# velocidade variou em função de distância/tempo.
# Geometricamente, é a variação de ângulo
# Do ponto de vista do observador, é a variação de algo
#==============================================================================

# Função geral de uma derivada
# n*x**(n-1)

def der(n):
    return diff(x**n)
    
# y =  3*x**2 - x**5 + 4*x**3 + x + 1
