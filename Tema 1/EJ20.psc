Algoritmo burbuja
	
	Definir a, b, c, g como Enteros
	Mostrar "Introduce el primer valor a comparar: "
	Leer a
	Mostrar "Introduce el segundo valor a comparar: "
	Leer b
	Mostrar "Introduce el tercer valor a comparar: "
	Leer c
	
	Si a<c
		g<-a
		a<-c
		c<-g
	FinSi
	
	Si a<b
		g<-a
		a<-b
		b<-g
	FinSi
	
	Si b<c
		g<-b
		b<-c
		c<-g
	FinSi
	
	Mostrar "El mayor es ", a, " el segundo es ", b, " y el menor es ", c 
	
FinAlgoritmo
