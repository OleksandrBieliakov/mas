package mp4;

import mp4.unique.Citizen;
import mp4.unique.VaccinationCenter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UniqueTest {

    @Test
    void test() {
        VaccinationCenter vaccinationCenter = new VaccinationCenter();
        Citizen citizen = new Citizen("c1");
        vaccinationCenter.vaccinate(citizen);
        assertThrows(IllegalArgumentException.class, () -> vaccinationCenter.vaccinate(citizen));
    }
}
