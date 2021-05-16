package mp3.monster;

import org.junit.jupiter.api.Test;

class MonsterTest {

    @Test
    void test() {
        VampireImpl vampire = new VampireImpl("regular vampire", 1000);
        Werewolf werewolf = new Werewolf("regular werewolf", 2000, 100);
        Hybrid hybrid = new Hybrid("hybrid of vampire and werewolf", 3000, 120);
        System.out.println(vampire);
        vampire.suckHumanJuice();
        System.out.println(werewolf);
        werewolf.becomeFluffy();
        System.out.println(hybrid);
        vampire.suckHumanJuice();
        hybrid.becomeFluffy();
    }
}