package mp4.custom;

public enum Education {

    NONE(8),
    BACHELOR(5),
    MASTER(3),
    PHD(1);

    private final int minYearsOfExperience;

    Education(int minYearsOfExperience) {
        this.minYearsOfExperience = minYearsOfExperience;
    }

    public int getMinYearsOfExperience() {
        return minYearsOfExperience;
    }
}
