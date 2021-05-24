package mp4.ordered;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class OnlineQueue {

    private final LinkedList<Customer> queue = new LinkedList<>();

    public List<Customer> getQueue() {
        return Collections.unmodifiableList(queue);
    }

    public void enqueue(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("customer cannot be null");
        }
        queue.addLast(customer);
    }

    public Customer next() throws Exception {
        if (queue.size() == 0) {
            throw new Exception("queue is empty");
        }
        return queue.pollFirst();
    }
}
