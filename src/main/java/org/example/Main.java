public class Main {
    public static void main(String[] args) {
        // Test MyArrayList
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        System.out.println("ArrayList: " + arrayList.size());

        // Test MyLinkedList
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println("LinkedList: " + linkedList.size());

        // Test MyStack
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack: " + stack.peek());

        // Test MyQueue
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Queue: " + queue.peek());

        // Test MyMinHeap
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
        System.out.println("MinHeap: " + minHeap.findMin());
    }
}