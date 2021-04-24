package mp2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Assignment {

    private static final Set<Assignment> extent = new HashSet<>();

    // with an attribute (User - User - Task)
    // composition EXAMPLE 2 (Assignment cannot exist without Team or one of Users)
    private Task task;
    private User assignedBy;
    private User assignedTo;
    private String additionalNotes;

    public Assignment(Task task, User assignedBy, User assignedTo) {
        validate(task, assignedTo);
        setTask(task);
        setAssignedBy(assignedBy);
        setAssignedTo(assignedTo);
        task.addAssignment(this);
        assignedBy.addTaskAssignedBy(this);
        assignedTo.addTaskAssignedTo(this);
        extent.add(this);
    }

    public Assignment(Task task, User assignedBy, User assignedTo, String additionalNotes) {
        this(task, assignedBy, assignedTo);
        setAdditionalNotes(additionalNotes);
    }

    public Task getTask() {
        return task;
    }

    private void setTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task must not be null");
        }
        this.task = task;
    }

    public User getAssignedBy() {
        return assignedBy;
    }

    private void setAssignedBy(User assignedBy) {
        if (assignedBy == null) {
            throw new IllegalArgumentException("User must not be null");
        }
        this.assignedBy = assignedBy;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    private void setAssignedTo(User assignedTo) {
        if (assignedTo == null) {
            throw new IllegalArgumentException("User must not be null");
        }
        this.assignedTo = assignedTo;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    private void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public static Set<Assignment> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    private static void validate(Task task, User assignedTo) {
        if (extent.stream().anyMatch(assignment ->
                assignment.getTask().equals(task) && assignment.getAssignedTo().equals(assignedTo))) {
            throw new IllegalArgumentException("User can be assigned to Task only once");
        }
    }

    public static void delete(Assignment assignment) {
        if (assignment == null) {
            throw new IllegalArgumentException("Assignment must not be null");
        }
        assignment.task.removeAssignment(assignment);
        assignment.assignedBy.removeTaskAssignedBy(assignment);
        assignment.assignedTo.removeTaskAssignedTo(assignment);
        extent.remove(assignment);
    }
}
