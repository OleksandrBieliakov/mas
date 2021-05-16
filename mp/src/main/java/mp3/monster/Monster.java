package mp3.monster;

abstract public class Monster {

    private String name;

    private int bounty;

    public Monster(String name, int bounty) {
        setName(name);
        setBounty(bounty);
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

    public int getBounty() {
        return bounty;
    }

    public void setBounty(int bounty) {
        if (bounty < 0) {
            throw new IllegalArgumentException("bounty cannot be negative");
        }
        this.bounty = bounty;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", bounty=" + bounty +
                '}';
    }
}
