package mp3.dynamic;

public class Rookie extends GuildMember {

    private int ratsToKill;
    private boolean readyForPromotion = false;

    public Rookie(String name, int ratsToKill) {
        super(name);
        setRatsToKill(ratsToKill);
    }

    public Rookie(GuildMember guildMember, int ratsToKill) {
        super(guildMember.getName());
        setRatsToKill(ratsToKill);
    }

    public int getRatsToKill() {
        return ratsToKill;
    }

    public void setRatsToKill(int ratsToKill) {
        if (ratsToKill < 0) {
            throw new IllegalArgumentException("ratsToKill cannot be negative");
        }
        this.ratsToKill = ratsToKill;
        if (ratsToKill == 0) {
            readyForPromotion = true;
        }
    }

    public boolean isReadyForPromotion() {
        return readyForPromotion;
    }


    public void killRat() {
        ratsToKill--;
        if (ratsToKill <= 0) {
            readyForPromotion = true;
        }
    }
}
