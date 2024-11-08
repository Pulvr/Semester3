package org.unittest.playstore;

import java.io.IOException;
import java.util.List;

public interface PlaystoreDatabase {
    List<PlaystoreGame> findGamesByName(String name) throws IOException;
}
