/**
 * Interfaz para una pila personalizada.
 * 
 * @param <T> el tipo de elementos en la pila.
 */
public interface ICustomStack<T> {
    /**
     * Agrega un valor a la pila.
     * 
     * @param value el valor que se agregará a la pila.
     */
    public void push(T value);

    /**
     * Extrae un valor de la pila.
     * 
     * @return el valor extraído de la pila.
     */
    public T pop();
}
