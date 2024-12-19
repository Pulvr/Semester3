package recursiontasks;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SumListTest {

    @Test
    void testSum(){
        double result = SumList.sum(List.of(0.0,1.0,2.0,3.0,4.0,5.0));
        assertEquals(15.0 , result,0.00001);
    }

    @Test
    void testSumEmpty(){
        double result = SumList.sum(List.of());
        assertEquals(0.0,result,0.00001);
    }
}