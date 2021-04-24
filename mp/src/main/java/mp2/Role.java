package mp2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Role {

    private static final Set<Role> extent = new HashSet<>();

    private String name;

    // 'basic'
    private final Set<User> users = new HashSet<>();

    public Role(String name) {
        setName(name);
        extent.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Role name must not be null");
        }
        this.name = name;
    }

    public Set<User> getUsers() {
        return Collections.unmodifiableSet(users);
    }

    public void addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User must not be null");
        }
        if (users.contains(user)) {
            return;
        }
        users.add(user);
        user.addRole(this);
    }

    public void removeUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User must not be null");
        }
        if (!users.contains(user)) {
            return;
        }
        users.remove(user);
        user.removeRole(this);
    }

    public static Set<Role> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    public static void delete(Role role) {
        if (role == null) {
            throw new IllegalArgumentException("Role must not be null");
        }

        Set<User> usersTmp = Set.copyOf(role.users);
        role.users.clear();
        usersTmp.forEach(user -> user.removeRole(role));

        extent.remove(role);
    }
}
