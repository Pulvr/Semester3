package recursiontasks.filesystem;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Directory extends FileSystemElement {

    private final List<FileSystemElement> elements = new ArrayList<>();


    public Directory(String name, FileSystemElement... elements) {
        super(name);
        add(elements);
    }

    boolean add(FileSystemElement... elements) {
        for (FileSystemElement element : elements) {
            add(element);
        }
        return elements.length > 0;
    }

    boolean add(FileSystemElement element) {
        // Fail Fast Principle
        if(element == null) {
            return false;
        }

        return elements.add(element);
    }

    boolean remove(FileSystemElement element) {
        return elements.remove(element);
    }

    @Override
    long fetchSize() {
        long size = 0;
        for (FileSystemElement child : elements) {
            size += child.fetchSize();
        }
        return size;
    }

    @Override
    boolean contains(FileSystemElement element) {
        for (FileSystemElement child : elements) {
            boolean childHasElement = child.equals(element) || child.contains(element);
            if(childHasElement) {
                return true;
            }
        }
        return false;
    }

    @Override
    Collection<FileSystemElement> elements() {

        List<FileSystemElement> allElements = new ArrayList<>();
        allElements.add(this);

        for(FileSystemElement element : elements){
            allElements.add(element);
            if (element.getClass().equals(Directory.class)){
                return element.elements();
            }
        }
        return allElements;
    }
}