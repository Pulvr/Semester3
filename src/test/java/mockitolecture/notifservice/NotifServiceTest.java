package mockitolecture.notifservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class NotifServiceTest {

    /**
     * Verwende Mockito, um ein Mock-Objekt von NotificationService zu erstellen.
     * Übergebe dieses Mock-Objekt über den Konstruktor von OrderService (Dependency Injection).
     * Schreibe einen Test, der die Methode placeOrder() aufruft und überprüft,
     * ob die sendNotification()-Methode des NotificationService der korrekten Nachricht aufgerufen wurde.
     * */

    private NotificationService mockedNotificationService;

    @BeforeEach
    void setup(){
        mockedNotificationService = mock();
    }

    @Test
    void notificationServiceOnOrderTest() {
        OrderService orderService = new OrderService(mockedNotificationService);
        orderService.placeOrder("SchokoChips");
        verify(mockedNotificationService).sendNotification(eq("Order placed for: SchokoChips"));
    }
}