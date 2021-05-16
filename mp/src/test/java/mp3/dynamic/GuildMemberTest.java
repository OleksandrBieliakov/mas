package mp3.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuildMemberTest {

    @Test
    void test() {
        GuildMember member = new Rookie("Dovahkiin", 10);
        assertFalse(((Rookie) member).isReadyForPromotion());
        for (int i = 0; i < 9; i++) {
            ((Rookie) member).killRat();
        }
        assertFalse(((Rookie) member).isReadyForPromotion());
        ((Rookie) member).killRat();
        assertTrue(((Rookie) member).isReadyForPromotion());

        member = new Veteran(member, 5);
        ((Veteran) member).wasteAnotherYear();
        assertEquals(4, ((Veteran) member).getMoonsTillRetirement());

        member = new GuildMaster(member, "chill");
        assertEquals("chill", ((GuildMaster) member).getWhatToDoNext());
    }
}