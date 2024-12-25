package callbacks.studentchange;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student(1, "Dennis");
    }

    @Test
    void getSetId() {
        student.setId(2);
        assertEquals(2, student.id());
    }

    @Test
    void getSetName() {
        student.setName("Dennis Ritchie");
        assertEquals("Dennis Ritchie", student.name());
    }

    @Test
    void toStringWithIdAndName() {
        var actual = student.toString();
        assertEquals("Student{id=1, name='Dennis'}", actual);
    }

    @Test
    void changeStudentIdTest() {
        student.subscribeOnModified(student ->
                assertEquals(3, student.id())
        );
        student.setId(3);
    }

    @Test
    void changeStudentNameTest() {
        student.subscribeOnModified(student ->
                assertEquals("Linus Ritchie", student.name())
        );
        student.setName("Linus Ritchie");
    }
}