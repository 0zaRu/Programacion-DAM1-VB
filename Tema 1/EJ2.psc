Algoritmo valor_mayor
	Escribir 'Introduce el primer valor  comparar: '
	Leer v1
	Escribir 'Introduce el segundo valor a comparar: '
	Leer v2
	Si v1>v2 Entonces
		Escribir 'El valor mayor entre ',v1,' y ',v2,' es ',v1
	SiNo
		Si v1<v2 Entonces
			Escribir 'El valor mayor entre ',v1,' y ',v2,' es ',v2
		SiNo
			Escribir "Los dos valores son iguales: ", v1
		FinSi
	FinSi
FinAlgoritmo
