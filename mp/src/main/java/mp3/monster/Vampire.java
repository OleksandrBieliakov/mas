package mp3.monster;

public interface Vampire {

    default void suckHumanJuice() {
        System.out.println("Om nom nom");
    }
}
