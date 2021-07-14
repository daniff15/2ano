package lab09.ex3;

import java.util.Collection;
import java.util.Stack;

public class Remove<T> implements Command<T> {
    private Stack<T> stack; 
	private Collection<T> col;

    public Remove(Collection<T> col) {
        this.col = col;
        this.stack = new Stack<>();
    }

    public Stack<T> getStack() {
		return stack;
	}

	public Collection<T> getCol() {
		return col;
	}

    @Override
    public boolean execute(T element){
        if(getCol().remove(element)){
            getStack().push(element);
            return true;
        }
	    return false;
        
    }

    @Override
	public boolean undo(){
	    if(getCol().add(getStack().peek())){
	        getStack().pop();
            return true;
        }
	    return false;

    }

}
