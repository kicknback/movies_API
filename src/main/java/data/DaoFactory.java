package data;

//import data.movies.InMemoryMoviesDao;
//import data.movies.MoviesDao;
//import data.movies.MySqlMoviesDao;

public class DaoFactory {

    private static MoviesDao moviesDao;

    private static Config config = new Config();
    public enum ImplType {MYSQL, IN_MEMORY}

    ; //Notice we have two values here

    public static MoviesDao getMoviesDao(ImplType implementationType) {

        switch (implementationType) {
            case MYSQL: {               //yet we have one switch case. We'll get to that!
                if (moviesDao == null) {
//                    moviesDao = new InMemoryMoviesDao();
                    moviesDao = new MySqlMoviesDao(config);
                }
            }
        }
        return moviesDao;
    }
}