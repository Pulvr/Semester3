package mockitolecture.userservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {
    /**
     * Erstelle ein Mock-Objekt von UserService.
     * Schreibe einen Test, der prüft, ob die Methode saveUser() aufgerufen wurde,
     * egal welche Argumente übergeben werden.
     **/
    @Test
    void storeUserTest() {
        UserService mockedUserService = mock();
        mockedUserService.storeUser(any());
        verify(mockedUserService).storeUser(any());
    }

    /**
     * Erstelle ein Mock-Objekt von User und speichere ihn in ein ungemockten UserService.
     * Schreibe einen Test, der prüft, ob der gemockte User im UserService gespeichert wurde und
     * ob die Methode name() von dem gemockten User aufgerufen wurde.
     **/
    @Test
    void getMockedUserInUserService() {
        User mockedUser = mock();
        UserService userService = new UserService();

        userService.storeUser(mockedUser);

        //assertequals weil ich den mockeduser im userservice testen will.
        assertEquals(mockedUser, userService.getStoredUser());

        //verifizieren, dass name() aufgerufen wird.
        verify(mockedUser).name();
    }
}