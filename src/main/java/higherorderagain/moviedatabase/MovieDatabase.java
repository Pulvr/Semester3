package higherorderagain.moviedatabase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

class MovieDatabase {
    final List<Movie> movies;

    public MovieDatabase(List<Movie> movies) {
        this.movies = movies;
    }

    public void forEach(Consumer<Movie> consumer) {
        for (Movie movie : movies) {
            consumer.accept(movie);
        }
    }

    public Collection<Movie> findByCategory(Predicate<Movie> predicate) {
        Collection<Movie> foundMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (predicate.test(movie)) {
                foundMovies.add(movie);
            }
        }
        return foundMovies;
    }

}
