package mp4.unique;

public class Citizen {

    private String name;

    public Citizen(String name) {
        setName(name);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Citizen)) return false;

        Citizen citizen = (Citizen) o;

        return getName().equals(citizen.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
