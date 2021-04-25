package mp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    void addMember() {
        Team team1 = new Team("team1");
        User user1 = new User("user1");
        User user2 = new User("user2");
        assertEquals(0, team1.getMembers().size());
        assertEquals(0, user1.getTeams().size());
        assertEquals(0, user2.getTeams().size());
        team1.addMember(user1);
        team1.addMember(user2);
        assertEquals(2, team1.getMembers().size());
        assertEquals(1, user1.getTeams().size());
        assertEquals(1, user2.getTeams().size());
    }

    @Test
    void removeMember() {
        Team team1 = new Team("team1");
        User user1 = new User("user1");
        User user2 = new User("user2");
        assertEquals(0, team1.getMembers().size());
        assertEquals(0, user1.getTeams().size());
        assertEquals(0, user2.getTeams().size());
        team1.addMember(user1);
        team1.addMember(user2);
        assertEquals(2, team1.getMembers().size());
        assertEquals(1, user1.getTeams().size());
        assertEquals(1, user2.getTeams().size());
        team1.removeMember(user1);
        assertEquals(1, team1.getMembers().size());
        assertEquals(0, user1.getTeams().size());
        assertEquals(1, user2.getTeams().size());
        team1.removeMember(user2);
        assertEquals(0, team1.getMembers().size());
        assertEquals(0, user1.getTeams().size());
        assertEquals(0, user2.getTeams().size());
    }

    @Test
    void deleteMember() {
        Team team1 = new Team("team1");
        User user1 = new User("user1");
        User user2 = new User("user2");
        assertEquals(0, team1.getMembers().size());
        assertEquals(0, user1.getTeams().size());
        assertEquals(0, user2.getTeams().size());
        team1.addMember(user1);
        team1.addMember(user2);
        assertEquals(2, team1.getMembers().size());
        assertEquals(1, user1.getTeams().size());
        assertEquals(1, user2.getTeams().size());
        Team.delete(team1);
        assertEquals(0, user1.getTeams().size());
        assertEquals(0, user2.getTeams().size());
    }

    @Test
    void addTask() {
        Team team1 = new Team("team1");
        assertEquals(0, team1.getTasks().size());
        Task task1 = new Task("task1", team1);
        assertEquals(1, team1.getTasks().size());
        Task task2 = new Task("task2", team1);
        assertEquals(2, team1.getTasks().size());
    }

    @Test
    void removeTask() {
        Team team1 = new Team("team1");
        assertEquals(0, team1.getTasks().size());
        Task task1 = new Task("task1", team1);
        assertEquals(1, team1.getTasks().size());
        Task task2 = new Task("task2", team1);
        assertEquals(2, team1.getTasks().size());

        assertTrue(Task.getExtent().contains(task1));
        assertTrue(Task.getExtent().contains(task2));

        team1.removeTask(task1);
        assertEquals(1, team1.getTasks().size());
        assertFalse(Task.getExtent().contains(task1));
        assertTrue(Task.getExtent().contains(task2));

        team1.removeTask(task2);
        assertEquals(0, team1.getTasks().size());
        assertFalse(Task.getExtent().contains(task1));
        assertFalse(Task.getExtent().contains(task2));
    }

    @Test
    void deleteTask() {
        Team team1 = new Team("team1");
        assertEquals(0, team1.getTasks().size());
        Task task1 = new Task("task1", team1);
        assertEquals(1, team1.getTasks().size());
        Task task2 = new Task("task2", team1);
        assertEquals(2, team1.getTasks().size());

        assertTrue(Task.getExtent().contains(task1));
        assertTrue(Task.getExtent().contains(task2));

        Team.delete(team1);
        assertFalse(Task.getExtent().contains(task1));
        assertFalse(Task.getExtent().contains(task2));
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

        Team.delete(team1);
        assertEquals(0, user1.getTasksAssignedBy().size());
        assertEquals(0, user1.getTasksAssignedTo().size());
        assertEquals(0, user2.getTasksAssignedBy().size());
        assertEquals(0, user2.getTasksAssignedTo().size());
        assertFalse(Task.getExtent().contains(task1));
        assertFalse(Assignment.getExtent().contains(assignment1));
        assertFalse(Assignment.getExtent().contains(assignment2));
    }
}