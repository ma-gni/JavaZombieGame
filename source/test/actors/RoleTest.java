package test.actors;
import actors.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoleTest {

    @Test
    public void testRoleConstructor() {
        Role role = new Role("Warrior");

        assertEquals("Warrior", role.getRoleName());
    }
}
