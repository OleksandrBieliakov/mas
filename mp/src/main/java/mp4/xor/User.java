package mp4.xor;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class User {

    private String name;

    private final Set<FreeInterface> freeInterfaces = new HashSet<>();
    private final Set<PaidInterface> paidInterfaces = new HashSet<>();

    public User(String name) {
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

    public Set<FreeInterface> getFreeInterfaces() {
        return Collections.unmodifiableSet(freeInterfaces);
    }

    public Set<PaidInterface> getPaidInterfaces() {
        return Collections.unmodifiableSet(paidInterfaces);
    }

    public void addFreeInterface(FreeInterface freeInterface) throws Exception {
        if (freeInterface == null) {
            throw new IllegalArgumentException("interface cannot be null");
        }
        if (!paidInterfaces.isEmpty()) {
            throw new Exception("user has paid interface which are not compatible with free interfaces");
        }
        freeInterfaces.add(freeInterface);
    }

    public void addPaidInterface(PaidInterface paidInterface) throws Exception {
        if (paidInterface == null) {
            throw new IllegalArgumentException("interface cannot be null");
        }
        if (!freeInterfaces.isEmpty()) {
            throw new Exception("user has free interface which are not compatible with paid interfaces");
        }
        paidInterfaces.add(paidInterface);
    }

    public void removeFreeInterface(FreeInterface freeInterface) {
        if (freeInterface == null) {
            throw new IllegalArgumentException("interface cannot be null");
        }
        freeInterfaces.remove(freeInterface);
    }

    public void removePaidInterface(PaidInterface paid) {
        if (paid == null) {
            throw new IllegalArgumentException("interface cannot be null");
        }
        paidInterfaces.remove(paid);
    }

    public void clearFreeInterfaces() {
        freeInterfaces.clear();
    }

    public void clearPaidInterfaces() {
        paidInterfaces.clear();
    }
}
