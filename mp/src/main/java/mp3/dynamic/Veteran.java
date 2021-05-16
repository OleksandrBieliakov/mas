package mp3.dynamic;

public class Veteran extends GuildMember {

    private int moonsTillRetirement;

    public Veteran(String name, int moonsTillRetirement) {
        super(name);
        setMoonsTillRetirement(moonsTillRetirement);
    }

    public Veteran(GuildMember guildMember, int moonsTillRetirement) {
        super(guildMember.getName());
        setMoonsTillRetirement(moonsTillRetirement);
    }

    public Veteran(String name) {
        super(name);
    }

    public int getMoonsTillRetirement() {
        return moonsTillRetirement;
    }

    public void setMoonsTillRetirement(int moonsTillRetirement) {
        if (moonsTillRetirement < 0) {
            throw new IllegalArgumentException("moonsTillRetirement cannot be negative");
        }
        this.moonsTillRetirement = moonsTillRetirement;
    }

    public void wasteAnotherYear() {
        moonsTillRetirement--;
    }
}
