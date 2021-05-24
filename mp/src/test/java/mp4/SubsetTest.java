package mp4;

import mp4.subset.Member;
import mp4.subset.Team;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubsetTest {

    @Test
    void test() {
        Member member1 = new Member("m1");
        Member member2 = new Member("m2");
        Team team = new Team("t1");
        team.addMember(member1);
        team.setTeamLead(member1);
        assertEquals(member1, team.getTeamLead());
        assertThrows(IllegalArgumentException.class, () -> team.setTeamLead(member2));
    }
}
