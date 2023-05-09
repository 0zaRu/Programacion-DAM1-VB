Algoritmo suma_par_impar
	Escribir "Introduce valores para que al final se muesren sumdos los pares e impares por separado (0 para finalizar):"
	Repetir
		Escribir "Valor: "
		Leer n
		Si n%2 == 0 Entonces
			sp <- sp+n
		SiNo
			sim <- sim+n
		FinSi
	Hasta Que n==0
	Escribir "La suma de los números pares es ", sp, " y la suma de los impares es ", sim
FinAlgoritmo
