package mp3.multiaspect;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Radiant extends Fraction {

    private final Set<String> learnedBlessings = new HashSet<>();

    public Set<String> getLearnedBlessings() {
        return Collections.unmodifiableSet(learnedBlessings);
    }

    public void learnBlessing(String blessing) {
        if (blessing == null) {
            throw new IllegalArgumentException("blessing cannot be null");
        }
        if (blessing.isBlank()) {
            throw new IllegalArgumentException("blessing cannot be blank");
        }
        learnedBlessings.add(blessing);
    }

    public void useAnyBlessing() {
        if (!learnedBlessings.isEmpty()) {
            System.out.println(learnedBlessings.stream().findAny());
        }
    }

    @Override
    public String buff() {
        return "light";
    }
}
