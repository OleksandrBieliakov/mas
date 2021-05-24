package mp4.unique;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class VaccinationCenter {

    private final Set<Citizen> servedCitizens = new HashSet<>();

    public Set<Citizen> getServedCitizens() {
        return Collections.unmodifiableSet(servedCitizens);
    }

    public void vaccinate(Citizen citizen) {
        if (citizen == null) {
            throw new IllegalArgumentException("citizen cannot be null");
        }
        if (servedCitizens.contains(citizen)) {
            throw new IllegalArgumentException("citizen already received vaccination");
        }
        servedCitizens.add(citizen);
    }
}
