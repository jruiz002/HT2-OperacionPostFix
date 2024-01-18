public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value){
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return this.value;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setValue(T newValue) {
        this.value = newValue;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

}
