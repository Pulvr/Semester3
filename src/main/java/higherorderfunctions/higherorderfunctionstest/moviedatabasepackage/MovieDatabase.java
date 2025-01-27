package higherorderfunctions.higherorderfunctionstest.moviedatabasepackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MovieDatabase {
    private static List<Movie> movies = new ArrayList<>();

    MovieDatabase(List<Movie> movies) {
        MovieDatabase.movies = movies;
    }

    void forEach(Consumer<Movie> action) {
        for (Movie movie : movies) {
            action.accept(movie);
        }
    }

    Collection<Movie> findByCategory(Predicate<Movie> predicate) {
        Collection<Movie> moviesOfCategory = new ArrayList<>();
        for (Movie movie : movies) {
            if (predicate.test(movie)) {
                moviesOfCategory.add(movie);
            }
        }
        return moviesOfCategory;
    }
}
