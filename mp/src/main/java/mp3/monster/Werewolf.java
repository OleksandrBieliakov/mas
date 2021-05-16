package mp3.monster;

public class Werewolf extends Monster {

    private int tailLength;

    public Werewolf(String name, int bounty, int tailLength) {
        super(name, bounty);
        setTailLength(tailLength);
    }

    public int getTailLength() {
        return tailLength;
    }

    public void setTailLength(int tailLength) {
        if (tailLength < 0) {
            throw new IllegalArgumentException("tailLength cannot be negative");
        }
        this.tailLength = tailLength;
    }

    public void becomeFluffy() {
        System.out.println("Woo!");
    }

    @Override
    public String toString() {
        return super.toString() + " {" +
                "tailLength=" + tailLength +
                '}';
    }
}
