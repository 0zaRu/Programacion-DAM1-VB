Algoritmo n_impares
	Escribir "Introduce la cantidad de números impares ascendentes desde 0 que quieres ver: "
	Leer cant
	n <- 1
	x <- 0
	Repetir
		Escribir n
		n <- n+2
		x <- x+1
	Hasta Que x>=cant
FinAlgoritmo
