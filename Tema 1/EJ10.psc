Algoritmo cuadrados_pedidos_contador
	Escribir 'Introduce valores para hallar su cuadrado (0 para terminar):'
	cont <- -1
	Repetir
		Escribir 'Valor: '
		Leer n
		Escribir 'Su cuadrado es: ',n*n
		cont <- cont+1
	Hasta Que n==0
	Escribir 'Gracias por usar el programa, has realizado ', cont, " raizes cuadradas"
FinAlgoritmo
