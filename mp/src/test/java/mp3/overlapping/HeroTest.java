package mp3.overlapping;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeroTest {

    @Test
    void performBestCombo() {
        Hero berserk = new Hero("berserk",
                Set.of(HeroClass.BERSERK));
        Hero berserkMage = new Hero("berserk-mage",
                Set.of(HeroClass.BERSERK, HeroClass.MAGE));
        Hero berserkMageRanger = new Hero("berserk-mage-ranger",
                Set.of(HeroClass.BERSERK, HeroClass.MAGE, HeroClass.RANGER));

        assertEquals(100, berserk.getRage());
        assertEquals(0, berserk.getMana());
        assertEquals(0, berserk.getArrows());
        berserk.performBestCombo();
        assertEquals(90, berserk.getRage());
        assertEquals(0, berserk.getMana());
        assertEquals(0, berserk.getArrows());

        System.out.println();

        assertEquals(100, berserkMage.getRage());
        assertEquals(100, berserkMage.getMana());
        assertEquals(0, berserkMage.getArrows());
        berserkMage.performBestCombo();
        assertEquals(90, berserkMage.getRage());
        assertEquals(90, berserkMage.getMana());
        assertEquals(0, berserkMage.getArrows());

        System.out.println();

        assertEquals(100, berserkMageRanger.getRage());
        assertEquals(100, berserkMageRanger.getMana());
        assertEquals(10, berserkMageRanger.getArrows());
        berserkMageRanger.performBestCombo();
        assertEquals(90, berserkMageRanger.getRage());
        assertEquals(90, berserkMageRanger.getMana());
        assertEquals(9, berserkMageRanger.getArrows());
    }
}