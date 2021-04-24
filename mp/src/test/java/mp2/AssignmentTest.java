package mp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AssignmentTest {

    @Test
    void create() {
        Team team1 = new Team("team1");
        Task task1 = new Task("task1", team1);
        User user1 = new User("user1");
        User user2 = new User("user2");

        assertEquals(0, task1.getAssignments().size());
        assertEquals(0, user1.getTasksAssignedBy().size());
        assertEquals(0, user1.getTasksAssignedTo().size());
        assertEquals(0, user2.getTasksAssignedBy().size());
        assertEquals(0, user2.getTasksAssignedTo().size());

        Assignment assignment1 = new Assignment(task1, user1, user2);

        assertEquals(1, task1.getAssignments().size());
        assertEquals(1, user1.getTasksAssignedBy().size());
        assertEquals(0, user1.getTasksAssignedTo().size());
        assertEquals(0, user2.getTasksAssignedBy().size());
        assertEquals(1, user2.getTasksAssignedTo().size());

        Assignment assignment2 = new Assignment(task1, user1, user1);

        assertEquals(2, task1.getAssignments().size());
        assertEquals(2, user1.getTasksAssignedBy().size());
        assertEquals(1, user1.getTasksAssignedTo().size());
        assertEquals(0, user2.getTasksAssignedBy().size());
        assertEquals(1, user2.getTasksAssignedTo().size());

        assertThrows(IllegalArgumentException.class, () -> new Assignment(task1, user1, user2));
        assertThrows(IllegalArgumentException.class, () -> new Assignment(task1, user2, user2));
        assertThrows(IllegalArgumentException.class, () -> new Assignment(task1, user1, user1));
        assertThrows(IllegalArgumentException.class, () -> new Assignment(task1, user2, user2));

        assertEquals(2, task1.getAssignments().size());
        assertEquals(2, user1.getTasksAssignedBy().size());
        assertEquals(1, user1.getTasksAssignedTo().size());
        assertEquals(0, user2.getTasksAssignedBy().size());
        assertEquals(1, user2.getTasksAssignedTo().size());
    }

    @Test
    void delete() {
        Team team1 = new Team("team1");
        Task task1 = new Task("task1", team1);
        User user1 = new User("user1");
        User user2 = new User("user2");

        Assignment assignment1 = new Assignment(task1, user1, user2);

        assertEquals(1, task1.getAssignments().size());
        assertEquals(1, user1.getTasksAssignedBy().size());
        assertEquals(0, user1.getTasksAssignedTo().size());
        assertEquals(0, user2.getTasksAssignedBy().size());
        assertEquals(1, user2.getTasksAssignedTo().size());

        Assignment.delete(assignment1);
        assertEquals(0, user1.getTasksAssignedBy().size());
        assertEquals(0, user1.getTasksAssignedTo().size());
        assertEquals(0, user2.getTasksAssignedBy().size());
        assertEquals(0, user2.getTasksAssignedTo().size());
    }
}