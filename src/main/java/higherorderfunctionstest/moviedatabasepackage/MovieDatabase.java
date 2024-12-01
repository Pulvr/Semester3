package higherorderfunctionstest.moviedatabasepackage;

import java.util.Collection;
import java.util.List;

public class MovieDatabase {
    private static List<Movie> movies;

    MovieDatabase(List<Movie> movies){
        MovieDatabase.movies = movies;
    }

    void forEach(Movie movie) {
    }

    Collection<Movie> findByCategory(Movie movie) {
        return List.of();
    }
}
