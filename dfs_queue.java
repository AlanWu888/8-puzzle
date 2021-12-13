import java.util.Iterator;
import java.util.NoSuchElementException;

/**
* the implementation of queue
 */
public class dfs_queue<Element> implements Iterable<Element> {
    private Node<Element> head;		// Start of queue
    private Node<Element> tail;		// end of queue
    private int queueSize;               // number of elements on queue

    // helper linked list class
    private static class Node<Element> {
        private Element element;
        private Node<Element> next;
    }

    /**
     * Initializes an empty queue.
     */
    public dfs_queue() {
        head = null;
        tail = null;
        queueSize = 0;
    }

    public void clear() {
        head = null;
        tail = null;
        queueSize = 0;
    }

    /**
     * Returns true if this queue is empty.
     *
     * @return <tt>true</tt> if this queue is empty; <tt>false</tt> otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    public int size() {
        return queueSize;
    }

    /**
     * Returns the element least recently added to this queue.
     *
     * @return the element least recently added to this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public Element peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return head.element;
    }

    /**
     * Adds the element to this queue.
     *
     * @param element the element to add
     */
    public void enqueue(Element element) {

        Node<Element> oldlast = tail;
        tail = new Node<Element>();
        tail.element = element;
        tail.next = null;
        if (isEmpty()) head = tail;
        else oldlast.next = tail;
        queueSize++;
    }

    /**
     * Removes and returns the element on this queue that was least recently added.
     *
     * @return the element on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public Element dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Element element = head.element;
        head = head.next;
        queueSize--;
        if (isEmpty()) tail = null;   // to avoid loitering
        return element;
    }


    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     *
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Element> iterator() {
        return new ListIterator<Element>(head);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Element> implements Iterator<Element> {
        private Node<Element> current;

        public ListIterator(Node<Element> head) {
            current = head;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Element next() {
            if (!hasNext()) throw new NoSuchElementException();
            Element element = current.element;
            current = current.next;
            return element;
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    /**
     * add a queue to the beginning of the current queue
     */
    public void addQueue(dfs_queue<Element> queue) {
        if (!queue.isEmpty()) {
            Node<Element> prevHead = head;
            
            if (isEmpty()) {
                head = queue.head;
                tail = queue.tail;
            } else {
                head = queue.head;
                queue.tail.next = prevHead;
            }
            queueSize = queueSize + queue.size();
        }

    }

}