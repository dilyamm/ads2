public class MyQueue<T> {
    private MyList<T> list;

    public MyQueue() {
        this.list = new MyLinkedList<>();
    }

    public void enqueue(T item) {
        list.add(item);
    }

    public T dequeue() {
        if (list.size() == 0) {
            throw new NoSuchElementException();
        }
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    public T peek() {
        if (list.size() == 0) {
            throw new NoSuchElementException();
        }
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}