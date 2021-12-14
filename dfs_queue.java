import java.util.Iterator;
import java.util.NoSuchElementException;

/**
* the implementation of queue
 */
public class dfs_queue<Element> implements Iterable<Element> {
    private Node<Element> head;		// Start of queue
    private Node<Element> tail;		// end of queue
    private int queueSize;			// number of elements on queue

    /**
     * initialiser
     */
    public dfs_queue() {
        head = null;
        tail = null;
        queueSize = 0;
    }
    
    /**
     * Clear queue
     */
    public void clear() {
        head = null;
        tail = null;
        queueSize = 0;
    }

    /**
     * Checks if the queue is empty
     * @return <tt>true</tt> if this queue is empty; <tt>false</tt> otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Gets the size of the queue
     * @return the number of items in this queue
     */
    public int size() {
        return queueSize;
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

    /**
     * Iterator which will loop through the collection of states held as "elements" in the queue
     * @param <Element>
     */
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

    // Linked lists
    private static class Node<Element> {
        private Element element;
        private Node<Element> next;
    }
    
}