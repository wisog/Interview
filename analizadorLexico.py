
print("Ingrese su cadena: ")
cadena = input() #cadena ingresada
token = [] #arreglo donde guardaremos el resultado
index = 0 #iterador para saber el num de posición
subcadena = '' #gurdar cada coordenada con su respectivo texto
coordenadas = '' #para verificar si son coordenadas
finCadena = False #verificar si es fin de cadena
aux = 0
subaux = ''

#ciclo en donde se checará caracter por caracter de la cadena ingresada
while index < len(cadena) and finCadena == False:
    if cadena[index] == "(": #si empieza con parantesis que abré se harán validaciones para las siguientes cadenas
        subcadena += cadena[index] #concatenamos la cadena ingresada en nuestra variable
        if index < len(cadena)-1:
            index += 1
        else:
            finCadena = True #activaremos la bandera ya que nuestro iterador se salio de rango
        while cadena[index] != ")":
            coordenadas += cadena[index] #empezaremos la validacion de las coordenas, si son validas o no
            if index < len(cadena)-1:
                index += 1
            else:
                finCadena = True
        coordenadas = coordenadas.split(",") #separaremos las coordenadas en un array quitando la coma
        if coordenadas[0].isnumeric: #verificaremos si son numeros las coordenas ingresadas
            subcadena+= coordenadas[0]
            if coordenadas[1].isnumeric:
                subcadena += ","
                subcadena += coordenadas[1]

        
        coordenadas = ''
        subcadena += cadena[index]
        subcadena += ' '
        if index < len(cadena)-1:
            index += 1
        else:
            finCadena = True
        while cadena[index] != "(" and finCadena == False:
            subcadena += cadena[index]
            if index < len(cadena)-1:
                index += 1
            else:
                finCadena = True
                
        if cadena[index] == "(":
            aux = index
            subaux += cadena[aux]
            if aux < len(cadena)-1:
                aux += 1
            else:
                finCadena = True
            while cadena[aux] != ")":
                coordenadas += cadena[aux] #empezaremos la validacion de las coordenas, si son validas o no
                if aux < len(cadena)-1:
                    aux += 1
                else:
                    finCadena = True
            if coordenadas.find(",") == -1:
                subaux += coordenadas
                subaux += cadena[aux]
                subcadena += subaux
                token.append(subcadena) #anadimos nuestra variable aux a nuestro array de salida
                subcadena = '' #reset a las variables para poder leer nueva coordenada
                coordenadas = ''
                subaux = ''
                index = aux + 1
            else:
                token.append(subcadena) #anadimos nuestra variable aux a nuestro array de salida
                subcadena = '' #reset a las variables para poder leer nueva coordenada
                coordenadas = ''
                subaux = ''
                continue
        else:
            token.append(subcadena)

for tok in token:
    print(tok)
        
