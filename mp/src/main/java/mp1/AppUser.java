package mp1;

import java.io.*;
import java.util.*;

public class AppUser implements Serializable {

    // extent
    private static final Set<AppUser> extent = new HashSet<>();
    // class attribute
    private static final String EXTENT_PERSISTENCE_PATH = "data/AppUser.ser";
    // class attribute
    private static final int MIN_LOGIN_NAME_LENGTH = 5;

    // mandatory
    private String loginName;
    // optional
    private String firstName;
    // optional
    private String lastName;

    // complex attribute
    private AppUser father;
    // complex attribute
    private AppUser mother;

    // multi-value attribute
    private final Set<AppUser> friends = new HashSet<>();

    public AppUser(String loginName) {
        setLoginName(loginName);
        extent.add(this);
    }

    // method overloading
    public AppUser(String loginName, String firstName, String lastName) {
        setLoginName(loginName);
        setFirstName(firstName);
        setLastName(lastName);
        extent.add(this);
    }

    // extent persistence
    public static void saveExtent() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(EXTENT_PERSISTENCE_PATH))) {
            oos.writeObject(extent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // extent persistence
    public static void loadExtent() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(EXTENT_PERSISTENCE_PATH))) {
            extent.addAll((Collection<? extends AppUser>) ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // derived attribute
    public String getFullName() throws Exception {
        if (firstName == null || lastName == null) {
            throw new Exception("first name or/and last name is missing");
        }
        return firstName + " " + lastName;
    }

    // class method
    public static Optional<AppUser> findByLoginName(String loginName) {
        if(loginName == null || invalidLoginNameLength(loginName.trim())) {
            return Optional.empty();
        }
        return extent.stream().filter(appUser -> appUser.loginName.equals(loginName)).findAny();
    }
    // class method
    public static void delete(AppUser appUser) {
        if(appUser != null) {
            extent.remove(appUser);
        }
    }
    // class method
    public static void clear() {
        extent.clear();
    }

    // class method
    private static boolean invalidLoginNameLength(String loginName) {
        return loginName.length() < MIN_LOGIN_NAME_LENGTH;
    }

    // method overriding
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUser)) return false;

        AppUser appUser = (AppUser) o;

        return getLoginName().equals(appUser.getLoginName());
    }

    // method overriding
    @Override
    public int hashCode() {
        return getLoginName().hashCode();
    }

    public static Set<AppUser> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    public String getLoginName() {
        return loginName;
    }

    private void setLoginName(String loginName) {
        if (loginName == null) {
            throw new IllegalArgumentException("login name must not be null");
        }
        String trimmedLoginName = loginName.trim();
        if (invalidLoginNameLength(trimmedLoginName)) {
            throw new IllegalArgumentException("invalid login name length");
        }
        if (findByLoginName(trimmedLoginName).isPresent()) {
            throw new IllegalArgumentException("appUser with such login name already exists");
        }
        this.loginName = trimmedLoginName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            this.firstName = null;
            return;
        }
        String trimmedFirstName = firstName.trim();
        if (trimmedFirstName.isEmpty()) {
            throw new IllegalArgumentException("first name must not be blank");
        }
        this.firstName = trimmedFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            this.lastName = null;
            return;
        }
        String trimmedLastName = lastName.trim();
        if (trimmedLastName.isEmpty()) {
            throw new IllegalArgumentException("last name must not be blank");
        }
        this.lastName = trimmedLastName;
    }

    public AppUser getFather() {
        return father;
    }

    public void setFather(AppUser father) {
        this.father = father;
    }

    public AppUser getMother() {
        return mother;
    }

    public void setMother(AppUser mother) {
        this.mother = mother;
    }

    public Set<AppUser> getFriends() {
        return Collections.unmodifiableSet(friends);
    }

    public void addFriend(AppUser appUser) {
        if (appUser != null) {
            friends.add(appUser);
        }
    }

    public void removeFriend(AppUser appUser) {
        if (appUser != null) {
            friends.remove(appUser);
        }
    }
}
