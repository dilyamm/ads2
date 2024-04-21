public abstract class MyArrayList<T> implements MyList<T> {
    private Object[] arr;
    private int length;
    private static final int DEFAULT_CAPACITY = 5;

    public MyArrayList() {
        arr = new Object[DEFAULT_CAPACITY];
        length = 0;
    }

    public void add(T element) {
        ensureCapacity(length + 1);
        arr[length++] = element;
    }

    public void set(int index, T element) {
        if (index < 0 || index >= length)
            throw new IndexOutOfBoundsException();
        arr[index] = element;
    }

    public void add(int index, T element) {
        if (index < 0 || index > length)
            throw new IndexOutOfBoundsException();
        ensureCapacity(length + 1);
        for (int i = length; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = element;
        length++;
    }

    public void addFirst(T element) {
        add(0, element);
    }

    public void addLast(T element) {
        add(element);
    }

    public T get(int index) {
        if (index < 0 || index >= length)
            throw new IndexOutOfBoundsException();
        return (T) arr[index];
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(length - 1);
    }

    public void remove(int index) {
        if (index < 0 || index >= length)
            throw new IndexOutOfBoundsException();
        for (int i = index; i < length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--length] = null;
    }

    public void sort() {
        boolean swapped = false;
        for (int i = 0; i < length - 1; i++) {
            swapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                Comparable<T> o1 = (Comparable<T>) get(i);
                Comparable<T> o2 = (Comparable<T>) get(j);
                if (o2.compareTo((T) o1) > 0) {
                    swap(i, j);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }


    private void swap(int i, int j) {
        T temp = get(i);
        set(i, get(j));
        set(j, temp);
    }

    public int index_Of(T element) {
        for (int i = 0; i < length; i++)
            if (element.equals(arr[i]))
                return i;
        return -1;
    }

    public int last_Index_Of(T element) {
        for (int i = length - 1; i >= 0; i--)
            if (element.equals(arr[i]))
                return i;
        return -1;
    }

    public boolean exist(T element) {
        return indexOf(element) != -1;
    }

    public T[] toArray() {
        Object[] newArray = new Object[length];
        for (int i = 0; i < length; i++) {
            newArray[i] = arr[i];
        }
        return (T[]) newArray;
    }

    @Override
    public void clear() {
        for (int i = 0; i < length; i++) {
            arr[i] = null;
        }
        length = 0;
    }

    public int length() {
        return length;
    }

    private void ensureCapacity(int minCapacity) {
        int oldCapacity = arr.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = (oldCapacity * 3) / 2 + 1;
            if (newCapacity < minCapacity)
                newCapacity = minCapacity;
            Object[] newArray = new Object[newCapacity];
            for (int i = 0; i < length; i++) {
                newArray[i] = arr[i];
            }
            arr = newArray;
        }
    }
}