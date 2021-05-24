package mp4;

import mp4.bag.Member;
import mp4.bag.Membership;
import mp4.bag.Team;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BagTest {

    @Test
    void test() {
        Member member = new Member("m1");
        Team team = new Team("t1");
        Membership membership1 = new Membership(team, member);
        Membership membership2 = new Membership(team, member);
        assertEquals(2, Membership.getExtent().size());
        membership1.leave();
        assertEquals(2, Membership.getExtent().size());
        Membership.delete(membership1);
        assertEquals(1, Membership.getExtent().size());
        assertTrue(Membership.getExtent().contains(membership2));
    }
}
