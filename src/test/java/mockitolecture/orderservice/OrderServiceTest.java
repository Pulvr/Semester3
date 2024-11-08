package mockitolecture.orderservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class OrderServiceTest {

    /**
     * Erstelle ein Mock-Objekt von OrderService.
     * Simuliere einen Test, bei dem eine Bestellung aufgegeben wird. *
     * Prüfe, ob der placeOrder mit einem bestimmten Order-Object aufgerufen wurde.
     * */

    OrderService mockedOrderService;

    @BeforeEach
    void setup(){
        mockedOrderService = mock();
    }

    @Test
    void placeOrderTest() {
        Order myOrder = new Order("Rosinen",200);
        mockedOrderService.placeOrder(myOrder);
        verify(mockedOrderService).placeOrder(eq(myOrder));
    }
}