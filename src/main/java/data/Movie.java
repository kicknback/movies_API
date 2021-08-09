package data;

public class Movie {

    private int id;
    private String poster;
    private String title;
    private String rating;
    private String plot;
    private String director;
    private String actors;
    private String genre;
    private String year;

    public Movie(int id, String poster, String title,
                 String rating, String plot, String director,
                 String actors, String genre, String year) {
        this.id = id;
        this.poster = poster;
        this.title = title;
        this.rating = rating;
        this.plot = plot;
        this.director = director;
        this.actors = actors;
        this.genre = genre;
        this.year = year;
    }

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
