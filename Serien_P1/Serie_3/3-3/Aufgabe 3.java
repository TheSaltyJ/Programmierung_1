/* ************************************************************************* *\
*						Programmierung 1 HS 2018 - Serie 3-3				  *
*                Jonas Gehrlein (15-127-541) & Jan Dietrich (10-100-436)      *
*                					File: Aufgabe3.java						  *
\* ************************************************************************* */

/* Aufgabe 3-3

1)
a = 1, b = 1
a = 0, b = 0

2)
	//do-loop
	int i = 1;
	do
	{
		i++;
		System.out.println(i);
	}
	while(i<10);
	
	//for-loop
	for(int i = 1; i < 10; i++)
		System.out.println(i);
	
3)
Das Programm kompiliert ohne Probleme. Wenn man es aber ausführt und nicht direkt das statement "counter != limit" false ist,
führt das aber zu einer endlosschleife. Um das Problem zu beheben sollte man die abfrage auf "counter <= limit".



	