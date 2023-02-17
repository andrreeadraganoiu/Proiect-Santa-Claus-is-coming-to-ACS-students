322CD Draganoiu Andreea

Proiect Santa Claus is coming to ACS students

Programul incepe prin maparea datelor din fisierul Input, continua cu InitialData
si cu campurile continute de acestea.

Descrierea entitatilor si a pachetelor:

input  - contine clase care se ocupa de parsarea datelor din fisierele de input
output - contine clase care se ocupa de scrierea datelor obtinute in urma
	 simularii in fisierul de output

main/Main - Sunt parsate datele de input, este apelata simularea rundelor si 
	    este apelata scrierea datelor obtinute in fisierele de output.
main/Simulation - O clasa singleton care include functia principala a 
		  programului, se ocupa cu apelarea functiilor auxiliare
		  pentru prelucrarea datelor fiecarei runde. Dupa incheierea
		  simularii, se construieste o clasa 'AnnualChildren' ce va
		  contine informatiile ce trebuie parsate in fisierul de 
		  output.

characters/Santa - Are definite functii pentru procesarea datelor copiilor. 
	      	   Se impart cadouri, se actualizeaza datele copiilor existenti,
		   dar se adauga si noi copii si cadouri in fiecare an. Se acorda
		   bonusuri si se imparte bugetul mosului.
characters/Elves - Aplica elful corespunzator fiecarui copil. Inainte de distribuirea
		   cadourilor se pot aplica doar elfii WHITE, PINK si BLACK. Dupa
		   impartirea cadourilor tutoror copiilor se va apela functia care
		   aplica elful YELLOW copiilor care au acest tip de elf si nu
		   au primit niciun cadou in acel an de Craciun. In acest caz vor primi
		   cel mai ieftin cadou din prima categorie preferata daca acesta
		   mai exista in sacul mosului.	
utils/Utils - Contine functii pentru deep-copy, pentru sortarea unei mape descrescator 
	      dupa valoare si crescator dupa cheie si constructia copiilor cu Builder.
strategies/score - Contine o fabrica de strategii care vor fi aplicate pentru 
	     	   calcularea scorului de cumintenie al unui copil in functie de
	           categoria sa varsta.
strategies/distribution - Contine o fabrica de strategii pentru a determina modul
			  in care trebuie ordonati copiii inainte de a primii 
			  cadourile.

Design patterns:

Builder   - pentru a construi un copil cu toate caracteristicile sale si
	    campul optional bonus.
Singleton - pentru a avea o singura instanta de ScoreStrategyFactory
	  - pentru a avea o singura instanta a simularii rundelor
          - pentru a avea o singura instanta de StrategyFactory
Factory   - strategiile folosite pentru calcularea scorurilor sunt create cu
	    ajutorul unui factory(ScoreStrategyFactory)
	  - strategiile folosite pentru modurile de ordonare a copiilor sunt 
	    create cu ajutorul unui factory(StrategyFactory)
Strategy  - folosit pentru a alege modul in care este calculat scorului 
	    fiecarui copil
          - folosit pentru a alege modul in care este sunt sortati copiii inainte de
	    a-si primi cadourile.