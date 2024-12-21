package recursiontasks.filesystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemElementTest {

    Directory dir1 = new Directory("dir1");
    Directory dir2 = new Directory("dir2");
    Directory dir3 = new Directory("dir3");
    Directory dir4 = new Directory("dir4");
    File file1 = new File("file1", 5);
    File file2 = new File("file2", 10);
    File file3 = new File("file3", 20);

    @BeforeEach
    void setup() {
        dir1.add(file1, dir2);
        dir2.add(dir3, dir4);
        dir3.add(file2, file3);
    }

    @Test
    void fetchSize() {
        long actual = dir1.fetchSize();
        assertEquals(35, actual);
    }

    @Test
    void fetchSize2() {
        long actual = dir3.fetchSize();
        assertEquals(30, actual);
    }

    @Test
    void fetchSize3() {
        long actual = dir4.fetchSize();
        assertEquals(0, actual);
    }

    @Test
    void fetchSize4() {
        long actual = file2.fetchSize();
        assertEquals(10, actual);
    }

    @Test
    void contains() {
        boolean actual = dir1.contains(file1);
        assertTrue(actual);
    }

    @Test
    void contains2() {
        boolean actual = dir1.contains(file2);
        assertTrue(actual);
    }

    @Test
    void contains3() {
        boolean actual = file1.contains(file1);
        assertFalse(actual);
    }

    @Test
    void contains4() {
        boolean actual = dir2.contains(dir4);
        assertTrue(actual);
    }

    @Test
    void addNull() {
        boolean actual = dir1.add((FileSystemElement) null);
        assertFalse(actual);
    }

    @Test
    void remove() {
        boolean wasAdded = dir1.contains(file1);
        assertTrue(wasAdded);
        assertTrue(dir1.contains(file1));

        boolean wasRemoved = dir1.remove(file1);
        assertTrue(wasRemoved);
        assertFalse(dir1.contains(file1));
    }

    @Test
    void dir1Elements(){
        var actual = dir1.elements();
        var expected = List.of(dir1,file1,dir2,dir3,file2,file3,dir4);

        for(FileSystemElement element : actual){
            System.out.print(element.name+", ");
        }

        assertIterableEquals(expected,actual);
    }

    @Test
    void dir3Elements(){
        var actual = dir3.elements();
        var expected = List.of(dir3,file2,file3);

        for(FileSystemElement element : actual){
            System.out.print(element.name+", ");
        }

        assertIterableEquals(expected,actual);
    }

    @Test
    void file1Elements(){
        var actual = file1.elements();
        var expected = List.of(file1);

        assertIterableEquals(expected,actual);
    }

}