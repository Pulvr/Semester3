package recursiontasks;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SumListGenericsTest {

    @Test
    void sumTestInteger() {
        double result = SumListGenerics.sum(List.of(0,1,2,3,4,5));
        assertEquals(15.0 , result,0.00001);
    }
}