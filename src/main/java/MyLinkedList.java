public abstract class MyLinkedList<T> implements MyList<T> {
    private static class Node<T> {
        T data;
        Node next;
        Node previous;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int lenght = 0;

    public void add(T element) {
        addLast(element);
    }

    public void set(int index, T element) {
        Node<T> node = getNode(index);
        node.data = element;
    }

    public void add(int index, T element) {
        if (index < 0 || index > lenght) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(element);
        } else if (index == lenght) {
            addLast(element);
        } else {
            Node<T> prev = getNode(index - 1);
            Node<T> newNode = new Node<>(element);
            newNode.next = prev.next;
            prev.next = newNode;
            lenght++;
        }
    }

    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
        if (lenght == 0) {
            tail = head;
        }
        lenght++;
    }

    public void addLast(T element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        lenght++;
    }

    public T get(int index) {
        return (T) getNode(index).data;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return (T) head.data;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return (T) tail.data;
    }

    public void remove(int index) {
        if (index < 0 || index >= lenght) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
            head.previous = null;
        } else if (index == lenght - 1) {
            tail = tail.previous;
            tail.next = null;
        } else {
            Node current = getNode(index);
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        lenght--;
    }

    public void sort() {
        boolean swapped;
        do {
            swapped = false;
            Node<T> current = head;
            Node<T> previous = null;
            while (current != null && current.next != null) {
                Comparable<T> currentData = (Comparable<T>) current.data;
                Comparable<T> nextData = (Comparable<T>) current.next.data;
                if (currentData.compareTo((T) nextData) > 0) {
                    if (previous == null) {
                        head = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    Node<T> nextNode = current.next.next;
                    current.next.next = current;
                    current.next = nextNode;
                    previous = current.next;
                    swapped = true;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        } while (swapped);
    }

    public int index_Of(T element) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(element)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public int last_Index_Of(T element) {
        Node current = tail;
        int index = lenght - 1;
        while (current != null) {
            if (current.data.equals(element)) {
                return index;
            }
            current = current.previous;
            index--;
        }
        return -1;
    }

    public boolean exist(T element) {
        return indexOf(element) != -1;
    }

    public Object[] toArray() {
        Object[] array = new Object[lenght];
        Node current = head;
        int index = 0;
        while (current != null) {
            array[index++] = (T) current.data;
            current = current.next;
        }
        return array;
    }

    public void clear() {
        head = null;
        tail = null;
        lenght = 0;
    }

    public int size() {
        return lenght;
    }

    private boolean isEmpty() {
        return lenght == 0;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= lenght) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current;
    }
}