package mp2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Team {

    private static final Set<Team> extent = new HashSet<>();

    private String name;

    // with qualifier on the side of User (team by name)
    private final Set<User> members = new HashSet<>();

    // composition EXAMPLE 1 (Task cannot exist without Team)
    private final Set<Task> tasks = new HashSet<>();

    public Team(String name) {
        setName(name);
        extent.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Team name must not be null");
        }
        this.name = name;
    }

    public Set<User> getMembers() {
        return Collections.unmodifiableSet(members);
    }

    public void addMember(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User must not be null");
        }
        if (members.contains(user)) {
            return;
        }
        members.add(user);
        user.addTeam(this);
    }

    public void removeMember(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User must not be null");
        }
        if (!members.contains(user)) {
            return;
        }
        members.remove(user);
        user.removeTeam(this);
    }

    public Set<Task> getTasks() {
        return Collections.unmodifiableSet(tasks);
    }

    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task must not be null");
        }
        if (tasks.contains(task)) {
            return;
        }
        tasks.add(task);
    }

    public void removeTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task must not be null");
        }
        if (!tasks.contains(task)) {
            return;
        }
        tasks.remove(task);
        Task.delete(task);
    }

    public static Set<Team> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    public static void delete(Team team) {
        Set<Task> tasksTmp = Set.copyOf(team.tasks);
        team.tasks.clear();
        tasksTmp.forEach(Task::delete);

        Set<User> membersTmp = Set.copyOf(team.members);
        team.members.clear();
        membersTmp.forEach(user -> user.removeTeam(team));

        extent.remove(team);
    }
}
