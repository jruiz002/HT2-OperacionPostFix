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
}