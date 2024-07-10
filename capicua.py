def es_capicua(n):
    # Verifica si un número es capicúa (se lee igual de izquierda a derecha y viceversa)
    return str(n) == str(n)[::-1]  # Compara el número con su versión invertida

def encontrar_capicua(n):
    iteraciones = 0  # Inicializa el contador de iteraciones
    while not es_capicua(n):  # Mientras el número no sea capicúa
        n += int(str(n)[::-1])  # Suma el número con su versión invertida
        iteraciones += 1  # Incrementa el contador de iteraciones
    return n, iteraciones  # Devuelve el número capicúa y el número de iteraciones

# Entrada manual
numero = int(input("Introduce un número entero mayor a 9 y menor a 10000: "))  # Solicita al usuario un número
capicua, iteraciones = encontrar_capicua(numero)  # Encuentra el capicúa y las iteraciones necesarias
print(capicua, iteraciones)  # Imprime el número capicúa y el número de iteraciones