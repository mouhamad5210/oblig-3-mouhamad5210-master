package no.oslomet.cs.algdat.Oblig3;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.*;
import java.util.List;

public class SBinTre<T> {
    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public SBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    //oppgave 1
    // legger inn elementet hvis den er forste element saa den er rot node
    // hvis den er ikke forte saa legger vi den til høyre hvis den er storre eller lik noden og til venstre hvis den er mindre en noden
    //vi begynner fra rotnoden 
    public boolean leggInn(T verdi) { 
        Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

        Node<T> p = rot, q = null;               // p starter i roten
        int cmp = 0;                             // hjelpevariabel

        while (p != null)       // fortsetter til p er ute av treet
        {
            q = p;                                 // q er forelder til p
            cmp = comp.compare(verdi,p.verdi);     // bruker komparatoren
            p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
        }

        // p er nå null, dvs. ute av treet, q er den siste vi passerte

        p = new Node<>(verdi, q);               // oppretter en ny node

        if (q == null) rot = p;                  // p blir rotnode
        else if (cmp < 0) q.venstre = p;         // venstre barn til q
        else q.høyre = p;                        // høyre barn til q
        p.forelder = q;                          // forelder til p

        antall++;                                // én verdi mer i treet
        endringer ++;
        return true;


    }

    public boolean fjern(T verdi){  // hører til klassen SBinTre
        
      if (verdi == null) return false;  // treet har ingen nullverdier
  
      Node<T> p = rot, q = null;   // q skal være forelder til p
  
      while (p != null){            // leter etter verdi
        int cmp = comp.compare(verdi,p.verdi);      // sammenligner
        if (cmp < 0) { q = p; p = p.venstre; }      // går til venstre
        else if (cmp > 0) { q = p; p = p.høyre; }   // går til høyre
        else break;    // den søkte verdien ligger i p
      }
      if (p == null) return false;   // finner ikke verdi
  
      if (p.venstre == null || p.høyre == null){  // Tilfelle 1) og 2)
        Node<T> b = p.venstre != null ? p.venstre : p.høyre;  // b for barn
        if (p == rot){ 
            rot = b;
            b.forelder = null;

        }
        else if (p == q.venstre){ 
            q.venstre = b;
            b.forelder = q;
        }
        else {
            q.høyre = b;
            b.forelder = q;
        }
      }
      else  // Tilfelle 3)
      {
        Node<T> s = p, r = p.høyre;   // finner neste i inorden
        while (r.venstre != null)
        {
          s = r;    // s er forelder til r
          r = r.venstre;
        }
  
        p.verdi = r.verdi;   // kopierer verdien i r til p

        if(r.høyre != null) r = s;
  
        if (s != p) s.venstre = r.høyre;
        else s.høyre = r.høyre;
      }
  
      antall--;   // det er nå én node mindre i treet
      endringer ++;
      return true;
    }

    public int fjernAlle(T verdi) {
        int teller =0;
        if(antall > 0){
            while(inneholder(verdi)){
                teller ++;
                fjern(verdi);
            }
            return teller;
        }
        else{
            System.out.println("Ingen Elementer !");
            return 0;
        }
    }

    public int antall(T verdi) {
        int i = 0;
        if(rot == null){
            return 0;
        }

        Node<T> n = rot;
        while(n!= null){
            int c = comp.compare(verdi, n.verdi);
            if(c==0){i++;}
            if(c>=0){
                n=n.høyre;
            }else{
                n=n.venstre;
            }
        }
        return i;

        
    }

    public void nullstill() {
        if(antall != 0){
            Node<T> n = rot;
            nullstill(rot);
            n = null;
            antall = 0;
            endringer = 0;
            
        }

       
    }
    public void nullstill(Node<T>p){
        if(antall != 0){
            if(p.venstre != null){
                nullstill(p.venstre);
                p.venstre = null;
            }
            if(p.høyre != null){
                nullstill(p.høyre);
                p.høyre = null;
            }
            p.forelder = null;
            p.verdi = null;
        }
    }

    private static <T> Node<T> førstePostorden(Node<T> p) {
        if(p == null){ // sjekker om noden er null saa gaar vi ut av metoden
            return null;
        }
        førstePostorden(p.venstre); // kaller metoden forstePostorden og gi høyre barn til p som parameter
        return p.høyre;
    }

    private static <T> Node<T> nestePostorden(Node<T> p) {
        //forste sjekker vi om forelder node er null, hvis ikke
        // saa sjekker vi om p er høyre barn og har ikke sosken(forelder node har ikke venstre barn) saa forelder noden er neste postorden node
        //Eller kaller vi forste postorden metode med p som parameter hvis p er høyre barn eller p sosken hvis p er venstre barn.
        if(p.forelder == null){
            return null;
        }

        if(p.forelder.venstre == p || p.forelder.høyre == null){
            return p.forelder;
        }

        return førstePostorden(p.forelder.høyre);
        


    }

    public void postorden(Oppgave<? super T> oppgave) {
        //sjekker om treet er tom hvis ikke
        // setter vi en ny node til forste postorden til rot node og skrive ut  det
        //deretter printer neste postorden node i treet ved hjelp av while lokke for aa printe hele treet
        if (antall == 0){
            return;
        }
        Node<T> n = førstePostorden(rot); // setter n til neste node i post orden starter fra rot node
        System.out.println(n);
        while(n !=null){
            oppgave.utførOppgave(n.verdi);
            System.out.println(nestePostorden(n));
        }
    }



    public void postordenRecursive(Oppgave<? super T> oppgave) {
        postordenRecursive(rot, oppgave);
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        if(p==null){
            return;
        } // fra forelesningen for aa skrive ut postorden rekrusivt kaller vi rekursivt venstre saa høyre barn og skriver ut
        postordenRecursive(p.venstre, oppgave);
        postordenRecursive(p.høyre, oppgave);
        oppgave.utførOppgave(p.verdi);
        System.out.println(p);
    }

    public ArrayList<T> serialize() {
        if(rot == null){ //  hvis det er ingen elementer gaa ut av metoden
            System.out.println("Ingen elementer !!");
            return null;
        }

        Queue<Node> noder = new LinkedList(); // ArrayList til aa legge node treet i ko
        ArrayList<T> verdiList = new ArrayList<>();// Arraylist til verier

        while( noder.size() != 0){
            // forst legger vi noden n til listen noder saa legger vi høyre barn og venstre barn hvis det finnes
            Node<T> n = noder.poll();
            verdiList.add(n.verdi);



            if(n.venstre != null){ // sjekker om n har ikke venstre barn og legger vi til listen noder venstre barn til node n
                noder.add(n.venstre);
            }
            if(n.høyre != null){ // sjekekr om n har ikke høyre barn og legger vi til listen noder høyre barn til node n
                noder.add(n.høyre);
            }
        }

        return verdiList;
    }

    static <K> SBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        SBinTre<K> ttre = new SBinTre<>(c);
        for(int i=0; i<data.size(); i++){
            ttre.leggInn(data.get(i));
        }
        return ttre;
    }

        

} // ObligSBinTre
