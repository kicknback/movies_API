package data;

//import data.movies.InMemoryMoviesDao;
//import data.movies.MoviesDao;
//import data.movies.MySqlMoviesDao;

public class DaoFactory {

    private static MoviesDao moviesDao;

    private static final Config config = new Config();
    public enum ImplType {MYSQL, IN_MEMORY};

    //Notice we have two values here

    public static MoviesDao getMoviesDao(ImplType implementationType) {

        switch (implementationType) {
            case MYSQL: {
                if (moviesDao == null) {
                    moviesDao = new MySqlMoviesDao(config);
                }
            }
            case IN_MEMORY: {
                if (moviesDao == null) {
                    moviesDao = new InMemoryMoviesDao();
                }
            }
        }
        return moviesDao;
    }
}