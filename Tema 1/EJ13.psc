Algoritmo libros
	Escribir "Introduce el tipo de libros que vas a comprar (1 o 2): "
	Leer tipo
	Escribir "Introduce la cantidad de libros que vas a comprar del tipo ", tipo, ":"
	Leer cant
	Si tipo == 1 Entonces
		pecio <- 80
	SiNo
		precio <- 100
	FinSi
	Escribir "El precio de comprar ", cant, " libros del tipo ", tipo, " es: ", cant*precio, "$"
FinAlgoritmo
