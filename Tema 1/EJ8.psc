Algoritmo n_pares
	Escribir 'Introdce el número de pares que se van a sumar (este nº incluido) los números pares: '
	Leer max
	Repetir
		s <- s+num
		num <- num+2
		cont <- cont+1
	Hasta Que cont>max
	Escribir "La suma de los ", max, " primeros pares es ", s
FinAlgoritmo
