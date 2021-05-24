package mp4;

import mp4.custom.Education;
import mp4.custom.RecruitmentApplication;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomTest {

    @Test
    void test() {
        assertThrows(IllegalArgumentException.class, () -> new RecruitmentApplication("Bob", Education.BACHELOR, 3));
    }
}
