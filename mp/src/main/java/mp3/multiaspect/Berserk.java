package mp3.multiaspect;

public class Berserk extends Hero {

    private int rage = 100;

    public Berserk(String name, Fraction fraction) {
        super(name, fraction);
    }

    public int getRage() {
        return rage;
    }

    public void setRage(int rage) {
        this.rage = rage;
    }

    @Override
    String attack() throws Exception {
        if (rage < 10) {
            throw new Exception("no enough rage");
        }
        rage -= 10;
        return "charge";
    }
}
