package mp1;

import java.io.Serializable;

public class AppUserSettings implements Serializable {

    private boolean active = true;
    private boolean openToInvites = true;
    private boolean privateFirstLastName = false;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isOpenToInvites() {
        return openToInvites;
    }

    public void setOpenToInvites(boolean openToInvites) {
        this.openToInvites = openToInvites;
    }

    public boolean isPrivateFirstLastName() {
        return privateFirstLastName;
    }

    public void setPrivateFirstLastName(boolean privateFirstLastName) {
        this.privateFirstLastName = privateFirstLastName;
    }
}
