package mockitolecture;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CalculatorTest {

    @Test
    void addAlwaysReturnTen() {
    Calculator mockedCalc = mock();
    when(mockedCalc.add(anyInt(),anyInt())).thenReturn(10);

    System.out.println(mockedCalc.add(2,3));
    System.out.println(mockedCalc.add(-2,0));

    }
}