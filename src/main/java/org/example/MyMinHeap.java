public class MyMinHeap<T extends Comparable<T>> {
    private MyList<T> list;

    public MyMinHeap() {
        this.list = new MyArrayList<>();
    }

    public void insert(T item) {
        list.add(item);
        heapifyUp(list.size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            T parentItem = list.get(parentIndex);
            T currentItem = list.get(index);
            if (parentItem.compareTo(currentItem) > 0) {
                swap(parentIndex, index);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    public T extractMin() {
        if (list.size() == 0) {
            throw new NoSuchElementException();
        }
        T minItem = list.get(0);
        T lastItem = list.get(list.size() - 1);
        list.set(0, lastItem);
        list.remove(list.size() - 1);
        heapifyDown(0);
        return minItem;
    }

    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestIndex = index;

        if (leftChildIndex < list.size() && list.get(leftChildIndex).compareTo(list.get(smallestIndex)) < 0) {
            smallestIndex = leftChildIndex;
        }
        if (rightChildIndex < list.size() && list.get(rightChildIndex).compareTo(list.get(smallestIndex)) < 0) {
            smallestIndex = rightChildIndex;
        }

        if (smallestIndex != index) {
            swap(index, smallestIndex);
            heapifyDown(smallestIndex);
        }
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}