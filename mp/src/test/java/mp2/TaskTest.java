package mp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void create() {
        Team team1 = new Team("team1");
        assertEquals(0, team1.getTasks().size());
        Task task1 = new Task("task1", team1);
        assertEquals(1, team1.getTasks().size());
    }

    @Test
    void deleteTeam() {
        Team team1 = new Team("team1");
        assertEquals(0, team1.getTasks().size());
        Task task1 = new Task("task1", team1);
        assertEquals(1, team1.getTasks().size());
        Task.delete(task1);
        assertEquals(0, team1.getTasks().size());
    }

    @Test
    void addAssignment() {
        Team team1 = new Team("team1");
        Task task1 = new Task("task1", team1);
        User user1 = new User("user1");
        User user2 = new User("user2");

        assertEquals(0, task1.getAssignments().size());
        Assignment assignment1 = new Assignment(task1, user1, user2);
        assertEquals(1, task1.getAssignments().size());
    }

    @Test
    void removeAssignment() {
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
        assertTrue(Assignment.getExtent().contains(assignment1));

        task1.removeAssignment(assignment1);
        assertEquals(0, task1.getAssignments().size());
        assertEquals(0, user1.getTasksAssignedBy().size());
        assertEquals(0, user1.getTasksAssignedTo().size());
        assertEquals(0, user2.getTasksAssignedBy().size());
        assertEquals(0, user2.getTasksAssignedTo().size());
        assertFalse(Assignment.getExtent().contains(assignment1));
    }

    @Test
    void deleteAssignment() {
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
        assertTrue(Assignment.getExtent().contains(assignment1));

        Assignment assignment2 = new Assignment(task1, user1, user1);

        assertEquals(2, task1.getAssignments().size());
        assertEquals(2, user1.getTasksAssignedBy().size());
        assertEquals(1, user1.getTasksAssignedTo().size());
        assertEquals(0, user2.getTasksAssignedBy().size());
        assertEquals(1, user2.getTasksAssignedTo().size());
        assertTrue(Assignment.getExtent().contains(assignment2));

        Task.delete(task1);

        assertEquals(0, user1.getTasksAssignedBy().size());
        assertEquals(0, user1.getTasksAssignedTo().size());
        assertEquals(0, user2.getTasksAssignedBy().size());
        assertEquals(0, user2.getTasksAssignedTo().size());
        assertFalse(Assignment.getExtent().contains(assignment1));
        assertFalse(Assignment.getExtent().contains(assignment2));
    }
}