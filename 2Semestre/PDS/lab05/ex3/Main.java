package lab05.ex3;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Person diretor = new Person("Eva Bartolomeu");
        Person writer = new Person("Dani Figueiredo");
        Person elenco1 = new Person("Pedro Sobral");
        Person elenco2 = new Person("Andre Freixo");
        List<Person> elenco = new ArrayList<>();
        elenco.add(elenco1);
        elenco.add(elenco2);
        Place lugar1 = new Place(40.5767, -5.7653);
        Place lugar2 = new Place(39.5665, 3.3487);
        List<Place> locations = new ArrayList<>();
        locations.add(lugar1);
        locations.add(lugar2);
        String lang1 = "Portuguese";
        String lang2 = "Chinese";
        List<String> languages = new ArrayList<>();
        languages.add(lang1);
        languages.add(lang2);
        List<String> genres = new ArrayList<>();
        String genre1 = "Horror";
        String genre2 = "Action";
        genres.add(genre1);
        genres.add(genre2);
        

        Movie piratasDasCaraibas = new Movie.Builder("Pirata das Caraíbas - Versão Tuga").movieYear(2021).movieDirector(diretor).movieWriter(writer).movieSeries("Pelos mares de Portugal").movieCast(elenco).movieLocations(locations).movieLanguages(languages).movieGenres(genres).televison(true).netflix(true).independent(false).build();

        System.out.println(piratasDasCaraibas);
    }
}
