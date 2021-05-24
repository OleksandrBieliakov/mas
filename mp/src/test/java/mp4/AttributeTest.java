package mp4;

import mp4.attribute.Reservoir;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AttributeTest {

    @Test
    void test() {
        Reservoir reservoir = new Reservoir(20, 10);
        assertThrows(IllegalArgumentException.class, () -> reservoir.setCurrentContent(21));
    }
}
