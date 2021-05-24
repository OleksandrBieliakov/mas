package mp4;

import mp4.ordered.Customer;
import mp4.ordered.OnlineQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderedTest {

    @Test
    void test() throws Exception {
        OnlineQueue onlineQueue = new OnlineQueue();
        Customer customer1 = new Customer("c1");
        Customer customer2 = new Customer("c2");
        Customer customer3 = new Customer("c3");
        onlineQueue.enqueue(customer1);
        onlineQueue.enqueue(customer2);
        onlineQueue.enqueue(customer3);
        assertEquals(customer1, onlineQueue.next());
        assertEquals(customer2, onlineQueue.next());
        assertEquals(customer3, onlineQueue.next());
        assertThrows(Exception.class, () -> onlineQueue.next());
    }
}
