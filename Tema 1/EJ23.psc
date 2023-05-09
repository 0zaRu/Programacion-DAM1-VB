Algoritmo repes
	
	Definir num, numant, cont, valorrepe, cantrepe, cantrepetemp Como Entero
	numant<-num
	cont<-0
	cantrepe<-0
	cantrepetemp<-0
	
	Mostrar "Introduce valores consecutivos: "
	leer num

	
	Mientras num<>0
	
		cont <- cont+1
		
		Si num = numant
			cantrepetemp <- cantrepetemp + 1
		SiNo 
			cantrepetemp <- 1
		FinSi
		
		Si cantrepetemp >= cantrepe
			cantrepe <- cantrepetemp
			valorrepe <- num
		FinSi
		
		numant<-num
		
		Mostrar "Valor: "
		leer num
		
	FinMientras
	
	Mostrar "Valor más veces repetido: ", valorrepe
	Mostrar "Cantidad de veces repetido: ", cantrepe
	Mostrar "Cantidad de numeros introducidos: ", cont
	
	
FinAlgoritmo
