package mockitolecture.productservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    /**
     * Erstelle ein Mock-Objekt von ProductService.
     * Simuliere verschiedene Rückgabewerte für die Methode getProductDetails(String productId):
     * 1. Wenn die Produkt-ID „123“ ist, gib "Product found." zurück.
     * 2. Für alle anderen IDs gib "Product not found." zurück.
     * Schreibe entsprechende Testfälle.
     **/
    ProductService mockedProduct;

    @BeforeEach
    void setup(){
        mockedProduct = mock();
    }

    @Test
    void getProductDetailsProduct123() {
        when(mockedProduct.getProductDetails("123")).thenReturn("Product found");
        assertEquals("Product found", mockedProduct.getProductDetails("123"));
    }

    @Test
    void getProductDetailsAnyProduct(){
        when(mockedProduct.getProductDetails(anyString())).thenReturn("Product not found");
        assertEquals("Product not found", mockedProduct.getProductDetails("111"));
    }
}