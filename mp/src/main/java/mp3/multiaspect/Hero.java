package mp3.multiaspect;

abstract public class Hero {

    private String name;

    private Fraction fraction;

    public Hero(String name, Fraction fraction) {
        setName(name);
        setFraction(fraction);
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

    public Fraction getFraction() {
        return fraction;
    }

    public void setFraction(Fraction fraction) {
        if (fraction == null) {
            throw new IllegalArgumentException("fraction cannot be null");
        }
        this.fraction = fraction;
    }

    abstract String attack() throws Exception;

    public String attackWithFractionBuff() throws Exception {
        return attack() + " with " + fraction.buff();
    }
}
