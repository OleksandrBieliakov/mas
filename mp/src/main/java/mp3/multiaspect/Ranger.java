package mp3.multiaspect;

public class Ranger extends Hero {

    private int arrows = 10;

    public int getArrows() {
        return arrows;
    }

    public void setArrows(int arrows) {
        this.arrows = arrows;
    }

    public Ranger(String name, Fraction fraction) {
        super(name, fraction);
    }

    @Override
    String attack() throws Exception {
        if (arrows < 1) {
            throw new Exception("out of arrows");
        }
        arrows--;
        return "bow shot";
    }
}
