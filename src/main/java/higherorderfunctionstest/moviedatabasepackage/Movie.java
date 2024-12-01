package higherorderfunctionstest.moviedatabasepackage;


import java.util.Arrays;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

class Movie {

    private final String name;
    private final Set<Category> categories;

    Movie(String name,Category...categories){
        this.name = name;
        this.categories = EnumSet.copyOf(Arrays.asList(categories));
    }

    String name(){
        return name;
    }

    boolean hasCategory(Category category){
        return categories.contains(category);
    }

    @Override
    public final boolean equals(Object object){
        if(this==object) return true;
        if(!(object instanceof Movie movie)) return false;
        return Objects.equals(name,movie.name) &&
                Objects.equals(categories,movie.categories);
    }

    @Override
    public int hashCode(){
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(categories);
        return result;
    }

    @Override
    public String toString(){
        return "%s %s".formatted(name,categories);
    }
}
