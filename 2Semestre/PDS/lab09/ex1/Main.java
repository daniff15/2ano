package lab09.ex1;

import java.util.Iterator;
import java.util.ListIterator;


public class Main {
    public static void main(String[] args) {
        VectorGeneric<Integer> vp = new VectorGeneric<>();
        for (int i = 0; i < 10; i++) {
            vp.addElem(i);
        }

        System.out.println("Iterator");

        Iterator<Integer> vec = vp.iterator();
        while(vec.hasNext()){
            System.out.println(vec.next());
        }

        System.out.println();
        System.out.println("ListIterator sem indice");

        ListIterator<Integer> vec1 = vp.listIterator();
        while(vec1.hasNext()){
            System.out.println("Indice: " + vec1.nextIndex() +"; Elem: " + vec1.next());
        } 
        System.out.println("Acabou o hasNext e começou o hasPrevious");
        while(vec1.hasPrevious()){
            System.out.println("Indice: " + vec1.previousIndex() +"; Elem: " + vec1.previous());
        }
        System.out.println("Acabou o hasPrevious e começou o hasNext");
        while(vec1.hasNext()){
            System.out.println("Indice: " + vec1.nextIndex() +"; Elem: " + vec1.next());
        }
        
        System.out.println();
        System.out.println("ListIterator com indice 3");

        ListIterator<Integer> vec2 = vp.listIterator(3);
        while(vec2.hasNext()){
            System.out.println("Indice: " + vec2.nextIndex() +"; Elem: " + vec2.next());
        } 
        System.out.println("Acabou o hasNext e começou o hasPrevious");
        while(vec2.hasPrevious()){
            System.out.println("Indice: " + vec2.previousIndex() +"; Elem: " + vec2.previous());
        }
        System.out.println("Acabou o hasPrevious e começou o hasNext");
        while(vec2.hasNext()){
            System.out.println("Indice: " + vec2.nextIndex() +"; Elem: " + vec2.next());
        }
    }
}
