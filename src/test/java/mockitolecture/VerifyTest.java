package mockitolecture;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class VerifyTest {

    @Test
    void demo(){
        //listen würde man normalerweise nicht mocken
        List<String> mockedList = mock();

        mockedList.add("one");
        mockedList.clear();

        verify(mockedList).add("one");
        verify(mockedList).clear();
    }
}
