Algoritmo suma_hasta_200
	
	Definir n, contador, bandera, suma, exceso Como Entero
	bandera <- 0
	suma <- 0
	exceso <- 0
	contador<- 0
	Mostrar "Introduce valores para sumarlos consecutivamente (200 para cambiar de suma, 0 para terminar): "
	
	Mostrar "Valor: "
	leer n

	Mientras n<>0 Hacer
		contador<-contador+1
		
		Si n>=200 y bandera=0
			bandera<-1
			Mostrar "Valor: "
			leer n
		FinSi
	
		Si bandera=0
			suma<-suma+n
		SiNo
			exceso<-exceso+n
		FinSi
	
	Mostrar "Valor: "
	leer n
	
FinMientras

Mostrar "La suma previa a 200 es ", suma, ", la posterior es ", exceso, ", y se han intrducido ", contador, " números"
FinAlgoritmo
