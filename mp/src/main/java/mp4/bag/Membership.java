package mp4.bag;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Membership {

    private static final Set<Membership> extent = new HashSet<>();

    private Team team;
    private Member member;

    private ZonedDateTime from;
    private ZonedDateTime to;

    public Membership(Team team, Member member) {
        validate(team, member);
        setTeam(team);
        setMember(member);
        setFrom(ZonedDateTime.now());
        team.addMembership(this);
        member.addMembership(this);
        extent.add(this);
    }

    public static void validate(Team validatedTeam, Member validatedMember) {
        if (extent.stream().anyMatch(membership ->
                membership.team.equals(validatedTeam)
                        && membership.member.equals(validatedMember)
                        && membership.to == null)) {
            throw new IllegalArgumentException("Active membership of member in team exists");
        }
    }

    public Team getTeam() {
        return team;
    }

    private void setTeam(Team team) {
        if (team == null) {
            throw new IllegalArgumentException("team cannot be null");
        }
        this.team = team;
    }

    public Member getMember() {
        return member;
    }

    private void setMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("member cannot be null");
        }
        this.member = member;
    }

    public ZonedDateTime getFrom() {
        return from;
    }

    private void setFrom(ZonedDateTime from) {
        if (from == null) {
            throw new IllegalArgumentException("from cannot be null");
        }
        this.from = from;
    }

    public ZonedDateTime getTo() {
        return to;
    }

    private void setTo(ZonedDateTime to) {
        if (to != null && from.compareTo(to) > 0) {
            throw new IllegalArgumentException("to cannot be before from");
        }
        this.to = to;
    }

    public void leave() {
        setTo(ZonedDateTime.now());
    }

    public static Set<Membership> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    public static void delete(Membership membership) {
        if (membership == null) {
            throw new IllegalArgumentException("membership must not be null");
        }
        membership.team.removeMembership(membership);
        membership.member.removeMembership(membership);
        extent.remove(membership);
    }
}
