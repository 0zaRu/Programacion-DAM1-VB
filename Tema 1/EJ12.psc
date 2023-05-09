Algoritmo venta
	Escribir "Introduc la cantidad de producto que vas a comprar para calular el precio: "
	Leer x
	Si x<=10 Entonces
		precio <- x * 20
	SiNo
		precio <- x*15
	FinSi
	Escribir "Comprando ", x, " productos, pagarías ", precio, "$"
FinAlgoritmo
