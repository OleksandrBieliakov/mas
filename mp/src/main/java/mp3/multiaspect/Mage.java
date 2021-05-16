package mp3.multiaspect;

public class Mage extends Hero {

    private int mana = 100;

    public Mage(String name, Fraction fraction) {
        super(name, fraction);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    String attack() throws Exception {
        if (mana < 10) {
            throw new Exception("no enough mana");
        }
        mana -= 10;
        return "fireball";
    }
}
