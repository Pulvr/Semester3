package mockitolecture.paymentservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class PaymentServiceTest {

    /**
     * Erstelle ein Mock-Objekt von PaymentService.
     * Simuliere, dass die Methode processPayment() eine PaymentException auslöst, wenn der Betrag gleich 1001 ist.
     * Schreibe einen Test, der prüft, ob die Exception korrekt geworfen wird.
     * Bonusaufgabe:
     * Schreibe den Test so um, dass der Mock eine Exception wirft, sobald eine ein Betrag größer als 1000 übergeben wird.
     */

    @Test
    void processPaymentTestWith1001Money() {
        PaymentService mockedPaymentService = mock();

        //doThrow(new PaymentException("Darf nicht über 1000 sein")).when(mockedPaymentService).processPayment(anyString(),eq(1001.0));
        when(mockedPaymentService.processPayment(anyString(),eq(1001.0))).thenThrow(new PaymentException("Darf nicht über 1000 sein"));

        assertThrows(PaymentException.class, () -> mockedPaymentService.processPayment("123",1001.0));
    }
}