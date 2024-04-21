public class MyStack<T> {
    private MyList<T> list;

    public MyStack() {
        this.list = new MyArrayList<>();
    }

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (list.size() == 0) {
            throw new EmptyStackException();
        }
        T item = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return item;
    }

    public T peek() {
        if (list.size() == 0) {
            throw new EmptyStackException();
        }
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}