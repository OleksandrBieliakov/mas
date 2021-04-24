package mp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void addRole() {
        User user1 = new User("user1");
        Role role1 = new Role("role1");
        Role role2 = new Role("role2");
        assertEquals(0, role1.getUsers().size());
        assertEquals(0, role2.getUsers().size());
        assertEquals(0, user1.getRoles().size());
        user1.addRole(role1);
        user1.addRole(role2);
        assertEquals(1, role1.getUsers().size());
        assertEquals(1, role2.getUsers().size());
        assertEquals(2, user1.getRoles().size());
    }

    @Test
    void removeRole() {
        User user1 = new User("user1");
        Role role1 = new Role("role1");
        Role role2 = new Role("role2");
        assertEquals(0, role1.getUsers().size());
        assertEquals(0, role2.getUsers().size());
        assertEquals(0, user1.getRoles().size());
        user1.addRole(role1);
        user1.addRole(role2);
        assertEquals(1, role1.getUsers().size());
        assertEquals(1, role2.getUsers().size());
        assertEquals(2, user1.getRoles().size());
        user1.removeRole(role1);
        assertEquals(0, role1.getUsers().size());
        assertEquals(1, role2.getUsers().size());
        assertEquals(1, user1.getRoles().size());
        user1.removeRole(role2);
        assertEquals(0, role1.getUsers().size());
        assertEquals(0, role2.getUsers().size());
        assertEquals(0, user1.getRoles().size());
    }

    @Test
    void deleteRole() {
        User user1 = new User("user1");
        Role role1 = new Role("role1");
        Role role2 = new Role("role2");
        assertEquals(0, role1.getUsers().size());
        assertEquals(0, role2.getUsers().size());
        assertEquals(0, user1.getRoles().size());
        user1.addRole(role1);
        user1.addRole(role2);
        assertEquals(1, role1.getUsers().size());
        assertEquals(1, role2.getUsers().size());
        assertEquals(2, user1.getRoles().size());
        User.delete(user1);
        assertEquals(0, role1.getUsers().size());
        assertEquals(0, role2.getUsers().size());
    }

    @Test
    void addTeam() {
        User user1 = new User("user1");
        Team team1 = new Team("team1");
        Team team2 = new Team("team2");
        assertEquals(0, team1.getMembers().size());
        assertEquals(0, team2.getMembers().size());
        assertEquals(0, user1.getTeams().size());
        user1.addTeam(team1);
        user1.addTeam(team2);
        assertEquals(1, team1.getMembers().size());
        assertEquals(1, team2.getMembers().size());
        assertEquals(2, user1.getTeams().size());
    }

    @Test
    void removeTeam() {
        User user1 = new User("user1");
        Team team1 = new Team("team1");
        Team team2 = new Team("team2");
        assertEquals(0, team1.getMembers().size());
        assertEquals(0, team2.getMembers().size());
        assertEquals(0, user1.getTeams().size());
        user1.addTeam(team1);
        user1.addTeam(team2);
        assertEquals(1, team1.getMembers().size());
        assertEquals(1, team2.getMembers().size());
        assertEquals(2, user1.getTeams().size());
        user1.removeTeam(team1);
        assertEquals(0, team1.getMembers().size());
        assertEquals(1, team2.getMembers().size());
        assertEquals(1, user1.getTeams().size());
        user1.removeTeam(team2);
        assertEquals(0, team1.getMembers().size());
        assertEquals(0, team2.getMembers().size());
        assertEquals(0, user1.getTeams().size());
    }

    @Test
    void teamByName() {
        User user1 = new User("user1");
        Team team1 = new Team("team1");
        Team team2 = new Team("team2");
        user1.addTeam(team1);
        user1.addTeam(team2);
        assertEquals("team1", user1.teamByName("team1").get().getName());
        assertEquals("team2", user1.teamByName("team2").get().getName());
        assertFalse(user1.teamByName("no such team").isPresent());
    }

    @Test
    void deleteTeam() {
        User user1 = new User("user1");
        Team team1 = new Team("team1");
        Team team2 = new Team("team2");
        assertEquals(0, team1.getMembers().size());
        assertEquals(0, team2.getMembers().size());
        assertEquals(0, user1.getTeams().size());
        user1.addTeam(team1);
        user1.addTeam(team2);
        assertEquals(1, team1.getMembers().size());
        assertEquals(1, team2.getMembers().size());
        assertEquals(2, user1.getTeams().size());
        User.delete(user1);
        assertEquals(0, team1.getMembers().size());
        assertEquals(0, team2.getMembers().size());
    }

    @Test
    void addAssignment() {
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
    }

    @Test
    void removeTaskAssignedBy() {
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

        user1.removeTaskAssignedBy(assignment1);

        assertEquals(1, task1.getAssignments().size());
        assertEquals(1, user1.getTasksAssignedBy().size());
        assertEquals(1, user1.getTasksAssignedTo().size());
        assertEquals(0, user2.getTasksAssignedBy().size());
        assertEquals(0, user2.getTasksAssignedTo().size());
        assertFalse(Assignment.getExtent().contains(assignment1));
        assertTrue(Assignment.getExtent().contains(assignment2));

        user1.removeTaskAssignedBy(assignment2);

        assertEquals(0, task1.getAssignments().size());
        assertEquals(0, user1.getTasksAssignedBy().size());
        assertEquals(0, user1.getTasksAssignedTo().size());
        assertEquals(0, user2.getTasksAssignedBy().size());
        assertEquals(0, user2.getTasksAssignedTo().size());
        assertFalse(Assignment.getExtent().contains(assignment1));
        assertFalse(Assignment.getExtent().contains(assignment2));
    }

    @Test
    void removeTaskAssignedTo() {
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

        user1.removeTaskAssignedTo(assignment1);

        assertEquals(2, task1.getAssignments().size());
        assertEquals(2, user1.getTasksAssignedBy().size());
        assertEquals(1, user1.getTasksAssignedTo().size());
        assertEquals(0, user2.getTasksAssignedBy().size());
        assertEquals(1, user2.getTasksAssignedTo().size());
        assertTrue(Assignment.getExtent().contains(assignment1));
        assertTrue(Assignment.getExtent().contains(assignment2));

        user1.removeTaskAssignedTo(assignment2);

        assertEquals(1, task1.getAssignments().size());
        assertEquals(1, user1.getTasksAssignedBy().size());
        assertEquals(0, user1.getTasksAssignedTo().size());
        assertEquals(0, user2.getTasksAssignedBy().size());
        assertEquals(1, user2.getTasksAssignedTo().size());
        assertTrue(Assignment.getExtent().contains(assignment1));
        assertFalse(Assignment.getExtent().contains(assignment2));

        user2.removeTaskAssignedTo(assignment1);

        assertEquals(0, task1.getAssignments().size());
        assertEquals(0, user1.getTasksAssignedBy().size());
        assertEquals(0, user1.getTasksAssignedTo().size());
        assertEquals(0, user2.getTasksAssignedBy().size());
        assertEquals(0, user2.getTasksAssignedTo().size());
        assertFalse(Assignment.getExtent().contains(assignment1));
        assertFalse(Assignment.getExtent().contains(assignment2));
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

        User.delete(user1);
        assertEquals(0, task1.getAssignments().size());
        assertEquals(0, user1.getTasksAssignedBy().size());
        assertEquals(0, user1.getTasksAssignedTo().size());
        assertEquals(0, user2.getTasksAssignedBy().size());
        assertEquals(0, user2.getTasksAssignedTo().size());
        assertFalse(Assignment.getExtent().contains(assignment1));
        assertFalse(Assignment.getExtent().contains(assignment2));
    }
}