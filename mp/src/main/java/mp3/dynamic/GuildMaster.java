package mp3.dynamic;

public class GuildMaster extends GuildMember {

    private String whatToDoNext;

    public GuildMaster(String name, String whatToDoNext) {
        super(name);
        setWhatToDoNext(whatToDoNext);
    }

    public GuildMaster(GuildMember guildMember, String whatToDoNext) {
        super(guildMember.getName());
        setWhatToDoNext(whatToDoNext);
    }

    public String getWhatToDoNext() {
        return whatToDoNext;
    }

    public void setWhatToDoNext(String whatToDoNext) {
        if (whatToDoNext == null) {
            throw new IllegalArgumentException("whatToDoNext cannot be null");
        }
        if (whatToDoNext.isBlank()) {
            throw new IllegalArgumentException("whatToDoNext cannot be blank");
        }
        this.whatToDoNext = whatToDoNext;
    }
}
