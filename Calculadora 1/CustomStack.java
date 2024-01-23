/**
 * Implementación de una pila personalizada.
 * 
 * @param <T> el tipo de elementos en la pila.
 */
public class CustomStack<T> implements ICustomStack<T> {

    protected Node<T> lastNode;
    protected Node<T> firstNode;

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(T value) {
        if (lastNode == null) {
            lastNode = new Node<T>(value);
            firstNode = lastNode;
        } else {
            Node<T> current = new Node<T>(value);
            current.setNext(firstNode);
            firstNode = current;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T pop() {
        if (lastNode != null) {
            if (firstNode.equals(lastNode)) {
                T valueT = lastNode.getValue();
                firstNode = null;
                lastNode = null;
                return valueT;
            } else {
                T valueFirst = firstNode.getValue();
                firstNode = firstNode.getNext();
                return valueFirst;
            }
        } else {
            return null;
        }
    }

    /**
     * Obtiene el tamaño actual de la pila.
     * 
     * @return El tamaño de la pila.
     */
    public int size() {
        int count = 0;
        Node<T> current = firstNode;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    /**
     * Extrae y devuelve el elemento superior de la pila como una cadena.
     * 
     * @return El elemento superior de la pila como cadena, o null si la pila está vacía.
     */
    public String popAsString() {
        T value = pop();
        return value != null ? String.valueOf(value) : null;
    }
}