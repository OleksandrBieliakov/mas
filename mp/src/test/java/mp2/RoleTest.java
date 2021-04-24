package mp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoleTest {

    @Test
    void addUser() {
        User user1 = new User("user1");
        User user2 = new User("user2");
        Role role1 = new Role("role1");
        assertEquals(0, role1.getUsers().size());
        assertEquals(0, user1.getRoles().size());
        assertEquals(0, user2.getRoles().size());
        role1.addUser(user1);
        role1.addUser(user2);
        assertEquals(2, role1.getUsers().size());
        assertEquals(1, user1.getRoles().size());
        assertEquals(1, user2.getRoles().size());
    }

    @Test
    void removeUser() {
        User user1 = new User("user1");
        User user2 = new User("user2");
        Role role1 = new Role("role1");
        assertEquals(0, role1.getUsers().size());
        assertEquals(0, user1.getRoles().size());
        assertEquals(0, user2.getRoles().size());
        role1.addUser(user1);
        role1.addUser(user2);
        assertEquals(2, role1.getUsers().size());
        assertEquals(1, user1.getRoles().size());
        assertEquals(1, user2.getRoles().size());
        role1.removeUser(user1);
        assertEquals(1, role1.getUsers().size());
        assertEquals(0, user1.getRoles().size());
        assertEquals(1, user2.getRoles().size());
        role1.removeUser(user2);
        assertEquals(0, role1.getUsers().size());
        assertEquals(0, user1.getRoles().size());
        assertEquals(0, user2.getRoles().size());
    }

    @Test
    void deleteUser() {
        User user1 = new User("user1");
        User user2 = new User("user2");
        Role role1 = new Role("role1");
        assertEquals(0, role1.getUsers().size());
        assertEquals(0, user1.getRoles().size());
        assertEquals(0, user2.getRoles().size());
        role1.addUser(user1);
        role1.addUser(user2);
        assertEquals(2, role1.getUsers().size());
        assertEquals(1, user1.getRoles().size());
        assertEquals(1, user2.getRoles().size());
        Role.delete(role1);
        assertEquals(0, user1.getRoles().size());
        assertEquals(0, user2.getRoles().size());
    }
}