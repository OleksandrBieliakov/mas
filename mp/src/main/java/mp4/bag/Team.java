package mp4.bag;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Team {

    private String name;

    public final Set<Membership> memberships = new HashSet<>();

    public Team(String name) {
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

    public Set<Membership> getMemberships() {
        return Collections.unmodifiableSet(memberships);
    }

    public void addMembership(Membership membership) {
        if (name == null) {
            throw new IllegalArgumentException("membership cannot be null");
        }
        if (memberships.contains(membership)) {
            return;
        }
        memberships.add(membership);
    }

    public void removeMembership(Membership membership) {
        if (name == null) {
            throw new IllegalArgumentException("membership cannot be null");
        }
        if (!memberships.contains(membership)) {
            return;
        }
        memberships.remove(membership);
    }
}
