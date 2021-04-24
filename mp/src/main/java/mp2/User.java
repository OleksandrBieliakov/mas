package mp2;

import java.util.*;

public class User {

    private static final Set<User> extent = new HashSet<>();

    private String name;

    // 'basic'
    private final Set<Role> roles = new HashSet<>();

    // with qualifier on the side of User (team by name)
    private final Map<String, Team> teams = new HashMap<>();

    // with an attribute (User - User - Task)
    // composition EXAMPLE 2 (Assignment cannot exist without Team or one of Users)
    private final Set<Assignment> tasksAssignedBy = new HashSet<>();
    private final Set<Assignment> tasksAssignedTo = new HashSet<>();

    public User(String name) {
        setName(name);
        extent.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("User name must not be null");
        }
        this.name = name;
    }

    public Set<Role> getRoles() {
        return Collections.unmodifiableSet(roles);
    }

    public void addRole(Role role) {
        if (role == null) {
            throw new IllegalArgumentException("Role must not be null");
        }
        if (roles.contains(role)) {
            return;
        }
        roles.add(role);
        role.addUser(this);
    }

    public void removeRole(Role role) {
        if (role == null) {
            throw new IllegalArgumentException("Role must not be null");
        }
        if (!roles.contains(role)) {
            return;
        }
        roles.remove(role);
        role.removeUser(this);
    }

    public Map<String, Team> getTeams() {
        return Collections.unmodifiableMap(teams);
    }

    public void addTeam(Team team) {
        if (team == null) {
            throw new IllegalArgumentException("Team must not be null");
        }
        if (teams.containsKey(team.getName())) {
            return;
        }
        teams.put(team.getName(), team);
        team.addMember(this);
    }

    public void removeTeam(Team team) {
        if (team == null) {
            throw new IllegalArgumentException("Team must not be null");
        }
        if (!teams.containsKey(team.getName())) {
            return;
        }
        teams.remove(team.getName());
        team.removeMember(this);
    }

    public Optional<Team> teamByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Team name must not be null");
        }
        return Optional.ofNullable(teams.get(name));
    }

    public Set<Assignment> getTasksAssignedBy() {
        return Collections.unmodifiableSet(tasksAssignedBy);
    }

    public Set<Assignment> getTasksAssignedTo() {
        return Collections.unmodifiableSet(tasksAssignedTo);
    }

    public void addTaskAssignedBy(Assignment assignment) {
        if (assignment == null) {
            throw new IllegalArgumentException("Assignment must not be null");
        }
        if (tasksAssignedBy.contains(assignment)) {
            return;
        }
        tasksAssignedBy.add(assignment);
    }

    public void removeTaskAssignedBy(Assignment assignment) {
        if (assignment == null) {
            throw new IllegalArgumentException("Assignment must not be null");
        }
        if (!tasksAssignedBy.contains(assignment)) {
            return;
        }
        tasksAssignedBy.remove(assignment);
        Assignment.delete(assignment);
    }

    public void addTaskAssignedTo(Assignment assignment) {
        if (assignment == null) {
            throw new IllegalArgumentException("Assignment must not be null");
        }
        if (tasksAssignedTo.contains(assignment)) {
            return;
        }
        tasksAssignedTo.add(assignment);
    }

    public void removeTaskAssignedTo(Assignment assignment) {
        if (assignment == null) {
            throw new IllegalArgumentException("Assignment must not be null");
        }
        if (!tasksAssignedTo.contains(assignment)) {
            return;
        }
        tasksAssignedTo.remove(assignment);
        Assignment.delete(assignment);
    }

    public static Set<User> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    public static void delete(User user) {
        Set<Assignment> tasksAssignedByTmp = Set.copyOf(user.tasksAssignedBy);
        user.tasksAssignedBy.clear();
        tasksAssignedByTmp.forEach(Assignment::delete);

        Set<Assignment> tasksAssignedToTmp = Set.copyOf(user.tasksAssignedTo);
        user.tasksAssignedTo.clear();
        tasksAssignedToTmp.forEach(Assignment::delete);

        Map<String, Team> teamsTmp = Map.copyOf(user.teams);
        user.teams.clear();
        teamsTmp.forEach((s, team) -> team.removeMember(user));

        Set<Role> rolesTmp = Set.copyOf(user.roles);
        user.roles.clear();
        rolesTmp.forEach(role -> role.removeUser(user));

        extent.remove(user);
    }
}
