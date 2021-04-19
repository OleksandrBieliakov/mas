package mp1;

import java.io.*;
import java.util.*;

public class AppUser implements Serializable {

    private static final String EXTENT_PERSISTENCE_PATH = "data/AppUser.ser";

    // extent
    private static final Set<AppUser> extent = new HashSet<>();

    // class attribute
    private static int MIN_LOGIN_NAME_LENGTH = 5;

    // mandatory
    private String loginName;
    // optional
    private String firstName;
    // optional
    private String lastName;

    // complex attribute
    private AppUserSettings appUserSettings = new AppUserSettings();

    // multi-value attribute
    private final Set<String> knownRealLifeNicknames = new HashSet<>();

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
    public String getFullNameCapitalised() throws Exception {
        if (firstName == null || lastName == null) {
            throw new Exception("first name or/and last name is missing");
        }
        if (appUserSettings.isPrivateFirstLastName()) {
            throw new Exception("first and list name are private");
        }
        return firstName.toUpperCase(Locale.ROOT) + " " + lastName.toUpperCase(Locale.ROOT);
    }

    // class method
    public static Optional<AppUser> findByLoginName(String loginName) {
        if(loginName == null || invalidLoginNameLength(loginName.trim())) {
            return Optional.empty();
        }
        return extent.stream().filter(appUser -> appUser.loginName.equals(loginName)).findAny();
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


    public static void delete(AppUser appUser) {
        if(appUser != null) {
            extent.remove(appUser);
        }
    }
    public static void clear() {
        extent.clear();
    }

    private static boolean invalidLoginNameLength(String loginName) {
        return loginName.length() < MIN_LOGIN_NAME_LENGTH;
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

    public AppUserSettings getAppUserSettings() {
        return appUserSettings;
    }

    public void setAppUserSettings(AppUserSettings appUserSettings) {
        if (appUserSettings == null) {
            throw new IllegalArgumentException("appUserSettings must not be null");
        }
        this.appUserSettings = appUserSettings;
    }

    public Set<String> getKnownRealLifeNicknames() {
        return Collections.unmodifiableSet(knownRealLifeNicknames);
    }

    public void addNickName(String nickname) {
        if(nickname == null) {
            throw new IllegalArgumentException("nickname must not be null");
        }
        knownRealLifeNicknames.add(nickname);
    }

    public void removeNickName(String nickname) {
        if(nickname == null) {
            return;
        }
        knownRealLifeNicknames.remove(nickname);
    }

    public static int getMinLoginNameLength() {
        return MIN_LOGIN_NAME_LENGTH;
    }

    public static void setMinLoginNameLength(int minLoginNameLength) {
        if(minLoginNameLength < 1) {
            throw new IllegalArgumentException("minLoginNameLength must 1 or greater");
        }
        MIN_LOGIN_NAME_LENGTH = minLoginNameLength;
    }
}
