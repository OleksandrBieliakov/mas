package mp2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Task {

    private static final Set<Task> extent = new HashSet<>();

    private String name;

    // composition EXAMPLE 1 (Task cannot exist without Team)
    private Team team;

    // with an attribute (User - User - Task)
    // composition EXAMPLE 2 (Assignment cannot exist without Team or one of Users)
    private final Set<Assignment> assignments = new HashSet<>();

    public Task(String name, Team team) {
        setName(name);
        setTeam(team);
        team.addTask(this);
        extent.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Task name must not be null");
        }
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    private void setTeam(Team team) {
        if (team == null) {
            throw new IllegalArgumentException("Team must not be null");
        }
        this.team = team;
    }

    public Set<Assignment> getAssignments() {
        return Collections.unmodifiableSet(assignments);
    }

    public void addAssignment(Assignment assignment) {
        if (assignment == null) {
            throw new IllegalArgumentException("Assignment must not be null");
        }
        if (assignments.contains(assignment)) {
            return;
        }
        assignments.add(assignment);
    }

    public void removeAssignment(Assignment assignment) {
        if (assignment == null) {
            throw new IllegalArgumentException("Assignment must not be null");
        }
        if (!assignments.contains(assignment)) {
            return;
        }
        assignments.remove(assignment);
        Assignment.delete(assignment);
    }

    public static Set<Task> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    public static void delete(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task must not be null");
        }

        Set<Assignment> assignmentsTmp = Set.copyOf(task.assignments);
        task.assignments.clear();
        assignmentsTmp.forEach(Assignment::delete);

        task.team.removeTask(task);
        extent.remove(task);
    }
}
