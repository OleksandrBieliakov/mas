package mp4;

import mp4.xor.FreeInterface;
import mp4.xor.PaidInterface;
import mp4.xor.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class XorTest {

    @Test
    void test() throws Exception {
        User user = new User("u1");
        FreeInterface freeInterface = new FreeInterface("f1");
        PaidInterface paidInterface = new PaidInterface("p1");
        user.addFreeInterface(freeInterface);
        assertThrows(Exception.class, () -> user.addPaidInterface(paidInterface));
        user.clearFreeInterfaces();
        user.addPaidInterface(paidInterface);
        assertThrows(Exception.class, () -> user.addFreeInterface(freeInterface));
    }
}
