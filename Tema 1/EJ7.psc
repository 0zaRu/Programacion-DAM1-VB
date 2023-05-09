Algoritmo n_impares
	Escribir 'Introdce el número hasta el que se van a sumar (este nº incluido) los números impares: '
	Leer max
	imp <- 1
	Repetir
		s <- s+imp
		imp <- imp+2
	Hasta Que imp>max
	Escribir s
FinAlgoritmo
