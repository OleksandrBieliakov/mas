package mp4.xor;

import java.util.HashSet;
import java.util.Set;

public class PaidInterface {

    private String name;

    private final Set<FreeInterface> freeInterfaces = new HashSet<>();
    private final Set<PaidInterface> paidInterfaces = new HashSet<>();

    public PaidInterface(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        this.name = name;
    }

    public String doSomePaidStuff() {
        return "PaidInterface " + name;
    }
}
