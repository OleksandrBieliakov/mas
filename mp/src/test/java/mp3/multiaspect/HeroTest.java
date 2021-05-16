package mp3.multiaspect;

import org.junit.jupiter.api.Test;

import java.util.List;

class HeroTest {

    @Test
    void attackWithFractionBuff() {
        Fraction dire = new Dire();
        Fraction radiant = new Radiant();
        Hero direBerserk = new Berserk("dire Berserk", dire);
        Hero direMage = new Mage("dire Mage", dire);
        Hero direRanger = new Ranger("dire Ranger", dire);
        Hero radiantBerserk = new Berserk("radiant Berserk", radiant);
        Hero radiantMage = new Mage("radiant Mage", radiant);
        Hero radiantRanger = new Ranger("radiant Ranger", radiant);
        List<Hero> heroes = List.of(direBerserk, direMage, direRanger, radiantBerserk, radiantMage, radiantRanger);
        heroes.forEach(hero -> {
            try {
                System.out.println(hero.getName() + " " + hero.attackWithFractionBuff());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}