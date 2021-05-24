package mp4.subset;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Team {

    private String name;
    private final Set<Member> members = new HashSet<>();
    private Member teamLead;

    public Team(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        this.name = name;
    }

    public Set<Member> getMembers() {
        return Collections.unmodifiableSet(members);
    }

    public Member getTeamLead() {
        return teamLead;
    }

    public void setTeamLead(Member teamLead) {
        if (teamLead != null && !members.contains(teamLead)) {
            throw new IllegalArgumentException("team lead must be a member of team");
        }
        this.teamLead = teamLead;
    }

    public void addMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("member cannot be null");
        }
        if (members.contains(member)) {
            throw new IllegalArgumentException("is already a member");
        }
        members.add(member);
    }

    public void removeMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("member cannot be null");
        }
        if (!members.contains(member)) {
            throw new IllegalArgumentException("is not a member");
        }
        if (member.equals(teamLead)) {
            teamLead = null;
        }
        members.remove(member);
    }
}
