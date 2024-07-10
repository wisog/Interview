import re

def analizar_lexico(entrada):
    # Expresión regular para encontrar las coordenadas y el texto
    patron = re.compile(r'\((\d+),(\d+)\)([^()]+)')
    
    # Buscar todas las coincidencias en la entrada
    coincidencias = patron.findall(entrada)
    
    # Iterar sobre las coincidencias y formatear la salida
    for coincidencia in coincidencias:
        x, y, texto = coincidencia
        print(f"({x},{y}) {texto}")

# Entrada manual
entrada = input("Introduce la cadena de texto en el formato (X1,Y1)texto1(X2,Y2)texto2(X3,Y3)texto3: ")
analizar_lexico(entrada)