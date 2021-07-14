package lab09.ex1;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ListIterator;

public class VectorGeneric<T>{
    private T[] vec;
    private int nElem;
    private final static int ALLOC = 50;
    private int dimVec = ALLOC;

    @SuppressWarnings("unchecked")
    public VectorGeneric() {
        vec = (T[]) new Object[dimVec];
        nElem = 0;
    }

    public boolean addElem(T elem) {
        if(elem== null)
            return false;
        ensureSpace();
        vec[nElem++] = elem;
        return true;
    }

    private void ensureSpace() {
        if(nElem>=dimVec) {
            dimVec+= ALLOC;
            @SuppressWarnings("unchecked")
            T[] newArray= (T[]) new Object[dimVec];
            System.arraycopy(vec, 0, newArray, 0, nElem);
            vec= newArray;
        }
    }

    public boolean removeElem(T elem) {
        for(int i= 0; i< nElem; i++) {
            if(vec[i].equals(elem)) {
                if(nElem-i-1 > 0) // not last element
                    System.arraycopy(vec, i+1, vec, i, nElem-i-1 );
                vec[--nElem] = null; // libertar último objecto para o GC
                return true;
            }
        }
        return false;
    }

    public int totalElem() {
        return nElem;
    }
    
    public T getElem(int i) {
        return vec[i];
    }

    public Iterator<T> iterator(){
        return new VectorIterator<T>();
    }

    public ListIterator<T> listIterator(){
        return new VectorListIterator<T>();
    }

    public ListIterator<T> listIterator(int index){
        return new VectorListIterator<T>(index);
    }

    private class VectorIterator<K> implements Iterator<K>{
        private int indice;
        
        VectorIterator() {
            indice = 0;
        }

        @Override
        public boolean hasNext() {
            return (indice < nElem);
        }

        @SuppressWarnings("unchecked")
        @Override
        public K next() {
            if (hasNext()) {
                return (K)VectorGeneric.this.vec[indice++];
            }
            throw new NoSuchElementException("only " + nElem + " elements");
        }
        
    }

    private class VectorListIterator<K> implements ListIterator<K>{
        private int indice;

        VectorListIterator() {
            indice = 0;
        }

        VectorListIterator(int indice) {
            this.indice = indice;
        }

        @Override
        public void add(K e) {
            throw new NoSuchElementException("Operation not supported");
        }

        @Override
        public boolean hasNext() {
            return (indice < nElem);
        }

        @Override
        public boolean hasPrevious() {
            return (indice > 0);
        }

        @SuppressWarnings("unchecked")
        @Override
        public K next() {
            if (hasNext()) {
                return (K)VectorGeneric.this.vec[indice++];
            }
            throw new NoSuchElementException("only " + nElem + " elements");
        }

        @Override
        public int nextIndex() {
            if (hasNext())
                return indice;  //experimentar com i++
            throw new NoSuchElementException("only " + nElem + " elements");
        }

        @SuppressWarnings("unchecked")
        @Override
        public K previous() {
            if (hasPrevious()) {
                return (K)VectorGeneric.this.vec[--indice];
            }
            throw new NoSuchElementException("only " + nElem + " elements");
        }

        @Override
        public int previousIndex() {
            if (hasPrevious()){
                int i = indice;
                return --i;
            }
            throw new NoSuchElementException("only " + nElem + " elements");
        }

        @Override
        public void remove() {
            throw new NoSuchElementException("Operation not supported");
        }

        @Override
        public void set(K e) {
            throw new NoSuchElementException("Operation not supported");
        }
        
    }
}