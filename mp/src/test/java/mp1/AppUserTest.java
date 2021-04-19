package mp1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AppUserTest {

    @BeforeEach
    void setUp() {
        AppUser.clear();
    }

    @Test
    void constructor() {
        assertThrows(IllegalArgumentException.class, () -> new AppUser(null));
        assertThrows(IllegalArgumentException.class, () -> new AppUser(""));
        assertThrows(IllegalArgumentException.class, () -> new AppUser("               "));
        assertThrows(IllegalArgumentException.class, () -> new AppUser("a"));
        AppUser appUserTrimmedLoginName = new AppUser("   loginName  \n  ");
        assertEquals("loginName", appUserTrimmedLoginName.getLoginName());
        assertThrows(IllegalArgumentException.class, () -> new AppUser("loginName"));
    }

    @Test
    void setFirstName() {
        AppUser appUser = new AppUser("loginName");
        assertThrows(IllegalArgumentException.class, () -> appUser.setFirstName(""));
        assertThrows(IllegalArgumentException.class, () -> appUser.setFirstName("               "));
        appUser.setFirstName("         Name      \n     ");
        assertEquals("Name", appUser.getFirstName());
        appUser.setFirstName(null);
        assertNull(appUser.getFirstName());
    }

    @Test
    void setLastName() {
        AppUser appUser = new AppUser("loginName");
        assertThrows(IllegalArgumentException.class, () -> appUser.setLastName(""));
        assertThrows(IllegalArgumentException.class, () -> appUser.setLastName("               "));
        appUser.setLastName("         Name      \n     ");
        assertEquals("Name", appUser.getLastName());
        appUser.setLastName(null);
        assertNull(appUser.getLastName());
    }

    @Test
    void getFullName() {
        AppUser appUser1 = new AppUser("loginName");
        assertThrows(Exception.class, appUser1::getFullNameCapitalised);
        AppUser appUser2 = new AppUser("loginName2", "firstName", "lastName");
        try {
            assertEquals("FIRSTNAME LASTNAME", appUser2.getFullNameCapitalised());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void getExtent() {
        AppUser appUser1 = new AppUser("loginName1");
        AppUser appUser2 = new AppUser("loginName2");
        Set<AppUser> extent = AppUser.getExtent();
        assertEquals(2, extent.size());
        assertTrue(extent.contains(appUser1));
        assertTrue(extent.contains(appUser2));
    }

    @Test
    void delete() {
        AppUser appUser1 = new AppUser("loginName1");
        AppUser appUser2 = new AppUser("loginName2");
        Set<AppUser> extent = AppUser.getExtent();
        assertEquals(2, extent.size());
        assertTrue(extent.contains(appUser1));
        assertTrue(extent.contains(appUser2));
        AppUser.delete(appUser2);
        Set<AppUser> extent2 = AppUser.getExtent();
        assertEquals(1, extent2.size());
        assertTrue(extent2.contains(appUser1));
        assertFalse(extent2.contains(appUser2));
    }

    @Test
    void clear() {
        AppUser appUser1 = new AppUser("loginName1");
        AppUser appUser2 = new AppUser("loginName2");
        Set<AppUser> extent = AppUser.getExtent();
        assertEquals(2, extent.size());
        AppUser.clear();
        Set<AppUser> extent2 = AppUser.getExtent();
        assertEquals(0, extent.size());
    }

    @Test
    void findByLoginName() {
        AppUser appUser1 = new AppUser("loginName1");
        AppUser appUser2 = new AppUser("loginName2");
        assertTrue(AppUser.findByLoginName(null).isEmpty());
        assertTrue(AppUser.findByLoginName("").isEmpty());
        Optional<AppUser> appUserOptional = AppUser.findByLoginName("loginName1");
        assertFalse(appUserOptional.isEmpty());
        assertEquals("loginName1", appUserOptional.get().getLoginName());
    }

    @Test
    void saveAndLoadExtent() {
        AppUser appUser1 = new AppUser("loginName1");
        AppUser appUser2 = new AppUser("loginName2");
        AppUser.saveExtent();
        assertEquals(2, AppUser.getExtent().size());
        AppUser.clear();
        assertEquals(0, AppUser.getExtent().size());
        AppUser.loadExtent();
        assertEquals(2, AppUser.getExtent().size());
        assertTrue(AppUser.getExtent().contains(appUser1));
        assertTrue(AppUser.getExtent().contains(appUser2));
    }
}