package mp3.overlapping;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Hero {

    private String name;

    private final Set<HeroClass> classes = new HashSet<>();

    private int rage;
    private int mana;
    private int arrows;

    public Hero(String name, Set<HeroClass> classes) {
        setName(name);
        addClasses(classes);
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

    public Set<HeroClass> getClasses() {
        return Collections.unmodifiableSet(classes);
    }

    public void addClasses(Set<HeroClass> classes) {
        if (classes == null) {
            throw new IllegalArgumentException("classes set cannot be null");
        }
        if (this.classes.size() == 0 && classes.size() == 0) {
            throw new IllegalArgumentException("hero must have at least one class");
        }
        for (HeroClass heroClass : classes) {
            addClass(heroClass);
        }
    }

    public void addClass(HeroClass heroClass) {
        if (heroClass == null) {
            throw new IllegalArgumentException("heroClass cannot be null");
        }
        if (classes.contains(heroClass)) {
            return;
        }
        if (heroClass.equals(HeroClass.BERSERK)) {
            rage = 100;
        }
        if (heroClass.equals(HeroClass.MAGE)) {
            mana = 100;
        }
        if (heroClass.equals(HeroClass.RANGER)) {
            arrows = 10;
        }
        classes.add(heroClass);
    }

    public void removeClass(HeroClass heroClass) {
        if (heroClass == null) {
            throw new IllegalArgumentException("heroClass cannot be null");
        }
        if (classes.size() == 1 && classes.contains(heroClass)) {
            throw new IllegalArgumentException("hero must have at least one class");
        }
        if (heroClass.equals(HeroClass.BERSERK)) {
            rage = 0;
        }
        if (heroClass.equals(HeroClass.MAGE)) {
            mana = 0;
        }
        if (heroClass.equals(HeroClass.RANGER)) {
            arrows = 0;
        }
        classes.remove(heroClass);
    }

    public void performBestCombo() {
        System.out.println(name + " Combo:");
        if (classes.contains(HeroClass.BERSERK)) {
            charge();
        }
        if (classes.contains(HeroClass.MAGE)) {
            fireball();
        }
        if (classes.contains(HeroClass.RANGER)) {
            bowShot();
        }
    }

    public void charge() {
        if (classes.contains(HeroClass.BERSERK) && rage >= 10) {
            System.out.println(name + " Charge");
            rage -= 10;
        }
    }

    public void fireball() {
        if (classes.contains(HeroClass.MAGE) && mana >= 10) {
            System.out.println(name + " Fireball");
            mana -= 10;
        }
    }

    public void bowShot() {
        if (classes.contains(HeroClass.RANGER) && arrows >= 1) {
            System.out.println(name + " Bow shot");
            arrows--;
        }
    }

    public int getRage() {
        return rage;
    }

    public int getMana() {
        return mana;
    }

    public int getArrows() {
        return arrows;
    }
}
