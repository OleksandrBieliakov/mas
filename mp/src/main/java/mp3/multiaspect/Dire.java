package mp3.multiaspect;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Dire extends Fraction {

    private final Set<String> learnedCurses = new HashSet<>();

    public Set<String> getLearnedCurses() {
        return Collections.unmodifiableSet(learnedCurses);
    }

    public void learnCurses(String curse) {
        if (curse == null) {
            throw new IllegalArgumentException("curse cannot be null");
        }
        if (curse.isBlank()) {
            throw new IllegalArgumentException("curse cannot be blank");
        }
        learnedCurses.add(curse);
    }

    public void useAnyCurse() {
        if (!learnedCurses.isEmpty()) {
            System.out.println(learnedCurses.stream().findAny());
        }
    }

    @Override
    public String buff() {
        return "fire";
    }
}
