package recursiontasks.filesystem;

import java.util.Collection;

abstract class FileSystemElement {

    protected final String name;

    FileSystemElement(String name) {
        this.name = name;
    }

    abstract long fetchSize();

    abstract boolean contains(FileSystemElement element);

    abstract Collection<FileSystemElement> elements();
}