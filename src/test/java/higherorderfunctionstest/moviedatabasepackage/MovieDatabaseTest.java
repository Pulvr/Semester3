package higherorderfunctionstest.moviedatabasepackage;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

class MovieDatabaseTest {
    private static final List<Movie> MOVIES = List.of(
            new Movie("The Godfather", Category.DRAMA),
            new Movie("Toy Story", Category.COMEDY),
            new Movie("Guardians of the Galaxy", Category.ACTION, Category.COMEDY, Category.SCIFI),
            new Movie("Titanic", Category.DRAMA, Category.ROMANCE),
            new Movie("The Dark Knight", Category.ACTION, Category.DRAMA),
            new Movie("Finding Nemo", Category.COMEDY, Category.DRAMA),
            new Movie("Interstellar", Category.SCIFI, Category.DRAMA),
            new Movie("Alien", Category.SCIFI, Category.HORROR),
            new Movie("Terminator", Category.SCIFI, Category.ACTION),
            new Movie("Dune", Category.SCIFI, Category.ACTION, Category.DRAMA)
    );

    private final MovieDatabase movieDatabase = new MovieDatabase(MOVIES);

    @Test
    void forEachCallsLambdaWithEachMovie(){
        List<Movie> movies = new LinkedList<>();

        movieDatabase.forEach(movie->{
            movies.add(movie); // This is not a pure lambda, but okay for this testcase, otherwise forEach not testable
            // Note: lambda returns void
        });

        assertThat(movies).containsExactlyElementsIn(MOVIES);
    }

    @Test
    void findMoviesByCategory(){
        Collection<Movie> actual = movieDatabase.findByCategory(movie -> movie.hasCategory(Category.SCIFI) &&
                                                                        movie.hasCategory(Category.ACTION));
        assertThat(actual).containsExactly(List.of(
                new Movie("Guardians of the Galaxy", Category.ACTION, Category.SCIFI, Category.COMEDY),
                new Movie("Terminator", Category.ACTION, Category.SCIFI),
                new Movie("Dune", Category.ACTION, Category.SCIFI, Category.DRAMA)
        ));
    }

}