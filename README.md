# Obligatorisk oppgave 3 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende student:
* Navn Navnesen, S123456, s123456@oslomet.no


# Oppgavebeskrivelse

# Oppgave 1
den er kode fra kompendiet
først starter vi fra rot node og en hjelpe variabel
så går vi i treet til riktig plass ved hjelp av comp.compare(verdi, p.verdi) og while løkke med å ha en peker til forelder (q)
hvis resultatet er mindre enn 0 ==> gitt veridi i parameter er mindre en verdien til noden går vi til venstre barn eller går vi til høyre barn. hvis det barnet som vi kommet til er ikke null så forstetter vi til at vi kommer til et barn som er null så oppretter vi en ny node og setter verdien til denne noden med oppgitt verdi i parameteren og forelder (q)

hvis q er null så betyr det at noden vi har opprettet er rot node ellers sjekker vi HVIS q sin venstre barn er lik p så setter vi pekeren til q.venstre til å like p ELLER setter vi pekeren q.høyre til å peke på p




# Oppgave 2
først sjekker at det er elementer i treet ved å sjekke om rot node er null eller ikke
så lager vi en teller og starter med 0.
så begynner vi fra rot noden og sammenligne verdien i noden med oppgitt verdi i parameter
hvis verdien er lik 0 ==> øker vi telleren med 1.
hvis parameter verdei er større enn verdein i noden så går vi til høyre barn og sjekker igjen og igjeb så lenge noden er ikke null
hvis parameter verdi er mindre enn verdien i noden så går vi til venstre barn og sjekker igjen og igjen så lenge noden er ikke null

til slutt returnerer vi telleren som har antallet.





# opgave 3
i oppgave 3 lagde jeg først en hjelpe metode private static <T> Node<T> førstePostorden(Node<T> p)
  første begynner vi med å lage u endelig loop ved hjelp av while løkke while(true){...}
  i løkken så sjekker vi først om venstre barn finnes (ikke er null) så går vi til venstre så sjekker vi hvis høyre barn finnes (ikke er null) og går vi til høyre 
  hvis begge Noden barna finnes ikke (venstre og høyre er null) så går vi ut av løkka og returnerer Noden som ikke har noen barn og da er det den første postorden node
  
  så har jeg lagde en metode nestePostorden(Node<T>) p).
  i denne metoden sjekker jeg om forelderen til p (parameter node) er null, hvis den er null sa går vi ut av metoden og returnerer null.
  eller sjekker om p er venstre barn til sin forelder eller p sin høyre søsken er null så returnerer vi p sin forelder.
  
  til slutt kaller vi førstePostorden metoden med p sin høyre søsken som parameter.
  og returnerer verdien vi får fra metoden 


  
  # oppgave 4
  i metoden postorden(Oppgave<? super T> oppgave){...} 
først sjekker vi at treet er ikke tom hvis den er tom så returnerer vi null eller fortsetter videre
så oppretter vi en node n og vi får kalle hjelpe metode førstePostorden med rot som parameter for å finn første postorder node til treet 
så går vi i while løkke for å utføre oppgaven print f.eks
så går vi til neste node ved å kalle metoden nestepostorden() for å printe den neste verdien eller utføre neste oppgave i noden 

i metoden postordenRecursice(Oppgave<? super T> oppgave)  er det bare en kall til private meode postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) som er hjelpe metode og den skal
først sjekker om parameter noden er null
hvis ikke så kaller metoden postordenRecursive med p sin venstre barn som parameter så kaller amme metode postordenRecursive med p sin høyre barn
til slutt utfører vi oppgaven elelr printe verdien hvis oppgaven er print f.eks  
