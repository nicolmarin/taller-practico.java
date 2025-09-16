import java.util.ArrayList;
import java.util.EmptyStackException;

public class Pila <T> {
    private ArrayList<T> elementos = new ArrayList<>(null);

    public void push (T elemento){
        elementos.add(elemento);

    }
     public T pop (){
        if (isEmpty()) {
            throw new EmptyStackException();

                   
        }
        return elementos.remove(elementos.size()); 

     }

    public boolean isEmpty (){
        return elementos.isEmpty();
    }   
    
}
