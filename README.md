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





# Oppgave 5
metode seralize som gjør om binærtreet til et array
først sjekekr om rot node er null hvis ike  så oppretter vi 1- Queue list, og den skal legge inn alle noder og skal vi bruke den til å rekke noder en og en  2- ArrayList som har verdier 
ved hjelp av while løkke tar vi en og en node fra liste Queue og legger verdien til noden i verider ArrayList så legger vi til Queue n sin venstre barn og n sin høyre barn hvis de er ikke null 
til at alle elementer i treet ble lagt til Queue og trekket igjen og verdi liste er fylt opp med verdier
tilslutt returnerer vi en verdi lisit.

i deserialize metode oppretter vi en ny tom tre
 så ved hjelp av for lokke  legger vi en og en node til treet ved hjelp av metoden leggInn så har  vi en tre fra ArrayList 
til slutt returnerer vi treet vi lagde-.




# oppgave 6 // har feil i kjøringen jeg kunne ikke fikse det 
metoden fjern her har vi kopiert koden fra kopondiet 
først sjekekr om veriden som oppgitt i parameteren er null hvis null så return false.
så oppretter vi to noder (p) som referer til rot og en(q) peker til p sin forelder 
så ved hjelp av while løkke sjekekr om oppgitt verdi i parameter er større eller mindre en verdien i noden p.
hvis mindre så går vi til venstre barn og q er venstre barn forelder (p)
hvis større  så går vi til høyre barn og q er høyre barn forelder (p)
eller går iv ut av løkken 
etter at vi er ut av løkken så har vi p enten er null eller p verdi er lik parameter verdie (verdien som vi ønsker å fejrne).
hvis p er null så verdien finnes ikke og returnerer vi null.
hvis ikke så er vi i verdien som vi skal fjerne 
hvis p sin venstre barn eller høyre barn er null så oppretter vi en node (b) med peker til den barnet som ikke er null
hvis p er rot node:
  så setter vi b som er  rot node og nullstiller forelderen 
hvis p er venstre barn til sin forelder så
  p sin forelder sin venstre barn er b og b sin forelder er faren til p ( så vi har fjernet pekern til noden p og   den blir fjernet av java)
eller hvis p er høyre barn så setter forelderen til b til å referere til noden q.

siste tilfelle
først opretter vi to noder en er (s) som er lik p og den andre er (r) som er p sin høyre barn
ved hjelp av while løkke går vi til siste venstre barn som ikke er null og (s) peker på den og r peker på venstre baran
vi kopierer veriden i r til p
hvis r sin høyre barn er null så r er like sin forelder (s) 
hvis noden s er ikke lik p  så venstre barn til s er lik høyre barn til p ELLER er høyre barn til s er like høyre barn til p
til slutt nullstiller antall (antall = 0)
og øker endringer med 1
og returnerer true ( at noden ble fjernet)


i metoden fjernAlle
hvis treet er ikke tom  så går vi i while løkke  og finner noder som har samme verdi som skal fjernes ved hjelp av metoden inneholder.
øker telleren med 1 og fjerner noden. 
til slutt returnerer vi antall noder som er fjernet.

i metoden nullstill har jeg kjørings feil kunne ikke finne feilen 
første tenkte jeg å nullstille bare rot noden så alt blir nullstilt automatisk siden det er ingen peker som peker på de men fikk feil i kjøring. derfor kommentert det ut 
så prøvde jeg å går i hele treet og nullstilel alle pekere og ved å sjekke om venstre barn er ikek null og høyre barn er ikke null og nullstille dem hvis begge er null så nullstller jeg det node ogv. men fikk en feil også i kjøring 




