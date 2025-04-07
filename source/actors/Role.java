package actors;

/**
 * Represents a role that a survivor can have in the game.
 */
public class Role {
    private String roleName;

    /**
     * Constructs a role with the specified name.
     * @param roleName The name of the role.
     */
    public Role(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Gets the name of the role.
     * @return The name of the role.
     */
    public String getRoleName() {
        return roleName;
    }
}
