package lab05.ex3;

import java.util.List;

public class Movie {
    private final String title;
    private final int year;
    private final Person director;
    private final Person writer;
    private final String series;
    private final List<Person> cast;
    private final List<Place> locations;
    private final List<String> languages;
    private final List<String> genres;
    private final boolean isTelevision;
    private final boolean isNetflix;
    private final boolean isIndependent;

    public static class Builder {

        private final String movieTitle;

        private int movieYear = 0;
        private Person movieDirector = null;
        private Person movieWriter = null;
        private String movieSeries = null;
        private List<Person> movieCast = null;
        private List<Place> movieLocations = null;
        private List<String> movieLanguages = null;
        private List<String> movieGenres = null;

        private boolean television;
        private boolean netflix;
        private boolean independent;

        public Builder(String title) {
            this.movieTitle = title;
        }

        public Builder movieYear(int ano) {
            movieYear = ano;
            return this;
        }

        public Builder movieDirector(Person pessoa) {
            movieDirector = pessoa;
            return this;
        }

        public Builder movieWriter(Person pessoa) {
            movieWriter = pessoa;
            return this;
        }

        public Builder movieSeries(String serie) {
            movieSeries = serie;
            return this;
        }

        public Builder movieCast(List<Person> elenco) {
            movieCast = elenco;
            return this;
        }

        public Builder movieLocations(List<Place> local) {
            movieLocations = local;
            return this;
        }

        public Builder movieLanguages(List<String> languages) {
            movieLanguages = languages;
            return this;
        }

        public Builder movieGenres(List<String> genres) {
            movieGenres = genres;
            return this;
        }

        public Builder televison(boolean tv) {
            television = tv;
            return this;
        }

        public Builder netflix(boolean nextflix) {
            this.netflix = nextflix;
            return this;
        }

        public Builder independent(boolean independent) {
            this.independent = independent;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }

    private Movie(Builder builder) {
        title = builder.movieTitle;
        year = builder.movieYear;
        director = builder.movieDirector;
        writer = builder.movieWriter;
        series = builder.movieSeries;
        cast = builder.movieCast;
        locations = builder.movieLocations;
        languages = builder.movieLanguages;
        genres = builder.movieGenres;
        isTelevision = builder.television;
        isNetflix = builder.netflix;
        isIndependent = builder.independent;
    }

    @Override
    public String toString() {
        String str = "Title: " + title + ";";

        if (year != 0) {
            str += " Ano: " + year + ";";
        }
        if (director != null) {
            str += " Diretor: " + director + ";";
        }
        if (writer != null) {
            str += " Writer: " + writer + ";";
        }
        if (series.length() != 0) {
            str += " Series: " + series + ";";
        }
        if (cast != null) {
            str += " Cast: " + cast + ";";
        }
        if (locations != null) {
            str += " Locations: " + locations + ";";
        }
        if (languages != null) {
            str += " Languages: " + languages + ";";
        }
        if (genres != null) {
            str += " Genres: " + genres + ";";
        }
        if (isTelevision) {
            str += " Televison; ";
        }
        if (isNetflix) {
            str += " Nextflix; ";
        }
        if (isIndependent) {
            str += " Independente.";
        }

        return str;
    }

}