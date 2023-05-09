Algoritmo suma_200
	Escribir 'Introduce valores aleatorios para sumarlos (0 para salir): '
	introducidos <- -1
	Repetir
		Leer n
		Si suma+n>200 & parte==0 Entonces
			flag <- 1
			Escribir suma, " + ", n, " ha sido superior a 200, desde ahora se suma en exceso"
			Leer n
		FinSi
		introducidos <- introducidos+1
		Si flag==0 Entonces
			suma <- suma+n
		SiNo
			exceso <- exceso+n
		FinSi
	Hasta Que n==0
	Si flag == 0 Entonces
		Escribir "La suma no ha llegado a 200, has introducido ", introducidos, " valores y su suma es ", suma
	SiNo
		Escribir 'La cantidad de valores introducidos es ',introducidos,', la suma antes de llegar al valor 200 es ',suma,' y la de los numeros posteriores es ',exceso
	FinSi
FinAlgoritmo
