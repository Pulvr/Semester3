package recursiontasks.filesystem;

import java.util.Collection;
import java.util.List;

class File extends FileSystemElement {

    private final long size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    long fetchSize() {
        return size;
    }

    @Override
    boolean contains(FileSystemElement element) {
        return false;
    }

    @Override
    Collection<FileSystemElement> elements() {
        FileSystemElement file = this;
        return List.of(file);
    }
}